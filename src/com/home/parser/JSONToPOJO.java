package com.home.parser;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;


import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONToPOJO {

	public static void main(String[] args) {
		try {
		ObjectMapper objectMapper = new ObjectMapper();
		String fileString = new String(
				Files.readAllBytes(Paths.get("/Users/chandrasekhar/projects/MyJava/resources/newtaxship.json")),
				StandardCharsets.UTF_8);
		
		YSBShippingConfigDTO ysbShippingConfigDTO = objectMapper.readValue(fileString,
				YSBShippingConfigDTO.class);
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
}
