// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.wealth.noah.qa.entity;

import com.wealth.noah.qa.entity.TestScope;
import com.wealth.noah.qa.entity.TestSuite;
import java.util.Date;
import java.util.List;

privileged aspect TestSuite_Roo_JavaBean {
    
    public String TestSuite.getSubject() {
        return this.subject;
    }
    
    public void TestSuite.setSubject(String subject) {
        this.subject = subject;
    }
    
    public String TestSuite.getObjective() {
        return this.objective;
    }
    
    public void TestSuite.setObjective(String objective) {
        this.objective = objective;
    }
    
    public String TestSuite.getPreCondition() {
        return this.preCondition;
    }
    
    public void TestSuite.setPreCondition(String preCondition) {
        this.preCondition = preCondition;
    }
    
    public Date TestSuite.getCreatedDate() {
        return this.createdDate;
    }
    
    public void TestSuite.setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    
    public boolean TestSuite.isTemplate() {
        return this.template;
    }
    
    public void TestSuite.setTemplate(boolean template) {
        this.template = template;
    }
    
    public List<TestScope> TestSuite.getDefectBasedTestScopes() {
        return this.defectBasedTestScopes;
    }
    
    public void TestSuite.setDefectBasedTestScopes(List<TestScope> defectBasedTestScopes) {
        this.defectBasedTestScopes = defectBasedTestScopes;
    }
    
    public List<TestScope> TestSuite.getRegressionTestScopes() {
        return this.regressionTestScopes;
    }
    
    public void TestSuite.setRegressionTestScopes(List<TestScope> regressionTestScopes) {
        this.regressionTestScopes = regressionTestScopes;
    }
    
}
