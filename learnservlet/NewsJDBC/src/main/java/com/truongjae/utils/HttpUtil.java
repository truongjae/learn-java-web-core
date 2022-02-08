package com.truongjae.utils;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtil {
	private String value;
	public HttpUtil(String value) {
		this.value = value;
	}
	public <T> T toModel(Class<T> tClass) {
		try {
			return new ObjectMapper().readValue(this.value,tClass);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static HttpUtil of(BufferedReader reader) {
		StringBuilder json = new StringBuilder();
		String line;
		try {
			while((line= reader.readLine())!=null) {
				json.append(line);
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return new HttpUtil(json.toString());
	}
}
