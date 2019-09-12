package com.sheikh.nfvis4j.client.connector;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;

import com.sheikh.nfvis4j.client.JerseyResponse;
import com.sheikh.nfvis4j.client.NfvisRequest;
import com.sheikh.nfvis4j.client.NfvisResponse;
import com.sheikh.nfvis4j.client.RestClientFactory;

/**
 * @author Sheikh Qumruzzaman
 * Sep 11, 2019
 */
public class JerseyConnector implements NfvisConnector{

	@Override
	public <T> NfvisResponse request(NfvisRequest<T> request) {
		Client client = ClientBuilder.newClient();
		try {
			URL endpoint = new URL(request.endpoint());
			WebTarget target = RestClientFactory.getWebTargetClient(endpoint).path(request.path().toString());
			
			for(Map.Entry<String, List<Object> > entry : request.queryParams().entrySet()) {
				for (Object obj : entry.getValue()) {
					target = target.queryParam(entry.getKey(), obj);
				}
			}
			
			Invocation.Builder invocation = target.request()
					.header("Authorization", "Basic YWRtaW46Q2lzY28xMjMj");

			for(Map.Entry<String, List<Object>> h : request.headers().entrySet()) {
				StringBuilder sb = new StringBuilder();
				for(Object v : h.getValue()) {
					sb.append(String.valueOf(v));
				}
				invocation.header(h.getKey(), sb);
			}

			Entity<?> entity = (request.entity() == null) ? null :
					Entity.entity(request.entity().getEntity(), request.entity().getContentType());
			
			return new JerseyResponse(invocation.method(request.method(), entity));
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
