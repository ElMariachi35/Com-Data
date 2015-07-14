CREATE TABLE comstatsconfiguration(
	id BIGINT PRIMARY KEY AUTO_INCREMENT
);

CREATE TABLE comstatsTeamUrl (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	teamName VARCHAR(255) NOT NULL,
	url VARCHAR(255) NOT NULL,
	comstatsConfiguration_id BIGINT NOT NULL,
	CONSTRAINT comstatsTeamUrl_fk_comstatsConf FOREIGN KEY (comstatsConfiguration_id) REFERENCES comstatsconfiguration(id)
);


