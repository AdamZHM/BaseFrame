package com.shdata.ai.meilong.standalone.dataanalysis.util;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Map;
import java.util.Set;

/**
 * @author zhufkt
 * @date 2020/11/30
 */

@Component
@Log4j2
public class RestUtil {

    final private RestTemplate m_restTemplate;
    final private RestTemplate m_restTemplateDisableSSLVerification;
    final private Validator m_validator;


    @Autowired
    public RestUtil(RestTemplate restTemplate, RestTemplate restTemplateDisableSSLVerification) {
        this.m_restTemplate = restTemplate;
        this.m_restTemplateDisableSSLVerification = restTemplateDisableSSLVerification;
        this.m_validator = Validation.buildDefaultValidatorFactory().getValidator();

    }

    public <T> T get(String url, ParameterizedTypeReference<T> responseType) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        return this.get(url, responseType, requestHeaders);
    }

    public <T> T get(String url, ParameterizedTypeReference<T> responseType, HttpHeaders requestHeaders) {
        return this.exchange(url, null, HttpMethod.GET, responseType, requestHeaders);
    }

    public <T> T post(String url, Map<String, String> jsonBody, ParameterizedTypeReference<T> responseType) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        return this.post(url, jsonBody, responseType, requestHeaders);
    }

    public <T> T post(String url, Map<String, String> jsonBody, ParameterizedTypeReference<T> responseType, HttpHeaders requestHeaders) {
        return this.exchange(url, jsonBody, HttpMethod.POST, responseType, requestHeaders);
    }

    private <T> T exchange(String url, Map<String, String> jsonBody, HttpMethod method, ParameterizedTypeReference<T> responseType, HttpHeaders requestHeaders) {

        log.info("Ready to invoke RestUtil.exchange: url {}, jsonBody {}, method: {}", url, jsonBody, method);

        HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(jsonBody, requestHeaders);

        RestTemplate currentRestTemplate = m_restTemplate;
        if(url.trim().startsWith("https"))
        {
            log.info("SSL is enabled for this URL. Ready to disable SSL verification and checking...");
            currentRestTemplate = m_restTemplateDisableSSLVerification;
        }

        ResponseEntity<T> responseEntity = currentRestTemplate.exchange(url,
                method,
                httpEntity,
                responseType);
        T responseObject = responseEntity.getBody();

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            log.info(
                    "Invoked done for RestUtil.exchange: url {}, jsonBody {}, method: {} responseObject: {}",
                    url, jsonBody, method, responseObject);

            final Set<ConstraintViolation<T>> violations = m_validator.validate(responseObject);
            if (violations.isEmpty()) {
                return responseObject;
            }
            else
            {
                log.error("Validation failed for responseObject: {}", responseObject);
                throw new ConstraintViolationException(violations);
            }
        } else {
            String msg = String.format("Failed to invoke RestUtil.exchange: url %s, jsonBody %s, method: %s, responseObject %s",
                    url, jsonBody, method, responseObject);
            throw new RuntimeException(msg);
        }
    }

}
