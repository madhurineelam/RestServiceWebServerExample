package com.gaic.services.submissionsearch;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.apache.commons.lang.StringUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Log4jConfigurer;

import com.gaic.services.submissionsearch.bl.ISubmissionSearchBl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"classpath:com/gaic/services/core/resources/services-coreContext.xml",
	"classpath:com/gaic/services/configuration/resources/services-cprContext.xml",
	"classpath:com/gaic/services/submissionsearch/resources/db-appContext.xml",
	"classpath:com/gaic/services/submissionsearch/resources/appContext.xml" })
	
public class SubmissionSearchServiceTest {
	
	@Autowired
	protected ISubmissionSearchBl submissionSearchBl;
	
	@BeforeClass
	public static void setUp() throws Exception {
		Log4jConfigurer.initLogging("classpath:com/gaic/services/core/test/resources/log4j-test.xml");
		System.setProperty("org.apache.commons.logging.Log","org.apache.commons.logging.impl.SimpleLog");
		System.setProperty("org.apache.commons.logging.simplelog.showdatetime","true");
		System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.commons.httpclient","error");
	}
	
	@Test
	public void testAuotwire() throws Exception {
		assertNotNull(submissionSearchBl);
	}
	
	@Test
	public void testSearchSubmissionById() throws Exception {	
		assertTrue(submissionSearchBl.searchSubmission("10394695", "SHS"));
	}
	
	@Test
	public void testSearchSubmissionById_SOA_REF_ID_D() throws Exception {	
		assertFalse(submissionSearchBl.searchSubmission("10511092", "SHS"));
	}
	
	@Test
	public void testSearchSubmissionById_fail() throws Exception {	
		try {
			assertTrue(submissionSearchBl.searchSubmission("", "SHS"));
			fail("Exception should have been thrown!");
		} catch (Exception e) {
			assertTrue(true);
		}
		
		try {
			assertTrue(submissionSearchBl.searchSubmission("10394695", ""));
			fail("Exception should have been thrown!");
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testCheckDependencies() throws Exception {
		String s = submissionSearchBl.checkDependencies();
		if(StringUtils.isBlank(s)) {
			System.out.println("CheckDependencies failed. Nothing found.");
		} else {
			System.out.println("CheckDependencies : " + s);
		}
		assertNotNull(submissionSearchBl.checkDependencies());
	}
}
