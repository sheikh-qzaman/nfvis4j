package com.sheikh.nfvis4j.test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sheikh.nfvis4j.model.Employees;
import com.sheikh.nfvis4j.model.Images;
import com.sheikh.nfvis4j.model.Person;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Sheikh Qumruzzaman
 * Sep 8, 2019
 */
public class JerseyClientDummy {
	final String URL = "http://127.0.0.1:3000/people";
	//final String URL = "http://127.0.0.1:3000/employee";
	
	public JerseyClientDummy() {
		try {
			URL url = new URL(URL);
			Client client = ClientBuilder.newClient();
			WebTarget webTarget = client.target(URL);
			Invocation.Builder invocationBuilder =
			        webTarget.request()
			        .accept("application/json")
			        .header("Authorization", "Basic YWRtaW46Q2lzY28xMjMj");
			Response response = invocationBuilder.get();
			System.out.println(response.getMediaType());
			Person person = response.readEntity(Person.class);
			System.out.println(person);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new JerseyClientDummy();
	}
}
