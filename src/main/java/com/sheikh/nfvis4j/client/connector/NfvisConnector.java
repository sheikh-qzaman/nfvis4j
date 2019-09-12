package com.sheikh.nfvis4j.client.connector;

import com.sheikh.nfvis4j.client.NfvisRequest;
import com.sheikh.nfvis4j.client.NfvisResponse;

/**
 * @author Sheikh Qumruzzaman
 * Sep 11, 2019
 */
public interface NfvisConnector {
	public <T> NfvisResponse request(NfvisRequest<T> request);
}
