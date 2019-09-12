package com.sheikh.nfvis4j.client;

import com.sheikh.nfvis4j.client.connector.NfvisConnector;

/**
 * @author Sheikh Qumruzzaman
 * Sep 11, 2019
 */
public abstract class NfvisClient {
	public abstract <T> NfvisResponse request(NfvisRequest<T> request);
	public abstract <T> T execute(NfvisRequest<T> request);
	public abstract NfvisConnector createConnector();
}
