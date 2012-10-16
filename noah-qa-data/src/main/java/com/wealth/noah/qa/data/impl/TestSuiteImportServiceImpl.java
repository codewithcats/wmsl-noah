package com.wealth.noah.qa.data.impl;

import java.io.File;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.Cell;

import com.wealth.noah.qa.data.api.TestSuiteImportService;
import com.wealth.noah.qa.entity.TestSuite;
import com.wealth.noah.qa.entity.TestScope;
import com.wealth.noah.qa.entity.TestCase;

public class TestSuiteImportServiceImpl implements TestSuiteImportService {
	
	@Override
	public TestSuite importFromXls(File xls) {
		TestSuite suite = new TestSuite();
		try {
			Workbook workbook = Workbook.getWorkbook(xls);
			Sheet testScopeSheet = workbook.getSheet("Test Scope");
			String subject = testScopeSheet.getCell(2, 1).getContents();
			subject = escape(subject);
			suite.setSubject(subject);
			String objective = testScopeSheet.getCell(2, 4).getContents();
			suite.setObjective(escape(objective));
			String preCondition = testScopeSheet.getCell(2, 6).getContents();
			suite.setPreCondition(escape(preCondition));

			int row = 11;
			List<TestScope> scopes = suite.getDefectBasedTestScopes();
			while(isTestCaseRow(testScopeSheet, row)) {
				Cell scopeCell = testScopeSheet.getCell(2, row);
				String scopeStr = scopeCell.getContents();
				if(scopeStr == null || "".equals(scopeStr)) {
					if(scopes.isEmpty()) {
						row++;
						continue;
					}
					TestScope scope = scopes.get(scopes.size()-1);
					TestCase c = createTestCaseFromRow(testScopeSheet, row);
					scope.addTestCase(c);
					row++;
					continue;
				}
				TestScope scope = new TestScope();
				scope.setName(scopeStr);
				TestCase c = createTestCaseFromRow(testScopeSheet, row);
				scope.addTestCase(c);
				scopes.add(scope);
				row++;
			}

		} catch (Exception e) {
			throw new RuntimeException("Error while importing test suite from excel file.", e);
		}
		return suite;
	}

	private TestCase createTestCaseFromRow(Sheet testScopeSheet, int row) {
		String subject = testScopeSheet.getCell(4, row).getContents();
		String result = testScopeSheet.getCell(5, row).getContents();
		String remark = testScopeSheet.getCell(6, row).getContents();
		TestCase c = new TestCase();
		c.setSubject(subject);
		c.setExpectedResult(result);
		c.setRemark(remark);
		return c;
	}

	private boolean isTestCaseRow(Sheet sheet, int row) {
		Cell cell = sheet.getCell(1, row);
		String content = cell.getContents();
		try {
			Integer.valueOf(content);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	private String escape(String str) {
		return str.replaceAll("\n", "<br/>");
	}
}
