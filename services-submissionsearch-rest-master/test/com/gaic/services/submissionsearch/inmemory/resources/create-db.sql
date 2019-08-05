
DROP TABLE bdm_edp.submission IF EXISTS;
DROP SCHEMA IF EXISTS bdm_edp;

CREATE SCHEMA bdm_edp AUTHORIZATION DBA;


CREATE TABLE bdm_edp.submission (
	submission_id         	INTEGER PRIMARY KEY,
	source_submission_id	VARCHAR(30),
	row_condition_cd		CHAR(1),
	business_unit_cd	    VARCHAR(30)
);



