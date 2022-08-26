-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`member`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`member` (
  `userid` VARCHAR(45) NOT NULL,
  `userpwd` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `tel` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `zipcode` VARCHAR(45) NULL DEFAULT NULL,
  `addr` VARCHAR(45) NULL DEFAULT NULL,
  `detailaddr` VARCHAR(45) NULL DEFAULT NULL,
  `writedate` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`userid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `mydb`.`board`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`board` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `subject` VARCHAR(45) NOT NULL,
  `content` LONGTEXT NOT NULL,
  `userid` VARCHAR(45) NOT NULL,
  `hit` INT NULL DEFAULT '0',
  `ip` VARCHAR(45) NOT NULL,
  `writedate` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`no`),
  CONSTRAINT `fk_board_member`
    FOREIGN KEY (`userid`)
    REFERENCES `mydb`.`member` (`userid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `mydb`.`zipcode`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`zipcode` (
  `zipcode` VARCHAR(5) NOT NULL,
  `si-do` VARCHAR(45) NOT NULL,
  `doro` VARCHAR(45) NOT NULL,
  `buildingnum1` VARCHAR(45) NULL,
  `buildingnum2` VARCHAR(45) NULL,
  `buildname` VARCHAR(100) NULL,
  `dong` VARCHAR(45) NULL,
  `num1` VARCHAR(45) NULL,
  `num2` VARCHAR(45) NULL)



-- -----------------------------------------------------
-- Table `mydb`.`data`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`data` (
  `no` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(200) NOT NULL,
  `content` LONGTEXT NOT NULL,
  `userid` VARCHAR(45) NOT NULL,
  `downcount` INT NOT NULL DEFAULT 0,
  `hit` INT NOT NULL DEFAULT 0,
  `writedate` DATETIME NOT NULL DEFAULT now(),
  `filename1` VARCHAR(100) NOT NULL,
  `filename2` VARCHAR(100) NULL,
  PRIMARY KEY (`no`),
 
  CONSTRAINT `fk_data_member1`
    FOREIGN KEY (`userid`)
    REFERENCES `mydb`.`member` (`userid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)



-- -----------------------------------------------------
-- Table `mydb`.`reply_board`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`reply_board` (
  `reply_no` INT NOT NULL AUTO_INCREMENT,
  `no` INT NOT NULL,
  `userid` VARCHAR(45) NOT NULL,
  `coment` VARCHAR(200) NOT NULL,
  `writedate` DATETIME NOT NULL DEFAULT now(),
  PRIMARY KEY (`reply_no`),

  CONSTRAINT `fk_reply_board_board1`
    FOREIGN KEY (`no`)
    REFERENCES `mydb`.`board` (`no`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
