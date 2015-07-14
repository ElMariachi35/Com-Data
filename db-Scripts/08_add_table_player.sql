
CREATE TABLE `player` (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(255) NOT NULL,
	`position` VARCHAR(255) NOT NULL,
	points INT NOT NULL DEFAULT 0,
	club VARCHAR(255),
	user_id BIGINT NOT NULL
);


CREATE TABLE playerMarketValue (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	player_id BIGINT NOT NULL,
	timeStamp DATE NOT NULL,
	marketValue DECIMAL(15,2) NOT NULL,
	CONSTRAINT playerMarketValue_fk_player FOREIGN KEY (player_id) REFERENCES player(id)
);