-----------------------
CREATE TABLE users (
  user_id INT NOT NULL AUTO_INCREMENT,
  username VARCHAR(255) NOT NULL,
  pwd VARCHAR(40) NOT NULL,
  pwdhash VARCHAR(40) NOT NULL,
  email VARCHAR(255) NOT NULL,
  u_registration DATE NULL,
  PRIMARY KEY (user_id)
) ENGINE=INNODB;


CREATE TABLE whispers (
  whisper_id INT NOT NULL AUTO_INCREMENT,
  user_id INT NOT NULL,
  whisper VARCHAR (140) NOT NULL,
  w_registration DATE NULL,
  PRIMARY KEY (whisper_id),
  FOREIGN KEY user_id(user_id) REFERENCES users(user_id) 
  ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=INNODB;


ALTER TABLE whispers change w_registration w_registration timestamp;
