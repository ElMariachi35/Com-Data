ALTER TABLE rawtransfer ADD CONSTRAINT UK_playerName_transferDate UNIQUE (playerName, transferDate);