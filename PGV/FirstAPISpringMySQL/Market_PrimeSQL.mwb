
drop database if exists market_prime;
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Market Prime
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Market Prime
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `market_prime` DEFAULT CHARACTER SET utf8 ;
USE `market_prime` ;

-- --------------------------mods---------------------------
-- Table `Market Prime`.`primedMods`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `market_prime`.`mods` (
  `name` VARCHAR(40) NOT NULL,
  `quantity` INT NOT NULL,
  PRIMARY KEY (`name`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

use market_prime;
select * from mods;
insert into mods values('Primed Flow', 0);