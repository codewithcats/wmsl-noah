package com.wealth.noah.qa.redmine.repository;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import com.wealth.noah.qa.redmine.entity.UserAccount;

public class UserAccountRepositoryRestImpl_UnitTest {
	private UserAccountRepositoryRestImpl userAccountRepository;
	
	@Before
	public void before() {
		this.userAccountRepository = new UserAccountRepositoryRestImpl();
	}

	@Test
	public void testReturnValidUserAccount() {
		RestTemplate restTemplate = mock(RestTemplate.class);
		String apiKey = "thisIsMockApiKey";
		String uriPattern = "http://fakeuri?key=%1$s;";
		UserAccount expectedUser = new UserAccount();
		when(restTemplate.getForObject(String.format(uriPattern, apiKey), UserAccount.class)).thenReturn(expectedUser);
		
		this.userAccountRepository.setRestTemplate(restTemplate);
		this.userAccountRepository.setUriPattern(uriPattern);
		UserAccount userAccount = this.userAccountRepository.findByApiKey(apiKey);
		assertEquals(expectedUser, userAccount);
	}
}
