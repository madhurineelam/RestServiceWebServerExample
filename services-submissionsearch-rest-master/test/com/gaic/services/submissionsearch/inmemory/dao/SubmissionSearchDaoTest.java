package com.gaic.services.submissionsearch.inmemory.dao;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertFalse;

import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.gaic.services.submissionsearch.dao.SubmissionSearchDao;

public class SubmissionSearchDaoTest {
	
	private SubmissionSearchDao dao;
	 
	@Before
	public void setUp() {
		final EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		builder.setType(EmbeddedDatabaseType.HSQL)
			.addScript("classpath:com/gaic/services/submissionsearch/inmemory/resources/create-db.sql")
			.addScript("classpath:com/gaic/services/submissionsearch/inmemory/resources/insert-data.sql");

		EmbeddedDatabase db =  builder.build();
		dao = new SubmissionSearchDao();
		dao.setDataSource(db);
	}
	
	@Test
	public void autoWire() {
		assertNotNull(dao);
	}
	
	@Test
	public void testsSarchSubmissionById() {	  
	    assertNotNull(dao.searchSubmission("10400168", "SHS"));
	}
	
	@Test
	public void testSearchSubmission_SOA_O() throws Exception {		
		assertFalse(dao.searchSubmission("10245934", "SHS"));
	}
	
}
