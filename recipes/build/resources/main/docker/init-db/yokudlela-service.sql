CREATE DATABASE  IF NOT EXISTS yokudleladb CHARACTER SET utf8 COLLATE utf8_general_ci;
CREATE USER 'yokudlela'@'%' IDENTIFIED BY 'yokudlela';
GRANT ALL PRIVILEGES ON yokudleladb.* TO 'yokudlela'@'%';