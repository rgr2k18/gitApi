package com.githubapi.gitapi;

import java.util.Collections;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class gitApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(gitApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		String resourceURL = "https://api.github.com/search/repositories?q=testng&sort=stars&order=desc";
		
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<repoData[]> response = restTemplate.exchange(resourceURL, HttpMethod.GET, entity, repoData[].class);
		
		if(response.getStatusCode() == HttpStatus.OK) {
			
			for(repoData repoDataMine : response.getBody()) {
				
				System.out.println(repoDataMine.id + " " + repoDataMine.name);
			}
			
		}
		else {
			System.out.println("Error");
		}
	}
}
