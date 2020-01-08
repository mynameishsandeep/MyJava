package com.home.parser;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class POJOToJSON {
  public static void main(String[] args) throws JsonProcessingException {

    ObjectMapper mapper = new ObjectMapper();
    mapper.setSerializationInclusion(Include.NON_NULL);
    YSBShippingConfigDTO dtoObject = new YSBShippingConfigDTO();
    dtoObject.setIsSeparateTaxShip("SomeValue");

    String dtoAsString = mapper.writeValueAsString(dtoObject);
    JSONObject response = new JSONObject(dtoAsString);
    System.out.println(response);
  }
}
