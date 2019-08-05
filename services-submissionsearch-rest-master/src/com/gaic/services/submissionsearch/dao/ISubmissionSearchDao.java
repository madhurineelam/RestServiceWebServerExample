package com.gaic.services.submissionsearch.dao;

public interface ISubmissionSearchDao {
	public boolean searchSubmission(String submissionId, String businessUnitCd);
	
	public String checkDependencies();
}
