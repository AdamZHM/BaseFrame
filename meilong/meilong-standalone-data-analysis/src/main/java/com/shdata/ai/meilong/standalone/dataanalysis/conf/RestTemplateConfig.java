package com.shdata.ai.meilong.standalone.dataanalysis.conf;

import lombok.extern.log4j.Log4j2;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.TrustStrategy;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.zalando.logbook.spring.LogbookClientHttpRequestInterceptor;

import javax.net.ssl.SSLContext;
import java.security.cert.X509Certificate;

/**
 * @author zhufkt
 * @date 2020/10/29
 */

@Log4j2
@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder, LogbookClientHttpRequestInterceptor interceptor) {

        return builder.build();

        //Bug reported here - https://github.com/zalando/logbook/issues/963#issuecomment-787397327 . We are not using LogbookClientHttpRequestInterceptor temporarily
        //return builder.additionalInterceptors(interceptor).build();
    }

    @Bean
    public RestTemplate restTemplateDisableSSLVerification(RestTemplateBuilder builder) {
        //Disable SSL verification here
        //https://dev.to/mnpaa/disable-skip-ssl-validation-in-springboot-resttemplate-1ec2

        return builder.requestFactory(() -> {

            try
            {
                TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;

                SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom()
                        .loadTrustMaterial(null, acceptingTrustStrategy)
                        .build();


                SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);

                CloseableHttpClient httpClient = HttpClients.custom()
                        .setSSLSocketFactory(csf)
                        .build();

                HttpComponentsClientHttpRequestFactory requestFactory =
                        new HttpComponentsClientHttpRequestFactory();
                requestFactory.setHttpClient(httpClient);

                return requestFactory;

            }
            catch (Exception e) {
                log.error("Creating requestFactory failed in restTemplateDisableSSLVerification");
                throw new RuntimeException(e);
            }

        } ).build();
    }


}