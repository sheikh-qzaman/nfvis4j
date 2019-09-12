package com.sheikh.nfvis4j.client;

/**
 * This is an encapsulation for different Entity of different connectory type
 * @author Sheikh Qumruzzaman
 * Sep 11, 2019
 */
public class Entity<T> {
	
	private T entity;
	private String contentType;
	
	public static <T> Entity<T> json(T entity) {
		return new Entity<T>(entity, "application/json");
	}
	
	public static <T> Entity<T> yjson(T entity) {
		return new Entity<T>(entity, "application/vnd.yang.data+json");
	}
	
	public static <T> Entity<T> stream(T entity) {
		return new Entity<T>(entity, "application/octet-stream");
	}

	public Entity(T entity, String contentType) {
		super();
		this.entity = entity;
		this.contentType = contentType;
	}

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
}

