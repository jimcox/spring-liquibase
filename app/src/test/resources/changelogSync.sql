-- *********************************************************************
-- SQL to add all changesets to database history table
-- *********************************************************************
-- Change Log: src/main/liquibase/changesets/dbchangelog.xml
-- Ran at: 2/16/14 2:20 PM
-- Against: SA@jdbc:h2:/home/jcox/workspaces/liquibase-demo/git-src/app/build/liquibase/tmpDB
-- Liquibase version: 3.1.1
-- *********************************************************************

-- Create Database Lock Table
CREATE TABLE DEMO.DATABASECHANGELOGLOCK (ID INT NOT NULL, LOCKED BOOLEAN NOT NULL, LOCKGRANTED TIMESTAMP, LOCKEDBY VARCHAR(255), CONSTRAINT PK_DATABASECHANGELOGLOCK PRIMARY KEY (ID));

-- Initialize Database Lock Table
DELETE FROM DEMO.DATABASECHANGELOGLOCK;

INSERT INTO DEMO.DATABASECHANGELOGLOCK (ID, LOCKED) VALUES (1, FALSE);

-- Lock Database
-- Create Database Change Log Table
CREATE TABLE DEMO.DATABASECHANGELOG (ID VARCHAR(255) NOT NULL, AUTHOR VARCHAR(255) NOT NULL, FILENAME VARCHAR(255) NOT NULL, DATEEXECUTED TIMESTAMP NOT NULL, ORDEREXECUTED INT NOT NULL, EXECTYPE VARCHAR(10) NOT NULL, MD5SUM VARCHAR(35), DESCRIPTION VARCHAR(255), COMMENTS VARCHAR(255), TAG VARCHAR(255), LIQUIBASE VARCHAR(20));

-- Initialize Database Lock Table
DELETE FROM DEMO.DATABASECHANGELOGLOCK;

INSERT INTO DEMO.DATABASECHANGELOGLOCK (ID, LOCKED) VALUES (1, FALSE);

INSERT INTO DEMO.DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, LIQUIBASE) VALUES ('initial changeset', 'jcox', '1.0', NOW(), 1, '7:a4627abf2631bdf347ee54df2efa4371', 'createTable (x2), addForeignKeyConstraint', 'Create some tables for a liquibase demo', 'EXECUTED', '3.1.1');

INSERT INTO DEMO.DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, LIQUIBASE) VALUES ('production course and student data', 'jcox', '1.0', NOW(), 2, '7:8c1e9dda82262fe94d033250c7754c27', 'sql (x16)', 'Insert some data for our liquibase demo', 'EXECUTED', '3.1.1');
