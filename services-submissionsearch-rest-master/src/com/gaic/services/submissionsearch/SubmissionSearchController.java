package com.gaic.services.submissionsearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gaic.services.core.controller.BaseController;
import com.gaic.services.core.controller.IBaseController;
import com.gaic.services.core.exception.CommonUtilException;
import com.gaic.services.core.spring.RefreshableProperty;
import com.gaic.services.submissionsearch.bl.ISubmissionSearchBl;
import com.gaic.services.submissionsearch.exception.SubmissionSearchException;

@RestController
public class SubmissionSearchController  extends BaseController implements IBaseController {
	
	@RefreshableProperty
	@Autowired
	ISubmissionSearchBl submissionSearchBl;
	
	@RequestMapping(value = "/searchSubmission", method = {RequestMethod.POST} )
	public boolean searchSubmission(@RequestParam String submissionId, @RequestParam String businessUnitCd) {
		return submissionSearchBl.searchSubmission(submissionId, businessUnitCd);
	}

	@Override
	public String checkDependencies() throws CommonUtilException {
		return submissionSearchBl.checkDependencies();
	}

	public void setSubmissionSearchBl(ISubmissionSearchBl submissionSearchBl) {
		this.submissionSearchBl = submissionSearchBl;
	}

	
}
