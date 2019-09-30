package com.sheikh.nfvis4j.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.HttpMethod;

/**
 * @author Sheikh Qumruzzaman Sep 11, 2019
 */
public class NfvisRequest<R> {
	private NfvisRestClient client;
	private String endpoint;
	private StringBuilder path;
	private String method;
	private Entity<?> entity;
	private Class<R> returnType;
	private Map<String, List<Object>> headers = new HashMap<String, List<Object>>();
	private Map<String, List<Object>> queryParams = new LinkedHashMap<String, List<Object>>();

	public NfvisRequest(NfvisRestClient client, String method, String path, Entity<?> entity, Class<R> returnType) {
		this(client, method, (CharSequence) path, entity, returnType);
	}

	public NfvisRequest(NfvisRestClient client, String method, CharSequence path, Entity<?> entity,
			Class<R> returnType) {
		this.client = client;
		this.method = method;
		this.path = new StringBuilder(path);
		this.entity = entity;
		this.returnType = returnType;
		//header("Accept", "application/json");
	}

	public R execute() {
		return client.execute(this);
	}

	public String endpoint() {
		return endpoint;
	}

	public NfvisRequest<R> endpoint(String endpoint) {
		this.endpoint = endpoint;
		return this;
	}

	public StringBuilder path() {
		return path;
	}

	public NfvisRequest<R> path(StringBuilder path) {
		this.path = path;
		return this;
	}

	public String method() {
		return method;
	}

	public NfvisRequest<R> method(String method) {
		this.method = method;
		return this;
	}

	public <T> Entity<T> entity(T entity, String contentType) {
		return new Entity<T>(entity, contentType);
	}

	public Entity<?> entity() {
		return entity;
	}

	public Class<R> returnType() {
		return returnType;
	}

	public NfvisRequest<R> returnType(Class<R> returnType) {
		this.returnType = returnType;
		return this;
	}

	public NfvisRequest<R> header(String name, Object value) {
		if (value != null) {
			headers.put(name, Arrays.asList(value));
		}
		return this;
	}

	public Map<String, List<Object>> headers() {
		return headers;
	}

	public Map<String, List<Object>> queryParams() {
		return queryParams;
	}

	public NfvisRequest<R> queryParam(String key, Object value) {
		if (queryParams.containsKey(key)) {
			List<Object> values = queryParams.get(key);
			values.add(value);
		} else {
			List<Object> values = new ArrayList<Object>();
			values.add(value);
			queryParams.put(key, values);
		}

		return this;
	}
}
