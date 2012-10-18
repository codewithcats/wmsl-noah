package com.wealth.noah.qa.redmine.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.wealth.noah.qa.redmine.entity.Issue;
import com.wealth.noah.qa.redmine.entity.Project;
import com.wealth.noah.qa.redmine.entity.Tracker;

public class IssueRowMapper implements RowMapper<Issue> {

	@Override
	public Issue mapRow(ResultSet r, int i) throws SQLException {
		Issue issue = new Issue();
		issue.setId(r.getLong("id"));
		issue.setSubject(r.getString("subject"));
		issue.setPriorityId(r.getLong("priority_id"));
		issue.setLastUpdated(r.getDate("updated_on"));
		issue.setStatus(r.getString("issue_status_name"));
		issue.setVersion(r.getString("version"));
		
		Project p = new Project();
		p.setId(r.getLong("project_id"));
		p.setName(r.getString("project_name"));
		issue.setProject(p);
		
		Tracker t = new Tracker();
		t.setName(r.getString("tracker_name"));
		issue.setTracker(t);
		
		return issue;
	}

}
