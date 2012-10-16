package com.wealth.noah.qa.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wealth.noah.qa.data.api.TestSuiteImportService;
import com.wealth.noah.qa.data.impl.TestSuiteImportServiceImpl;

@Configuration
public class AppConfig {
	
	@Bean
	public TestSuiteImportService testSuiteImportService() {
		return new TestSuiteImportServiceImpl();
	}
	
}
