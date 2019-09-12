package com.sheikh.nfvis4j.test;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sheikh.nfvis4j.model.Deployment;

/**
 * @author Sheikh Qumruzzaman
 * Sep 10, 2019
 */
public class JSONTest {
	public JSONTest() {
		try {
			File file = new File(getClass().getClassLoader().getResource("data/test.json").getFile());
			Test test = new ObjectMapper().readValue(file, Test.class);
			new ObjectMapper().writeValue(System.out, test);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new JSONTest();
	}
}
