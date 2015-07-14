DROP TABLE RawTransfer;

CREATE TABLE RawTransfer (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	`from` VARCHAR(255) NOT NULL,
	`to` VARCHAR(255) NOT NULL,
	`playerName` VARCHAR(255) NOT NULL,
	`transferFee` decimal(12,2) NOT NULL,
	`transferDate` DATETIME NOT NULL
);