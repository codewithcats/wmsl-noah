package com.wealth.noah.qa.entity;

import flexjson.JSONSerializer;
import java.util.LinkedList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.roo.addon.layers.repository.mongo.RooMongoEntity;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooMongoEntity(identifierType = String.class)
@RooJson
public class TestScope {
	private String name;
	private int referenceId;
	@DBRef
	private List<TestCase> cases = new LinkedList<TestCase>();

	public void addTestCase(TestCase testCase) {
		cases.add(testCase);
	}

	public String toJson() {
        return new JSONSerializer()
        	.include("cases")
        	.exclude("*.class").serialize(this);
    }
}
