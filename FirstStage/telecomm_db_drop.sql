ALTER TABLE `Contacts` DROP FOREIGN KEY `FK_Contacts_client`;

ALTER TABLE `Individuals` DROP FOREIGN KEY `FK_Individuals_client`;

ALTER TABLE `ContractsHistory` DROP FOREIGN KEY `FK_ContractsHistory_calltariff`;

ALTER TABLE `ContractsHistory` DROP FOREIGN KEY `FK_ContractsHistory_smstariff`;

ALTER TABLE `ContractsHistory` DROP FOREIGN KEY `FK_ContractsHistory_internettariff`;

ALTER TABLE `ContractsHistory` DROP FOREIGN KEY `FK_ContractsHistory_account`;

ALTER TABLE `WriteoffsHistory` DROP FOREIGN KEY `FK_WriteoffsHistory_contract`;

ALTER TABLE `WriteoffsHistory` DROP FOREIGN KEY `FK_WriteoffsHistory_account`;

ALTER TABLE `Organizations` DROP FOREIGN KEY `FK_Organizations_client`;

ALTER TABLE `ReplenishHistory` DROP FOREIGN KEY `FK_ReplenishHistory_account`;

ALTER TABLE `Accounts` DROP FOREIGN KEY `FK_Accounts_client`;

ALTER TABLE `NumberGroups` DROP FOREIGN KEY `FK_NumberGroups_account`;

DROP TABLE IF EXISTS `Contacts`;

DROP TABLE IF EXISTS `Individuals`;

DROP TABLE IF EXISTS `WriteoffsHistory`;

DROP TABLE IF EXISTS `ContractsHistory`;

DROP TABLE IF EXISTS `SmsTariffs`;

DROP TABLE IF EXISTS `Organizations`;

DROP TABLE IF EXISTS `ReplenishHistory`;

DROP TABLE IF EXISTS `Accounts`;

DROP TABLE IF EXISTS `CallTariffs`;

DROP TABLE IF EXISTS `InternetTariffs`;

DROP TABLE IF EXISTS `Clients`;

DROP TABLE IF EXISTS `NumberGroups`;

