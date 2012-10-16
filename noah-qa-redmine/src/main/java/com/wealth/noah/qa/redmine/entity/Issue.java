package com.wealth.noah.qa.redmine.entity;

import java.util.Date;

import org.springframework.roo.addon.javabean.RooJavaBean;

@RooJavaBean
public class Issue {
	private Long id;
	private String subject;
	private Tracker tracker;
	private Project project;
	private Long priorityId;
	private Date lastUpdated;
	private String status;
	private String version;
}
