// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.wealth.noah.qa.entity;

import com.wealth.noah.qa.entity.TestSuite;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Persistent;

privileged aspect TestSuite_Roo_Mongo_Entity {
    
    declare @type: TestSuite: @Persistent;
    
    @Id
    private String TestSuite.id;
    
    public String TestSuite.getId() {
        return this.id;
    }
    
    public void TestSuite.setId(String id) {
        this.id = id;
    }
    
}
