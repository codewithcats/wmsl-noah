package com.wealth.noah.qa.web;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wealth.noah.qa.data.api.TestSuiteImportService;
import com.wealth.noah.qa.entity.TestSuite;

@Controller
public class TestSuiteController {
	
	@Autowired private TestSuiteImportService importService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/suite/import/**")
	public ResponseEntity<String> importTestSuite(@RequestBody byte[] bytes,
			@Value("#{app.testSuiteImportTempLocation}") String tempLocation) throws IOException {
		long now = Calendar.getInstance().getTimeInMillis();
		File file = new File(tempLocation + String.valueOf(now) + ".xls");
		FileUtils.writeByteArrayToFile(file, bytes);
		
		TestSuite testSuite = importService.importFromXls(file);
		
		FileUtils.deleteQuietly(file);
		
		String json = testSuite.toJson();
		return new ResponseEntity<String>(json, HttpStatus.OK);
	}
}
