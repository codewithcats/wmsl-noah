// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.wealth.noah.qa.entity;

import com.wealth.noah.qa.entity.TestSuite;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

privileged aspect TestSuite_Roo_Json {
    
    public static TestSuite TestSuite.fromJsonToTestSuite(String json) {
        return new JSONDeserializer<TestSuite>().use(null, TestSuite.class).deserialize(json);
    }
    
    public static String TestSuite.toJsonArray(Collection<TestSuite> collection) {
        return new JSONSerializer().exclude("*.class").serialize(collection);
    }
    
    public static Collection<TestSuite> TestSuite.fromJsonArrayToTestSuites(String json) {
        return new JSONDeserializer<List<TestSuite>>().use(null, ArrayList.class).use("values", TestSuite.class).deserialize(json);
    }
    
}
