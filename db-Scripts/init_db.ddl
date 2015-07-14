DROP TABLE Budget;
DROP TABLE `User`;
DROP TABLE RawTransfer;

CREATE TABLE `User` (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(255) NOT NULL
);
CREATE TABLE Budget (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	budget DECIMAL(12,2) NOT NULL DEFAULT 0,
	`timeStamp` DATETIME NOT NULL,
	user_id BIGINT NOT NULL,
	CONSTRAINT Budget_FK_User FOREIGN KEY (user_id) REFERENCES `User`(id)
);

CREATE TABLE RawTransfer (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	`from` VARCHAR(255) NOT NULL,
	`to` VARCHAR(255) NOT NULL,
	`playerName` VARCHAR(255) NOT NULL,
	`transferFee` decimal(12,2) NOT NULL,
	`transferDate` DATETIME NOT NULL
);


ALTER TABLE `User` ADD COLUMN startCapital DECIMAL(15,2) NOT NULL DEFAULT 20000000;
ALTER TABLE `User` ADD COLUMN balanceOffset DECIMAL(15,2) NOT NULL DEFAULT 0;
ALTER TABLE `User` ADD COLUMN points BIGINT NOT NULL DEFAULT 0;

ALTER TABLE RawTransfer ADD CONSTRAINT UK_playerName_transferDate UNIQUE (playerName, transferDate);

CREATE TABLE UserAlias (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	user_id BIGINT NOT NULL,
	alias VARCHAR(255) NOT NULL,
	CONSTRAINT userAlias_FK_user FOREIGN KEY (user_id) REFERENCES `User`(id)
);

CREATE TABLE MarketValue (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	marketValue DECIMAL(15,2) NOT NULL,
	`timeStamp` DATETIME NOT NULL,
	user_id BIGINT NOT NULL,
	CONSTRAINT marketValue_FK_user FOREIGN KEY (user_id) REFERENCES `User`(id)
);


ALTER TABLE `User` ADD pId BIGINT;


CREATE TABLE `Player` (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(255) NOT NULL,
	`position` VARCHAR(255) NOT NULL,
	points INT NOT NULL DEFAULT 0,
	club VARCHAR(255),
	user_id BIGINT NOT NULL
);


CREATE TABLE PlayerMarketValue (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	player_id BIGINT NOT NULL,
	timeStamp DATE NOT NULL,
	marketValue DECIMAL(15,2) NOT NULL,
	CONSTRAINT playerMarketValue_fk_player FOREIGN KEY (player_id) REFERENCES Player(id)
);

CREATE TABLE ComstatsConfiguration(
	id BIGINT PRIMARY KEY AUTO_INCREMENT
);

CREATE TABLE ComstatsTeamUrl (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	teamName VARCHAR(255) NOT NULL,
	url VARCHAR(255) NOT NULL,
	comstatsConfiguration_id BIGINT NOT NULL,
	CONSTRAINT comstatsTeamUrl_fk_comstatsConf FOREIGN KEY (comstatsConfiguration_id) REFERENCES ComstatsConfiguration(id)
);

ALTER TABLE RawTransfer CHANGE `from` fromUser VARCHAR(255) NOT NULL;
ALTER TABLE RawTransfer CHANGE `to` toUser VARCHAR(255) NOT NULL;
