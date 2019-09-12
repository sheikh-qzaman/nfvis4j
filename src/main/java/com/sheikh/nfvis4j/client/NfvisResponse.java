/**
 * @author Sheikh Qumruzzaman
 * Created on: Sep 11, 2019
 */
package com.sheikh.nfvis4j.client;

import java.io.InputStream;
import java.util.Map;

/**
 * @author Sheikh Qumruzzaman
 * Sep 11, 2019
 */
public interface NfvisResponse {
	public <T> T getEntity(Class<T> returnType);

	public InputStream getInputStream();

	public String header(String name);
	
	public Map<String, String> headers();
}
