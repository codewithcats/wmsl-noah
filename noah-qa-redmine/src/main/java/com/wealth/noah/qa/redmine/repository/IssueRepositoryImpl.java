package com.wealth.noah.qa.redmine.repository;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.wealth.noah.qa.redmine.entity.Issue;

public class IssueRepositoryImpl implements IssueRepository {
	
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	@Transactional(readOnly = true)
	public List<Issue> getIssueAssignedToId(Long userId) {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("select i.*, p.name as project_name, i_s.name as issue_status_name, t.name as tracker_name, v.name as version ").
			append("from issues i join projects p on i.project_id = p.id ").
			append("join issue_statuses i_s on i.status_id = i_s.id ").
			append("join trackers t on i.tracker_id = t.id ").
			append("join versions v on i.fixed_version_id = v.id ").
			append("where assigned_to_id = :user_id and i.status_id <> 25 ").
			append("order by updated_on desc");
		String sql = sqlBuilder.toString();
		Map<String, Long> params = Collections.singletonMap("user_id", userId);
		return this.jdbcTemplate.query(sql, params, new IssueRowMapper());
	}

	@Override
	@Transactional(readOnly = true)
	public List<Issue> getRelatedIssues(Long issueId) {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("select i.*, p.name as project_name, i_s.name as issue_status_name, t.name as tracker_name, v.name as version ").
			append("from issues i join projects p on i.project_id = p.id ").
			append("join ( select issue_from_id issue_id from issue_relations where issue_to_id = :issue_id ").
			append("union select issue_to_id issue_id from issue_relations where issue_from_id = :issue_id ) ").
			append("i_r on i_r.issue_id = i.id ").
			append("join versions v on i.fixed_version_id = v.id ").
			append("join issue_statuses i_s on i.status_id = i_s.id ").
			append("join trackers t on i.tracker_id = t.id ").
			append("order by updated_on desc");
		String sql = sqlBuilder.toString();
		Map<String, Long> params = Collections.singletonMap("issue_id", issueId);
		return this.jdbcTemplate.query(sql, params, new IssueRowMapper());
	}

	@Override
	@Transactional(readOnly = true)
	public Issue getIssue(Long issueId) {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("select i.*, p.name as project_name, i_s.name as issue_status_name, t.name as tracker_name, v.name as version ").
			append("from issues i join projects p on i.project_id = p.id ").
			append("join issue_statuses i_s on i.status_id = i_s.id ").
			append("join trackers t on i.tracker_id = t.id ").
			append("join versions v on i.fixed_version_id = v.id ").
			append("where i.id = :issue_id ");
		String sql = sqlBuilder.toString();
		Map<String, Long> params = Collections.singletonMap("issue_id", issueId);
		return this.jdbcTemplate.queryForObject(sql, params, new IssueRowMapper());
	}
	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

}
