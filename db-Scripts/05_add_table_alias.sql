DROP TABLE useralias;
CREATE TABLE useralias (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	user_id BIGINT NOT NULL,
	alias VARCHAR(255) NOT NULL,
	CONSTRAINT userAlias_FK_user FOREIGN KEY (user_id) REFERENCES `User`(id)
);

INSERT INTO useralias (id, user_id, alias) VALUES(1,8,'c0rneliusse');
INSERT INTO useralias (id, user_id, alias) VALUES(2,9,'Zeugwart´s Schlitzbären');

