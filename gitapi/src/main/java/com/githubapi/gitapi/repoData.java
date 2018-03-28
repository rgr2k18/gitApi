package com.githubapi.gitapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class repoData {
	
	@JsonProperty("name")
	public String name;
	@JsonProperty("id")
	public int id;
}
