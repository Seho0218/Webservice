-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema multi
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema multi
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `multi` DEFAULT CHARACTER SET utf8 ;
USE `multi` ;

-- -----------------------------------------------------
-- Table `multi`.`memberTbl`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `multi`.`memberTbl` (
  `mem_id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(10) NOT NULL,
  `depart` VARCHAR(45) NULL,
  `position` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NOT NULL,
  `writedate` DATETIME NOT NULL DEFAULT now(),
  PRIMARY KEY (`mem_id`));


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
