package com.wealth.noah.qa.entity;

import flexjson.JSONSerializer;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.roo.addon.layers.repository.mongo.RooMongoEntity;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooMongoEntity(identifierType = String.class)
@RooJson
public class TestSuite {
	private String subject;
	private String objective;
	private String preCondition;
	@Indexed(direction=IndexDirection.DESCENDING) private Date createdDate;
	private boolean template = true;
	@DBRef
	private List<TestScope> defectBasedTestScopes = new LinkedList<TestScope>();
	@DBRef
	private List<TestScope> regressionTestScopes = new LinkedList<TestScope>();

	public String toJson() {
        return new JSONSerializer()
        	.include("defectBasedTestScopes", "defectBasedTestScopes.cases")
        	.exclude("*.class").serialize(this);
    }
}
