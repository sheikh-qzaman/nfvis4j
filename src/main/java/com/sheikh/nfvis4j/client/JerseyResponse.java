package com.sheikh.nfvis4j.client;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Response;

/**
 * @author Sheikh Qumruzzaman
 * Sep 11, 2019
 */
public class JerseyResponse implements NfvisResponse{

	private Response response;
	
	public JerseyResponse(Response response) {
		this.response = response;
	}
	@Override
	public <T> T getEntity(Class<T> returnType){
		if(response.getStatus() >= 400) {
			throw new NfvisResponseException(response.getStatusInfo().getReasonPhrase(),
					response.getStatusInfo().getStatusCode());
		}
		return response.readEntity(returnType);
	}

	@Override
	public InputStream getInputStream() {
		return (InputStream) response.getEntity();
	}

	@Override
	public String header(String name) {
		return response.getHeaderString(name);
	}

	@Override
	public Map<String, String> headers() {
		Map<String, String> headers = new HashMap<String, String>();
		for(String k : response.getHeaders().keySet()) {
			headers.put(k, response.getHeaderString(k));
		}
		return headers;
	}
	
}
