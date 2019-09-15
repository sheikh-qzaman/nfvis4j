package com.sheikh.nfvis4j.test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sheikh.nfvis4j.client.RestClientFactory;
import com.sheikh.nfvis4j.model.EscDeployment;
import com.sheikh.nfvis4j.model.Images;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Sheikh Qumruzzaman
 * Sep 8, 2019
 */
public class JerseyClient {
	//final String URL = "https://192.168.0.222/api/operational/platform-detail";
	//final String URL = "https://192.168.0.222/api/operational/vm_lifecycle/opdata/images?deep";
	final String URL = "https://192.168.0.222/api/config/vm_lifecycle/tenants/tenant/admin/deployments";
	public EscDeployment deployment; 
	
	public JerseyClient() {
		EscDeployment deployment = null;
		try {
			File file = new File(getClass().getClassLoader().getResource("data/ROUTER.json").getFile());
			deployment = new ObjectMapper().readValue(file, EscDeployment.class);
			new ObjectMapper().writeValue(System.out, deployment);
			System.out.println("");
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.deployment = deployment;
		rest();
	}
	
	public void rest() {
		try {
			URL url = new URL(URL);
			Client client = ClientBuilder.newClient();
			//WebTarget webTarget = client.target(URL);
			WebTarget webTarget = RestClientFactory.getWebTargetClient(url);
			Invocation.Builder invocationBuilder =
			        webTarget.request()
			        .accept("application/vnd.yang.data+json")
			        .header("Authorization", "Basic YWRtaW46Q2lzY28xMjMj");
			//Response response = invocationBuilder.get();
			Entity<?> entity = Entity.entity(deployment, "application/vnd.yang.data+json");
			Response response = invocationBuilder.method("POST", entity);
			//System.out.println(response.getMediaType());
			//Images images = response.readEntity(Images.class);
			EscDeployment depRes = response.readEntity(EscDeployment.class);
			System.out.println(depRes);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new JerseyClient();
	}
}
