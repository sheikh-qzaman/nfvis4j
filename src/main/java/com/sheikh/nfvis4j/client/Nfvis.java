package com.sheikh.nfvis4j.client;

import com.sheikh.nfvis4j.client.connector.NfvisConnector;

/**
 * @author Sheikh Qumruzzaman
 * Sep 11, 2019
 */
public class Nfvis extends NfvisRestClient{

	private final ComputeResources compute;
	
	public Nfvis(String endpoint) {
		super(endpoint);
		compute = new ComputeResources(this);
	}
	
	public ComputeResources compute( ) {
		return compute;
	}
}
