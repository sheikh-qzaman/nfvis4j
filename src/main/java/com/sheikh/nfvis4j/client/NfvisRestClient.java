package com.sheikh.nfvis4j.client;

import com.sheikh.nfvis4j.client.connector.JerseyConnector;
import com.sheikh.nfvis4j.client.connector.NfvisConnector;

/**
 * @author Sheikh Qumruzzaman
 * Sep 11, 2019
 */
public class NfvisRestClient extends NfvisClient{
	protected String endpoint;
	protected NfvisConnector connector;
	
	public NfvisRestClient(String endpoint) {
		this.endpoint = endpoint;
		connector = new JerseyConnector();
	}
	
	@Override
	public <T> NfvisResponse request(NfvisRequest<T> request) {
		request.endpoint(endpoint);
		return connector.request(request);
	}

	@Override
	public <T> T execute(NfvisRequest<T> request){
		NfvisResponse response = request(request);
		return (request.returnType() != null && request.returnType() != Void.class) ? 
				response.getEntity(request.returnType()) : null;
	}

	@Override
	public NfvisConnector createConnector() {
		return null;
	}
}
