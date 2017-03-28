SET SQL_SAFE_UPDATES = 0;

DELETE FROM `Contacts`;
ALTER TABLE `Contacts` AUTO_INCREMENT = 1;
DELETE FROM `Organizations`;
ALTER TABLE `Organizations` AUTO_INCREMENT = 1;
DELETE FROM `Individuals`;
ALTER TABLE `Individuals` AUTO_INCREMENT = 1;
DELETE FROM `NumberGroups`;
ALTER TABLE `NumberGroups` AUTO_INCREMENT = 1;
DELETE FROM `ReplenishHistory`;
ALTER TABLE `ReplenishHistory` AUTO_INCREMENT = 1;
DELETE FROM `WriteoffsHistory`;
ALTER TABLE `WriteoffsHistory` AUTO_INCREMENT = 1;
DELETE FROM `ContractsHistory`; 
ALTER TABLE `ContractsHistory` AUTO_INCREMENT = 1;
DELETE FROM `Accounts`;
ALTER TABLE `Accounts` AUTO_INCREMENT = 1;
DELETE FROM `Clients`;
ALTER TABLE `Clients` AUTO_INCREMENT = 1;
DELETE FROM `CallTariffs`;
ALTER TABLE `CallTariffs` AUTO_INCREMENT = 1;
DELETE FROM `SmsTariffs`;
ALTER TABLE `SmsTariffs` AUTO_INCREMENT = 1;
DELETE FROM `InternetTariffs`;
ALTER TABLE `InternetTariffs` AUTO_INCREMENT = 1;

INSERT INTO Clients (type) VALUES('individual');
INSERT INTO Clients (type) VALUES('individual');
INSERT INTO Clients (type) VALUES('individual');
INSERT INTO Clients (type) VALUES('organization');
INSERT INTO Clients (type) VALUES('organization');
INSERT INTO Clients (type) VALUES('organization');

INSERT INTO Individuals (client_id, first_name, second_name) VALUES(1, 'Ivan', 'Ivanov');
INSERT INTO Individuals (client_id, first_name, second_name) VALUES(2, 'Ivan', 'Ivanov');
INSERT INTO Individuals (client_id, first_name, second_name) VALUES(3, 'Ivan', 'Ivanov');

INSERT INTO Organizations (client_id, name) VALUES(4, '60 Seconds');
INSERT INTO Organizations (client_id, name) VALUES(5, 'Gasprom');
INSERT INTO Organizations (client_id, name) VALUES(6, 'Housekeepers');


INSERT INTO Contacts (client_id, first_name, second_name, address, phone_number, mail)
  VALUES(1, 'Ivan', 'Ivanov', 'Moscow', '89851237765', 'example@yandex.ru');
INSERT INTO Contacts (client_id, first_name, second_name, address, phone_number, mail)
  VALUES(2, 'Ivan', 'Ivanov', 'Moscow', '89851237765', 'example@yandex.ru');
INSERT INTO Contacts (client_id, first_name, second_name, address, phone_number, mail)
  VALUES(3, 'Ivan', 'Ivanov', 'Moscow', '89851237765', 'example@yandex.ru');
INSERT INTO Contacts (client_id, first_name, second_name, address, phone_number, mail)
  VALUES(4, 'Ivan', 'Ivanov', 'Moscow', '89851237765', 'example@yandex.ru');
INSERT INTO Contacts (client_id, first_name, second_name, address, phone_number, mail)
  VALUES(5, 'Ivan', 'Ivanov', 'Moscow', '89851237765', 'example@yandex.ru');
INSERT INTO Contacts (client_id, first_name, second_name, address, phone_number, mail)
  VALUES(6, 'Ivan', 'Ivanov', 'Moscow', '89851237765', 'example@yandex.ru');