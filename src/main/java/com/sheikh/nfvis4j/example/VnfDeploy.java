package com.sheikh.nfvis4j.example;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sheikh.nfvis4j.builder.Builders;
import com.sheikh.nfvis4j.client.Nfvis;
import com.sheikh.nfvis4j.model.Deployment;
import com.sheikh.nfvis4j.model.EscDeployment;

/**
 * @author Sheikh Qumruzzaman
 * Sep 12, 2019
 */
public class VnfDeploy {
	static Nfvis nfvis = new Nfvis("https://192.168.0.222");
	public static void deploy() {
		/*try {
			File file = new File(VnfDeploy.class.getClassLoader().getResource("data/ROUTER.json").getFile());
			deployment = new ObjectMapper().readValue(file, Deployment.class);
			new ObjectMapper().writeValue(System.out, deployment);
			System.out.println("");
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		Deployment deployment = Builders.deployment()
				.name("ROUTER")
				.image("isrv-universalk9.16.08.01c-serial.tar.gz")
				.flavor("ISRv-small")
				.network("wan-net")
				.network("lan-net")
				.build();
		try {
			new ObjectMapper().writeValue(System.out, deployment);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		nfvis.compute().deploy(deployment).execute();
	}
	
	public static void getDeployment() {
		Deployment dep = nfvis.compute().deployment("ROUTER").execute();
		System.out.println(dep.toString());
	}
	
	public static void main(String[] args) {
		getDeployment();
		//deploy();
	}
	
	
}
