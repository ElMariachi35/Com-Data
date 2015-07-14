DELETE FROM `User`;
DELETE FROM ComstatsTeamUrl;
DELETE FROM ComstatsConfiguration;


INSERT INTO `User`(id,`name`,startCapital, balanceOffset, points) VALUES(1, 'Feiprex', 21700000,0,323);
INSERT INTO `User`(id,`name`,startCapital, balanceOffset, points) VALUES(2, 'Balladassdarayn', 19800000,0,286);
INSERT INTO `User`(id,`name`,startCapital, balanceOffset, points) VALUES(3, 'MAR10', 19770000,0,274);
INSERT INTO `User`(id,`name`,startCapital, balanceOffset, points) VALUES(4, "Gierlo's Galaktiker", 20510000,0,267);
INSERT INTO `User`(id,`name`,startCapital, balanceOffset, points) VALUES(5, 'SASK 1908', 21280000,-11754800,259);
INSERT INTO `User`(id,`name`,startCapital, balanceOffset, points) VALUES(6, 'FOX', 20830000,0,246);
INSERT INTO `User`(id,`name`,startCapital, balanceOffset, points) VALUES(7, 'Tsubasa´s Dream-Team', 21690000,350022,245);
INSERT INTO `User`(id,`name`,startCapital, balanceOffset, points) VALUES(8, 'Schrombsi`s geile Wichte', 21580000,0,242);
INSERT INTO `User`(id,`name`,startCapital, balanceOffset, points) VALUES(9, 'Mensch ist der United', 20710000,0,240);
INSERT INTO `User`(id,`name`,startCapital, balanceOffset, points) VALUES(10, 'Fortuna Wild 1991', 20440000,0,237);
INSERT INTO `User`(id,`name`,startCapital, balanceOffset, points) VALUES(11, 'FC Siewillja', 21590000,0,237);
INSERT INTO `User`(id,`name`,startCapital, balanceOffset, points) VALUES(12, 'Stolpe', 22520000,0,170);
INSERT INTO `User`(id,`name`,startCapital, balanceOffset, points) VALUES(13, 'Berni Allstars', 20650000,0,168);
INSERT INTO `User`(id,`name`,startCapital, balanceOffset, points) VALUES(14, 'Die coolen Schnegis', 21970000,0,147);
INSERT INTO `User`(id, `name`,startCapital,balanceOffset, points) VALUES(15,'Computer',0,0,0); 

INSERT INTO ComstatsConfiguration(id) VALUES (1);



INSERT INTO ComstatsTeamUrl(id, teamName, url, comstatsConfiguration_id) VALUES
	(1,'FC Bayern München', 'http://www.comstats.de/squad/1-FC+Bayern+München',1),
	(2,'Borussia Dortmund', 'http://www.comstats.de/squad/5-Borussia+Dortmund',1),
	(3,'FC Schalke 04', 'http://www.comstats.de/squad/10-FC+Schalke+04',1),
	(4,"Borussia M'Gladbach", 'http://www.comstats.de/squad/3-Borussia+M',1),
	(5,'Vfl Wolfsburg', 'http://www.comstats.de/squad/12-VfL+Wolfsburg',1),
	(6,'Bayer 04 Leverkusen', 'http://www.comstats.de/squad/8-Bayer+04+Leverkusen',1),
	(7,'1. FSV Mainz 05', 'http://www.comstats.de/squad/18-1.+FSV+Mainz+05',1),
	(8,'1899 Hoffenheim', 'http://www.comstats.de/squad/62-1899+Hoffenheim',1),
	(9,'FC Augsburg', 'http://www.comstats.de/squad/68-FC+Augsburg',1),
	(10,'Hannover 96', 'http://www.comstats.de/squad/17-Hannover+96',1),
	(11,'Hertha BSC', 'http://www.comstats.de/squad/7-Hertha+BSC',1),
	(12,'SV Werder Bremen', 'http://www.comstats.de/squad/6-SV+Werder+Bremen',1),
	(13,'Eintracht Frankfurt', 'http://www.comstats.de/squad/9-Eintracht+Frankfurt',1),
	(14,'SC Freiburg', 'http://www.comstats.de/squad/21-SC+Freiburg',1),
	(15,'Vfb Stuttgart', 'http://www.comstats.de/squad/14-VfB+Stuttgart',1),
	(16,'Hamburger SV', 'http://www.comstats.de/squad/4-Hamburger+SV',1),
	(17,'1. FC Köln', 'http://www.comstats.de/squad/13-1.+FC+Köln',1),
	(18,'SC Paderborn 07', 'http://www.comstats.de/squad/81-SC+Paderborn+07',1);


UPDATE `User` SET pId = 9169595 WHERE id=1;
UPDATE `User` SET pId = 9169576 WHERE id=2;
UPDATE `User` SET pId = 9103768 WHERE id=3;
UPDATE `User` SET pId = 9104067 WHERE id=4;
UPDATE `User` SET pId = 9103813 WHERE id=5;
UPDATE `User` SET pId = 9239293 WHERE id=6;
UPDATE `User` SET pId = 9250766 WHERE id=7;
UPDATE `User` SET pId = 9207869 WHERE id=8;
UPDATE `User` SET pId = 9226151 WHERE id=9;
UPDATE `User` SET pId = 9103804 WHERE id=10;
UPDATE `User` SET pId = 9242644 WHERE id=11;
UPDATE `User` SET pId = 9169349 WHERE id=12;
UPDATE `User` SET pId = 9169326 WHERE id=13;
UPDATE `User` SET pId = 9105969 WHERE id=14;