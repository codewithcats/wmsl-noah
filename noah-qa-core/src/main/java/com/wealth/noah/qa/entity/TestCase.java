package com.wealth.noah.qa.entity;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.layers.repository.mongo.RooMongoEntity;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooMongoEntity(identifierType = String.class)
public class TestCase {
	private String subject;
	private String expectedResult;
	private String remark;
	private int referenceId;
}
