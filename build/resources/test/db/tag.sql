CREATE TABLE tag (
id long NOT NULL AUTO_INCREMENT,
  nameTag varchar(32) DEFAULT NULL,
  PRIMARY KEY (id)
);

INSERT INTO tag (id, nameTag) VALUES (1, 'service');
INSERT INTO tag (id, nameTag) VALUES (2, 'sport');
INSERT INTO tag (id, nameTag) VALUES (3, 'relax');
INSERT INTO tag (id, nameTag) VALUES (4, 'spa');



