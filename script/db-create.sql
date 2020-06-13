-- MySQL Script generated by MySQL Workbench
-- sab 13 giu 2020 11:19:07 CEST
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`user` (
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `birthdate` DATE NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  `codicefiscale` VARCHAR(45) NULL,
  `gender` ENUM('M', 'F') NOT NULL,
  `account_type` ENUM('CLIENT', 'ADMIN', 'CONSULTANT') NOT NULL,
  `registrato` TINYINT(1) NOT NULL,
  `partitaIVA` VARCHAR(45) NULL,
  `id` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  UNIQUE INDEX `phone_UNIQUE` (`phone` ASC),
  UNIQUE INDEX `partitaIVA_UNIQUE` (`partitaIVA` ASC),
  UNIQUE INDEX `codicefiscale_UNIQUE` (`codicefiscale` ASC))
;


-- -----------------------------------------------------
-- Table `mydb`.`address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `via` VARCHAR(45) NOT NULL,
  `civico` VARCHAR(45) NOT NULL,
  `comune` VARCHAR(45) NOT NULL,
  `provincia` VARCHAR(45) NOT NULL,
  `regione` VARCHAR(45) NOT NULL,
  `stato` VARCHAR(45) NOT NULL,
  `cap` INT(5) NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `user_id_idx` (`user_id` ASC),
  CONSTRAINT `user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `mydb`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;



-- -----------------------------------------------------
-- Table `mydb`.`account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`account` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date_of_creation` DATE NOT NULL,
  `us_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `user_id_idx` (`us_id` ASC),
  CONSTRAINT `us_id`
    FOREIGN KEY (`us_id`)
    REFERENCES `mydb`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table `mydb`.`cart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`cart` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `card_number` VARCHAR(16) NOT NULL,
  `circuit` ENUM('MASTER', 'VISA', 'AMERICANEXPRESS') NOT NULL,
  `expiry_date` DATE NOT NULL,
  `balance` DOUBLE NOT NULL,
  `type` ENUM('DEBIT', 'CREDIT') NOT NULL,
  `account_id` INT NOT NULL,
  `iban` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `card_number_UNIQUE` (`card_number` ASC),
  INDEX `account_id_idx` (`account_id` ASC),
  CONSTRAINT `account_id`
    FOREIGN KEY (`account_id`)
    REFERENCES `mydb`.`account` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table `mydb`.`prestito`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`prestito` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `import` VARCHAR(45) NOT NULL,
  `interest` VARCHAR(45) NOT NULL,
  `ac_id` INT NOT NULL,
  `numero_rata` INT NOT NULL,
  `importo_rata` DOUBLE NOT NULL,
  `durata` VARCHAR(45) NOT NULL,
  `numero_rata_mancanti` INT NOT NULL,
  `prestito_type` ENUM('LOAN', 'FINANCING') NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `client_UNIQUE` (`ac_id` ASC),
  CONSTRAINT `ac_id`
    FOREIGN KEY (`ac_id`)
    REFERENCES `mydb`.`account` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


-- -----------------------------------------------------
-- Table `mydb`.`currentAccount`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`currentAccount` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `iban` VARCHAR(45) NOT NULL,
  `balance` DOUBLE NOT NULL,
  `acc_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `iban_UNIQUE` (`iban` ASC),
  INDEX `accounts_id_idx` (`acc_id` ASC),
  CONSTRAINT `acc_id`
    FOREIGN KEY (`acc_id`)
    REFERENCES `mydb`.`account` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `mydb`.`transaction`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`transaction` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` VARCHAR(45) NOT NULL,
  `source` VARCHAR(45) NOT NULL,
  `destination` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  `accnt_id` INT NOT NULL,
  `importo` DOUBLE NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `account_id_idx` (`accnt_id` ASC),
  CONSTRAINT `accnt_id`
    FOREIGN KEY (`accnt_id`)
    REFERENCES `mydb`.`account` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `mydb`.`bank`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`bank` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `filiale` VARCHAR(45) NOT NULL,
  `u_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `u_id_idx` (`u_id` ASC),
  CONSTRAINT `u_id`
    FOREIGN KEY (`u_id`)
    REFERENCES `mydb`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
