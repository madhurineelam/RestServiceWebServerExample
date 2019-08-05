package com.gaic.services.submissionsearch.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class SubmissionRowMapper implements RowMapper<String> {
	public String mapRow(ResultSet rs, int rowNumber) throws SQLException {
		return rs.getString("source_submission_id");
	}
}
