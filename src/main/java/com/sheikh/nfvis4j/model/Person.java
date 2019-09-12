/**
 * @author Sheikh Qumruzzaman
 * Created on: Sep 9, 2019
 */
package com.sheikh.nfvis4j.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * @author Sheikh Qumruzzaman
 * Sep 9, 2019
 */
@JsonTypeInfo(include = As.WRAPPER_OBJECT, use = Id.NAME)
@JsonTypeName("person")
public class Person implements Serializable{
	private String name;
	private String title;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
