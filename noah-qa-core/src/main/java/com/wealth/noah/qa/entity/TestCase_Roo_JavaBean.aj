// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.wealth.noah.qa.entity;

import com.wealth.noah.qa.entity.TestCase;

privileged aspect TestCase_Roo_JavaBean {
    
    public String TestCase.getSubject() {
        return this.subject;
    }
    
    public void TestCase.setSubject(String subject) {
        this.subject = subject;
    }
    
    public String TestCase.getExpectedResult() {
        return this.expectedResult;
    }
    
    public void TestCase.setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
    }
    
    public String TestCase.getRemark() {
        return this.remark;
    }
    
    public void TestCase.setRemark(String remark) {
        this.remark = remark;
    }
    
    public int TestCase.getReferenceId() {
        return this.referenceId;
    }
    
    public void TestCase.setReferenceId(int referenceId) {
        this.referenceId = referenceId;
    }
    
}
