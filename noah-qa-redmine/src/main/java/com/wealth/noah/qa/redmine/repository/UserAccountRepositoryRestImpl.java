package com.wealth.noah.qa.redmine.repository;

import org.springframework.web.client.RestTemplate;

import com.wealth.noah.qa.redmine.entity.UserAccount;

public class UserAccountRepositoryRestImpl implements UserAccountRepository {
	
	private RestTemplate restTemplate;
	private String uriPattern;

	@Override
	public UserAccount findByApiKey(String apiKey) {
		String uri = String.format(uriPattern, apiKey);
		UserAccount user = this.restTemplate.getForObject(uri, UserAccount.class);
		return user;
	}
	
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public void setUriPattern(String uriPattern) {
		this.uriPattern = uriPattern;
	}

}
