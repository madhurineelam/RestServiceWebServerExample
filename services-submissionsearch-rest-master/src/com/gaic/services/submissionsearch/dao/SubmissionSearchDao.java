package com.gaic.services.submissionsearch.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import com.gaic.services.submissionsearch.dao.mapper.SubmissionRowMapper;
import com.gaic.services.submissionsearch.exception.SubmissionSearchException;

public class SubmissionSearchDao extends NamedParameterJdbcDaoSupport implements ISubmissionSearchDao {
	private static final Log log = LogFactory.getLog(SubmissionSearchDao.class);
	 
	private String sql =
			  " SELECT DISTINCT s.source_submission_id "
			+ " from bdm_edp.submission s "
			+ " where s.source_submission_id = :submissionId "
			+ " and s.business_unit_cd = :businessUnitCd "
			+ " and s.row_condition_cd <> 'D' ";
			
	
	public boolean searchSubmission(String submissionId, String businessUnitCd) {
		
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		namedParameters.addValue("submissionId", submissionId);
		namedParameters.addValue("businessUnitCd", businessUnitCd);
		
		List<String> list = getNamedParameterJdbcTemplate().query(sql, namedParameters, new SubmissionRowMapper());
        
		if(list == null || list.isEmpty()) {
        	return false;
        } else if(list.size() > 1) {
        	log.warn("More than one result found.");
        	throw new SubmissionSearchException("More than one result found.");				
        }
        
		return true;
	}
	
	public String checkDependencies() {
		String sqlForCheckDependencies = "select count(*) from bdm_edp.submission where rownum < 10 ";
		int count = getJdbcTemplate().queryForObject(sqlForCheckDependencies, new Object[] {}, Integer.class);
		return "Find some (" + count + " records) in submission table. checkDependencies is OK.";
	}
}
