package com.wealth.noah.qa.redmine.repository;

import java.util.List;

import com.wealth.noah.qa.redmine.entity.Issue;

public interface IssueRepository {
	public List<Issue> getIssueAssignedToId(Long userId);

	public List<Issue> getRelatedIssues(Long issueId);

	public Issue getIssue(Long issueId);
}
