-- *********************************************************************
-- Update Database Script
-- *********************************************************************
-- Change Log: /Users/krzysztofkic/Projects/Exploration/exploration-spring-jooq-liquibase/src/main/resources/db/local/changelog/db.changelog-master.xml
-- Ran at: 3/10/18, 10:36 PM
-- Against: postgres@jdbc:postgresql://localhost:5432/exp-sjl
-- Liquibase version: 3.5.4
-- *********************************************************************

-- Lock Database
UPDATE databasechangeloglock SET LOCKED = TRUE, LOCKEDBY = 'localhost (127.0.0.1)', LOCKGRANTED = '2018-03-10 22:36:42.414' WHERE ID = 1 AND LOCKED = FALSE;

-- Changeset /Users/krzysztofkic/Projects/Exploration/exploration-spring-jooq-liquibase/src/main/resources/db/local/changelog/db.changelog-master.xml::1::Krzysztof Kicinger
CREATE TABLE person (id SERIAL NOT NULL, firstname VARCHAR(50), lastname VARCHAR(50) NOT NULL, state CHAR(2), CONSTRAINT PK_PERSON PRIMARY KEY (id));

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('1', 'Krzysztof Kicinger', '/Users/krzysztofkic/Projects/Exploration/exploration-spring-jooq-liquibase/src/main/resources/db/local/changelog/db.changelog-master.xml', NOW(), 4, '7:12f0532b442a52021f3d0a0e836192a8', 'createTable tableName=person', '', 'EXECUTED', NULL, NULL, '3.5.4', '0717803191');

-- Changeset /Users/krzysztofkic/Projects/Exploration/exploration-spring-jooq-liquibase/src/main/resources/db/local/changelog/db.changelog-master.xml::2::Krzysztof Kicinger
ALTER TABLE person ADD username VARCHAR(8);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('2', 'Krzysztof Kicinger', '/Users/krzysztofkic/Projects/Exploration/exploration-spring-jooq-liquibase/src/main/resources/db/local/changelog/db.changelog-master.xml', NOW(), 5, '7:51103b9bcc77c9b816989f5b24dcfbee', 'addColumn tableName=person', '', 'EXECUTED', NULL, NULL, '3.5.4', '0717803191');

-- Changeset /Users/krzysztofkic/Projects/Exploration/exploration-spring-jooq-liquibase/src/main/resources/db/local/changelog/db.changelog-master.xml::3::Krzysztof Kicinger
CREATE TABLE state AS SELECT DISTINCT state AS id FROM person WHERE state IS NOT NULL;

ALTER TABLE state ALTER COLUMN  id SET NOT NULL;

ALTER TABLE state ADD PRIMARY KEY (id);

ALTER TABLE person ADD CONSTRAINT FK_PERSON_STATE FOREIGN KEY (state) REFERENCES state (id);

INSERT INTO databasechangelog (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, DESCRIPTION, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('3', 'Krzysztof Kicinger', '/Users/krzysztofkic/Projects/Exploration/exploration-spring-jooq-liquibase/src/main/resources/db/local/changelog/db.changelog-master.xml', NOW(), 6, '7:72c8c0a62b987819b1cd22ea71e9502a', 'addLookupTable existingColumnName=state, existingTableName=person, newColumnName=id, newTableName=state', '', 'EXECUTED', NULL, NULL, '3.5.4', '0717803191');

-- Release Database Lock
UPDATE databasechangeloglock SET LOCKED = FALSE, LOCKEDBY = NULL, LOCKGRANTED = NULL WHERE ID = 1;

