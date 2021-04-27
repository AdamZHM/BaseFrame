package com.shdata.ai.meilong.standalone.dataanalysis.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

/**
 * @author zhufkt
 * @date 2021/4/23
 */

@Component
@Log4j2
public class JsonUtil {

    public <T> String objectToString(T jsonObject)
    {
        try
        {
            String jsonString = new ObjectMapper().writeValueAsString(jsonObject);
            log.info("objectToString - convert done - jsonStr: {}", jsonString);
            return jsonString;

        } catch (JsonProcessingException e) {
            log.error("objectToString - Error parse jsonString from jsonObject {}", jsonObject, e);
            throw new RuntimeException(e);
        }
    }


    public <T> T stringToObject(String jsonString, Class<T> clazz) {
        try {
            T jsonObject = new ObjectMapper().readValue(jsonString, clazz);
            log.info("stringToObject - convert done - jsonString: {}, object {}", jsonString, jsonObject);
            return jsonObject;
        } catch (JsonProcessingException e) {
            log.error("stringToObject - Error parse jsonObject from jsonString {}", jsonString, e);
            throw new RuntimeException(e);
        }
    }










}
