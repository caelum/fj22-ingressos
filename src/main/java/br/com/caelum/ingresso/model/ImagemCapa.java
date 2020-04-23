package br.com.caelum.ingresso.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImagemCapa {
	
	@JsonProperty
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
}
