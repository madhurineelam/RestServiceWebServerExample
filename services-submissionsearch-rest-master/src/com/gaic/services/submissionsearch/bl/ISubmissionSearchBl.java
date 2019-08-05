package com.gaic.services.submissionsearch.bl;

public interface ISubmissionSearchBl {
	public boolean searchSubmission(String submissionId, String businessUnitCd);
	
	public String checkDependencies();
}
