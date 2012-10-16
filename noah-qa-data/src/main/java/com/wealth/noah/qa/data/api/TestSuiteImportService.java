package com.wealth.noah.qa.data.api;

import java.io.File;

import com.wealth.noah.qa.entity.TestSuite;


public interface TestSuiteImportService {
	public TestSuite importFromXls(File xls);
}
