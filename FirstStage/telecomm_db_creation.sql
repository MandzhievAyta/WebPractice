CREATE TABLE `Clients` (
	`id` int NOT NULL AUTO_INCREMENT,
	`type` enum('individual', 'organization') NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Individuals` (
	`id` int NOT NULL AUTO_INCREMENT,
	`client_id` int NOT NULL,
	`first_name` varchar(100),
	`second_name` varchar(100),
	PRIMARY KEY (`id`)
);

CREATE TABLE `Organizations` (
	`id` int NOT NULL AUTO_INCREMENT,
	`client_id` int NOT NULL,
	`name` varchar(100) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Contacts` (
	`id` int NOT NULL AUTO_INCREMENT,
	`client_id` int NOT NULL,
	`first_name` varchar(100) NOT NULL,
	`second_name` varchar(100) NOT NULL,
	`address` varchar(100),
	`phone_number` varchar(100),
	`mail` varchar(100),
	PRIMARY KEY (`id`)
);

CREATE TABLE `Accounts` (
	`id` int NOT NULL AUTO_INCREMENT,
	`client_id` int NOT NULL,
	`balance` int NOT NULL,
	`max_debt` int NOT NULL,
	`pay_debt_date` DATE NOT NULL,
	`pay_debt_time` TIME NOT NULL,
	`phone_number` varchar(100) NOT NULL UNIQUE,
	PRIMARY KEY (`id`)
);

CREATE TABLE `NumberGroups` (
	`id` int NOT NULL AUTO_INCREMENT,
	`group_number` int NOT NULL,
	`account_id` int NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `ReplenishHistory` (
	`id` int NOT NULL AUTO_INCREMENT,
	`account_id` int NOT NULL,
	`date` DATE NOT NULL,
	`time` TIME NOT NULL,
	`amount` int NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `ContractsHistory` (
	`id` int NOT NULL AUTO_INCREMENT,
	`account_id` int NOT NULL,
    `relevance` enum('active', 'ended') NOT NULL,
	`tariff_type` enum('call', 'sms', 'internet') NOT NULL,
	`calltariff_id` int,
	`smstariff_id` int NOT NULL,
	`internettariff_id` int NOT NULL,
	`date` DATE NOT NULL,
	`time` TIME NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `WriteoffsHistory` (
	`id` int NOT NULL AUTO_INCREMENT,
    `contract_id` int NOT NULL,
    `account_id` int NOT NULL,
	`date` DATE NOT NULL,
	`time` TIME NOT NULL,
    `value` int NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `SmsTariffs` (
	`id` int NOT NULL AUTO_INCREMENT,
	`name` varchar(100) NOT NULL,
	`price` int NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `CallTariffs` (
	`id` int NOT NULL AUTO_INCREMENT,
	`price` int NOT NULL,
	`name` varchar(100) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `InternetTariffs` (
	`id` int NOT NULL AUTO_INCREMENT,
	`name` varchar(100) NOT NULL,
	`price` int NOT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `Contacts` ADD CONSTRAINT `FK_Contacts_client` FOREIGN KEY (`client_id`) REFERENCES `Clients`(`id`);

ALTER TABLE `Individuals` ADD CONSTRAINT `FK_Individuals_client` FOREIGN KEY (`client_id`) REFERENCES `Clients`(`id`);

ALTER TABLE `ContractsHistory` ADD CONSTRAINT `FK_ContractsHistory_calltariff` FOREIGN KEY (`calltariff_id`) REFERENCES `CallTariffs`(`id`);

ALTER TABLE `ContractsHistory` ADD CONSTRAINT `FK_ContractsHistory_smstariff` FOREIGN KEY (`smstariff_id`) REFERENCES `SmsTariffs`(`id`);

ALTER TABLE `ContractsHistory` ADD CONSTRAINT `FK_ContractsHistory_internettariff` FOREIGN KEY (`internettariff_id`) REFERENCES `InternetTariffs`(`id`);

ALTER TABLE `ContractsHistory` ADD CONSTRAINT `FK_ContractsHistory_account` FOREIGN KEY (`account_id`) REFERENCES `Accounts`(`id`);

ALTER TABLE `WriteoffsHistory` ADD CONSTRAINT `FK_WriteoffsHistory_account` FOREIGN KEY (`account_id`) REFERENCES `Accounts`(`id`);

ALTER TABLE `WriteoffsHistory` ADD CONSTRAINT `FK_WriteoffsHistory_contract` FOREIGN KEY (`contract_id`) REFERENCES `ContractsHistory`(`id`);

ALTER TABLE `Organizations` ADD CONSTRAINT `FK_Organizations_client` FOREIGN KEY (`client_id`) REFERENCES `Clients`(`id`);

ALTER TABLE `ReplenishHistory` ADD CONSTRAINT `FK_ReplenishHistory_account` FOREIGN KEY (`account_id`) REFERENCES `Accounts`(`id`);

ALTER TABLE `Accounts` ADD CONSTRAINT `FK_Accounts_client` FOREIGN KEY (`client_id`) REFERENCES `Clients`(`id`);

ALTER TABLE `NumberGroups` ADD CONSTRAINT `FK_NumberGroups_account` FOREIGN KEY (`account_id`) REFERENCES `Accounts`(`id`);

