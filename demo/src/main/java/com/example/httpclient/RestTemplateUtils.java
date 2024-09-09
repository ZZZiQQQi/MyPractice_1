package com.example.httpclient;

import com.alibaba.fastjson.JSONObject;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class RestTemplateUtils {

    private static RestTemplate restTemplate = new RestTemplate();

    public static <T> ResponseEntity<T> postJson(String url, JSONObject jsonObject, Class<T> clazz){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);


        HttpEntity<JSONObject> entity = new HttpEntity<>(jsonObject, headers);

        ResponseEntity<T> responseEntity = restTemplate.exchange(url, HttpMethod.POST,entity, clazz);


        return  responseEntity;
    }

    public static <T,B> ResponseEntity<T> argsGet(String url, T args, Class<B> clazz){

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);

        if(args != null){

        }

    }
}
