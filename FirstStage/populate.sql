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
INSERT INTO Individuals (client_id, first_name, second_name) VALUES(2, 'Korya', 'Korneev');
INSERT INTO Individuals (client_id, first_name, second_name) VALUES(3, 'Erik', 'Erencenov');

INSERT INTO Organizations (client_id, name) VALUES(4, '60 Seconds');
INSERT INTO Organizations (client_id, name) VALUES(5, 'Gasprom');
INSERT INTO Organizations (client_id, name) VALUES(6, 'Housekeepers');


INSERT INTO Contacts (client_id, first_name, second_name, address, phone_number, mail)
  VALUES(1, 'Ivan', 'Ivanov', 'Moscow', '89851237765', 'Ivan@yandex.ru');
INSERT INTO Contacts (client_id, first_name, second_name, address, phone_number, mail)
  VALUES(2, 'Korya', 'Korneev', 'Elista', '89851232365', 'Kor@mail.ru');
INSERT INTO Contacts (client_id, first_name, second_name, address, phone_number, mail)
  VALUES(3, 'Erik', 'Erencenov', 'Moscow', '89851231265', 'Erik@yandex.ru');
INSERT INTO Contacts (client_id, first_name, second_name, address, phone_number, mail)
  VALUES(4, 'Sixty', 'Seconds', 'Moscow', '89851237735', 'sixtysec@yandex.ru');
INSERT INTO Contacts (client_id, first_name, second_name, address, phone_number, mail)
  VALUES(5, 'Gas', 'Prom', 'Moscow', '89851237345', 'gasprom@yandex.ru');
INSERT INTO Contacts (client_id, first_name, second_name, address, phone_number, mail)
  VALUES(6, 'House', 'Keepers', 'Moscow', '89841237765', 'housekeepers@yandex.ru');

INSERT INTO Accounts (client_id, balance, max_debt, pay_debt_date, pay_debt_time, phone_number)
  VALUES(1, 1000, 200, '2017-02-01', '01:20:00', '89851237765');
INSERT INTO Accounts (client_id, balance, max_debt, pay_debt_date, pay_debt_time, phone_number)
  VALUES(2, 2000, 200, '2017-02-02', '01:21:00', '89851232365');
INSERT INTO Accounts (client_id, balance, max_debt, pay_debt_date, pay_debt_time, phone_number)
  VALUES(3, 3000, 200, '2017-02-03', '01:22:00', '89851231265');
INSERT INTO Accounts (client_id, balance, max_debt, pay_debt_date, pay_debt_time, phone_number)
  VALUES(4, 4000, 200, '2017-02-04', '01:23:00', '89851237735');
INSERT INTO Accounts (client_id, balance, max_debt, pay_debt_date, pay_debt_time, phone_number)
  VALUES(5, 5000, 200, '2017-02-05', '01:24:00', '89851237345');
INSERT INTO Accounts (client_id, balance, max_debt, pay_debt_date, pay_debt_time, phone_number)
  VALUES(6, 6000, 200, '2017-02-06', '01:25:00', '89841237765');

INSERT INTO NumberGroups (group_number, account_id)
  VALUES(1, 1);
INSERT INTO NumberGroups (group_number, account_id)
  VALUES(1, 2);
INSERT INTO NumberGroups (group_number, account_id)
  VALUES(1, 3);
INSERT INTO NumberGroups (group_number, account_id)
  VALUES(2, 4);
INSERT INTO NumberGroups (group_number, account_id)
  VALUES(2, 5);
INSERT INTO NumberGroups (group_number, account_id)
  VALUES(2, 6);
  
INSERT INTO ReplenishHistory (account_id, date, time, amount)
  VALUES(1, '2017-02-02', '01:21:00', 1000);
INSERT INTO ReplenishHistory (account_id, date, time, amount)
  VALUES(2, '2017-02-02', '01:22:00', 2000);
INSERT INTO ReplenishHistory (account_id, date, time, amount)
  VALUES(3, '2017-02-02', '01:23:00', 3000);
