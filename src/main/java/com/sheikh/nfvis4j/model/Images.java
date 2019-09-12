package com.sheikh.nfvis4j.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

/**
 * @author Sheikh Qumruzzaman
 * Sep 8, 2019
 */
@JsonTypeInfo(include = As.WRAPPER_OBJECT, use = Id.NAME)
@JsonTypeName("vmlc:images")
public class Images implements Serializable {
	@JsonProperty("image")
	private List<Image> image;
	
	public List<Image> getImages() {
		return image;
	}
	public void setImages(List<Image> image) {
		this.image = image;
	}
	
	//@JsonTypeInfo(include = As.WRAPPER_OBJECT, use = Id.NAME)
	//@JsonTypeName("vmlc:images")
	private static class Image implements Serializable{
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
}
