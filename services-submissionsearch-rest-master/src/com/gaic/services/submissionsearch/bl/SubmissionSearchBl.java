package com.gaic.services.submissionsearch.bl;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.gaic.services.submissionsearch.dao.ISubmissionSearchDao;
import com.gaic.services.submissionsearch.exception.SubmissionSearchException;

public class SubmissionSearchBl implements ISubmissionSearchBl {
	private static final Logger log = Logger.getLogger(SubmissionSearchBl.class);
	
	@Autowired
	ISubmissionSearchDao submissionSearchDao;
	
	public boolean searchSubmission(String submissionId, String businessUnitCd) {
		
		if(StringUtils.isBlank(submissionId)) {
			log.debug("submissionId is required.");
			throw new SubmissionSearchException("submissionId is required.");				
		} else if (StringUtils.isBlank(businessUnitCd)) {
			log.debug("businessUnitCd is required.");
			throw new SubmissionSearchException("businessUnitCd is required.");				
		}
		
		return submissionSearchDao.searchSubmission(submissionId, businessUnitCd.toUpperCase());
	}
	
	public String checkDependencies() {
		return submissionSearchDao.checkDependencies();
	}
}
