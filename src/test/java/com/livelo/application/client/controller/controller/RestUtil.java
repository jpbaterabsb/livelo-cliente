package com.livelo.application.client.controller.controller;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.gson.JsonObject;
import com.livelo.application.client.utils.JsonUtils;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;
import java.util.Optional;


public class RestUtil
{
  private HttpHeaders headers;
  private HttpEntity<?> entity;
  private RestTemplate template;
  private static final String EMPTY = "{}";
  
  public RestUtil()
  {
    this.template = new RestTemplate();
    this.headers = new HttpHeaders();
    this.entity = new HttpEntity(this.headers);
  }
  
  public RestUtil(RestTemplate template)
  {
    this.template = template;
    this.headers = new HttpHeaders();
    this.entity = new HttpEntity(this.headers);
  }
  
  public RestUtil(RestTemplate template,  HttpHeaders httpHeaders)
  {
    this.template = template;
    this.headers = Optional.ofNullable(httpHeaders).orElse(new HttpHeaders());
    this.entity = new HttpEntity(this.headers);
  }
  
  private <T> T execute(String uri, HttpMethod method, Class<T> clazz)
    throws Exception
  {
    ResponseEntity<String> response = this.template.exchange(uri, method, this.entity, String.class, new Object[0]);
    if (!response.getStatusCode().is2xxSuccessful())
    {

    	if(Objects.isNull(response.getBody())) {
    		return clazz.newInstance();
    	}
      JsonObject error = JsonUtils.toObject(JsonObject.class, response.getBody());
      throw new Exception(error.get("message").getAsString());
    }
    return getMapper().readValue(Optional.ofNullable(response.getBody()).orElse(EMPTY),clazz);
  }

  private static ObjectMapper getMapper() {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new JavaTimeModule());
    objectMapper.findAndRegisterModules();
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    return objectMapper;
  }


  private <T> T execute(String uri, HttpMethod method, Class<T> clazz, Object... a)
		    throws Exception
		  {
		    ResponseEntity<String> response = this.template.exchange(uri, method, this.entity, String.class,a);
		    if (!HttpStatus.OK.equals(response.getStatusCode()))
		    {
                JsonObject error = JsonUtils.toObject(JsonObject.class, response.getBody());
		         throw new Exception(error.get("message").getAsString());
		    }
              return getMapper().readValue(response.getBody(),clazz);
		  }
  
  public <T> T get(String uri, Class<T> clazz)
    throws Exception
  {
    return execute(uri, HttpMethod.GET, clazz);
  }
  
  public <T> T post(String uri, Object body, Class<T> clazz)
    throws Exception
  {
    this.entity = new HttpEntity(body, this.headers);
    return execute(uri, HttpMethod.POST, clazz);
  }
  
  public <T> T put(String uri, Object body, Class<T> clazz)
    throws Exception
  {
    this.entity = new HttpEntity(body, this.headers);
    return execute(uri, HttpMethod.PUT, clazz);
  }
  
  public <T> T delete(String uri, Class<T> clazz)
    throws Exception
  {
    return execute(uri, HttpMethod.DELETE, clazz);
  }

public <T> T get(String uri, Class<T> clazz, Object... uriVariables) throws Exception {
	return execute(uri, HttpMethod.GET, clazz,uriVariables);
}
}

