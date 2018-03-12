-- *********************************************************************
-- Update Database Script
-- *********************************************************************
-- Change Log: /Users/krzysztofkic/Projects/Exploration/exploration-spring-jooq-liquibase/src/main/resources/db/db.changelog-master.xml
-- Ran at: 3/12/18, 9:24 AM
-- Against: postgres@jdbc:postgresql://localhost:5432/exp-sjl
-- Liquibase version: 3.5.4
-- *********************************************************************

-- Create Database Lock Table
CREATE TABLE databasechangeloglock (ID INT NOT NULL, LOCKED BOOLEAN NOT NULL, LOCKGRANTED TIMESTAMP WITHOUT TIME ZONE, LOCKEDBY VARCHAR(255), CONSTRAINT PK_DATABASECHANGELOGLOCK PRIMARY KEY (ID));

-- Initialize Database Lock Table
DELETE FROM databasechangeloglock;

INSERT INTO databasechangeloglock (ID, LOCKED) VALUES (1, FALSE);

-- Lock Database
UPDATE databasechangeloglock SET LOCKED = TRUE, LOCKEDBY = '172.16.13.108 (172.16.13.108)', LOCKGRANTED = '2018-03-12 09:24:04.725' WHERE ID = 1 AND LOCKED = FALSE;

-- Create Database Change Log Table
CREATE TABLE databasechangelog (ID VARCHAR(255) NOT NULL, AUTHOR VARCHAR(255) NOT NULL, FILENAME VARCHAR(255) NOT NULL, DATEEXECUTED TIMESTAMP WITHOUT TIME ZONE NOT NULL, ORDEREXECUTED INT NOT NULL, EXECTYPE VARCHAR(10) NOT NULL, MD5SUM VARCHAR(35), DESCRIPTION VARCHAR(255), COMMENTS VARCHAR(255), TAG VARCHAR(255), LIQUIBASE VARCHAR(20), CONTEXTS VARCHAR(255), LABELS VARCHAR(255), DEPLOYMENT_ID VARCHAR(10));

-- Changeset /Users/krzysztofkic/Projects/Exploration/exploration-spring-jooq-liquibase/src/main/resources/db/db.changelog-master.xml::1::Krzysztof Kicinger
CREATE TABLE "user" (id SERIAL NOT NULL, firstname VARCHAR(50), lastname VARCHAR(50) NOT NULL, password VARCHAR(50), email VARCHAR(50), CONSTRAINT PK_USER PRIMARY KEY (id));

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1', 'Krzysztof Kicinger', '/Users/krzysztofkic/Projects/Exploration/exploration-spring-jooq-liquibase/src/main/resources/db/db.changelog-master.xml', NOW(), 1, '7:238dce3fe77d144857d0edaa83d73c4b', 'createTable tableName=user', '', 'EXECUTED', NULL, NULL, '3.5.4', '0843045798');

-- Release Database Lock
UPDATE databasechangeloglock SET LOCKED = FALSE, LOCKEDBY = NULL, LOCKGRANTED = NULL WHERE ID = 1;