INSERT INTO ReplenishHistory (account_id, date, time, amount)
  VALUES(4, '2017-02-02', '01:24:00', 4000);
INSERT INTO ReplenishHistory (account_id, date, time, amount)
  VALUES(5, '2017-02-02', '01:25:00', 5000);
INSERT INTO ReplenishHistory (account_id, date, time, amount)
  VALUES(6, '2017-02-02', '01:26:00', 6000);
  
INSERT INTO CallTariffs (name, price, group_price)
  VALUES('First Call Tariff', 1, 0.5);
INSERT INTO CallTariffs (name, price, group_price)
  VALUES('Second Call Tariff', 2, 1);
INSERT INTO CallTariffs (name, price, group_price)
  VALUES('Third Call Tariff', 3, 1.5);
    
INSERT INTO SmsTariffs (name, price, group_price)
  VALUES('First Sms Tariff', 1, 0.5);
INSERT INTO SmsTariffs (name, price, group_price)
  VALUES('Second Sms Tariff', 2, 1);
INSERT INTO SmsTariffs (name, price, group_price)
  VALUES('Third Sms Tariff', 3, 1.5);
  
INSERT INTO InternetTariffs (name, price)
  VALUES('1GB Internet Tariff', 200);
INSERT INTO InternetTariffs (name, price)
  VALUES('Per MB Internet Tariff', 0.5);
INSERT INTO InternetTariffs (name, price)
  VALUES('5GB Internet Tariff', 500);
  
INSERT INTO ContractsHistory (account_id, relevance, tariff_type, calltariff_id, smstariff_id, internettariff_id, date, time)
  VALUES(1, 'active', 'call', 1, NULL, NULL, '2017-02-01', '01:21:00');
INSERT INTO ContractsHistory (account_id, relevance, tariff_type, calltariff_id, smstariff_id, internettariff_id, date, time)
  VALUES(2, 'active', 'call', 2, NULL, NULL, '2017-02-02', '01:22:00');
INSERT INTO ContractsHistory (account_id, relevance, tariff_type, calltariff_id, smstariff_id, internettariff_id, date, time)
  VALUES(3, 'active', 'sms', NULL, 1, NULL, '2017-02-03', '01:23:00');
INSERT INTO ContractsHistory (account_id, relevance, tariff_type, calltariff_id, smstariff_id, internettariff_id, date, time)
  VALUES(4, 'active', 'sms', 1, 3, NULL, '2017-02-04', '01:24:00');
INSERT INTO ContractsHistory (account_id, relevance, tariff_type, calltariff_id, smstariff_id, internettariff_id, date, time)
  VALUES(5, 'active', 'internet', NULL, NULL, 2, '2017-02-05', '01:25:00');
INSERT INTO ContractsHistory (account_id, relevance, tariff_type, calltariff_id, smstariff_id, internettariff_id, date, time)
  VALUES(6, 'active', 'internet', NULL, NULL, 3, '2017-02-06', '01:26:00');
  
INSERT INTO WriteoffsHistory (contract_id, account_id, date, time, value)
  VALUES (1, 1, '2017-02-01', '01:21:00', 2);
INSERT INTO WriteoffsHistory (contract_id, account_id, date, time, value)
  VALUES (2, 2, '2017-02-02', '01:22:00', 3);
INSERT INTO WriteoffsHistory (contract_id, account_id, date, time, value)
  VALUES (3, 3, '2017-02-03', '01:23:00', 2);
INSERT INTO WriteoffsHistory (contract_id, account_id, date, time, value)
  VALUES (4, 4, '2017-02-04', '01:24:00', 2);
INSERT INTO WriteoffsHistory (contract_id, account_id, date, time, value)
  VALUES (5, 5, '2017-02-05', '01:25:00', 100);
INSERT INTO WriteoffsHistory (contract_id, account_id, date, time, value)
  VALUES (6, 6, '2017-02-06', '01:26:00', 1);