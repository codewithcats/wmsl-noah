package com.wealth.noah.qa.redmine.repository;

import com.wealth.noah.qa.redmine.entity.UserAccount;

public interface UserAccountRepository {
	public UserAccount findByApiKey(String apiKey);
}
