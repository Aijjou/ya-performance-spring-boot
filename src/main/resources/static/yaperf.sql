-- MySQL Script generated by MySQL Workbench
-- Thu Apr 22 19:21:13 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema yaperf
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema yaperf
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `yaperf` DEFAULT CHARACTER SET utf8 ;
USE `yaperf` ;

-- -----------------------------------------------------
-- Table `yaperf`.`PROSPECT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `yaperf`.`PROSPECT` (
  `pros_id` INT NOT NULL AUTO_INCREMENT,
  `pros_civilite` VARCHAR(45) NULL,
  `pros_nom` VARCHAR(45) NULL,
  `pros_prenom` VARCHAR(45) NULL,
  `pros_mail` VARCHAR(45) NULL,
  `pros_phone` VARCHAR(45) NULL,
  `pros_sit_familial` VARCHAR(45) NULL,
  `pros_pers_charge` INT NULL,
  `pros_revenu_ref` VARCHAR(45) NULL,
  `pros_lieu_hab` VARCHAR(45) NULL,
  `pros_contact` TINYINT NULL,
  `pros_promo` TINYINT NULL,
  `pros_condition` TINYINT NULL,
  `pros_ville` VARCHAR(45) NULL,
  `pros_code` VARCHAR(45) NULL,
  PRIMARY KEY (`pros_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `yaperf`.`ADRESSE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `yaperf`.`ADRESSE` (
  `adr_id` INT NOT NULL AUTO_INCREMENT,
  `adr_num` VARCHAR(45) NULL,
  `adr_rue` VARCHAR(45) NULL,
  `adr_voie` VARCHAR(45) NULL,
  `adr_ville` VARCHAR(45) NULL,
  `adr_cp` VARCHAR(45) NULL,
  PRIMARY KEY (`adr_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `yaperf`.`SIMULATION`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `yaperf`.`SIMULATION` (
  `sim_id` INT NOT NULL AUTO_INCREMENT,
  `sim_logement` VARCHAR(45) NULL,
  `sim_annee_const` VARCHAR(45) NULL,
  `sim_surface` INT NULL,
  `sim_surf_iso` INT NULL,
  `sim_equipe_chauffage` VARCHAR(45) NULL,
  `sim_energie` VARCHAR(45) NULL,
  `sim_conso` INT NULL,
  `sim_mat_souhaite` VARCHAR(45) NULL,
  `sim_montant_mat` VARCHAR(45) NULL,
  `sim_montant_pose` VARCHAR(45) NULL,
  `sim_benef_travaux` VARCHAR(45) NULL,
  `PROSPECT_pros_id` INT NOT NULL,
  `ADRESSE_adr_id` INT NOT NULL,
  PRIMARY KEY (`sim_id`, `PROSPECT_pros_id`, `ADRESSE_adr_id`),
  INDEX `fk_SIMULATION_PROSPECT_idx` (`PROSPECT_pros_id` ASC),
  INDEX `fk_SIMULATION_ADRESSE1_idx` (`ADRESSE_adr_id` ASC),
  CONSTRAINT `fk_SIMULATION_PROSPECT`
    FOREIGN KEY (`PROSPECT_pros_id`)
    REFERENCES `yaperf`.`PROSPECT` (`pros_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_SIMULATION_ADRESSE1`
    FOREIGN KEY (`ADRESSE_adr_id`)
    REFERENCES `yaperf`.`ADRESSE` (`adr_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
