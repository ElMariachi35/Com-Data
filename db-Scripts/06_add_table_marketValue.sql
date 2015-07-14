CREATE TABLE marketvalue (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	marketValue DECIMAL(15,2) NOT NULL,
	`timeStamp` DATETIME NOT NULL,
	user_id BIGINT NOT NULL,
	CONSTRAINT marketValue_FK_user FOREIGN KEY (user_id) REFERENCES `User`(id)
);
