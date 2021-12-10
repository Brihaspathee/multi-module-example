# mysql local root password cognizant-1
DROP DATABASE IF EXISTS customerdb;
DROP USER IF EXISTS `customeradmin`@`%`;
DROP USER IF EXISTS `customerapp`@`%`;
CREATE DATABASE IF NOT EXISTS customerdb CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER IF NOT EXISTS `customeradmin`@`%` IDENTIFIED WITH mysql_native_password BY 'password';
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, DROP, REFERENCES, INDEX, ALTER, EXECUTE, CREATE VIEW, SHOW VIEW, CREATE ROUTINE, ALTER ROUTINE, EVENT, TRIGGER ON `customerdb`.* TO `customeradmin`@`%`;
CREATE USER IF NOT EXISTS `customerapp`@`%` IDENTIFIED WITH mysql_native_password BY 'password';
GRANT SELECT, INSERT, UPDATE, DELETE, SHOW VIEW ON `customerdb`.* TO `customerapp`@`%`;
FLUSH PRIVILEGES;