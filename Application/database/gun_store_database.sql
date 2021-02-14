-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema gun_store_database
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `gun_store_database` ;

-- -----------------------------------------------------
-- Schema gun_store_database
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `gun_store_database` DEFAULT CHARACTER SET utf8 ;
USE `gun_store_database` ;

-- -----------------------------------------------------
-- Table `gun_store_database`.`Item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gun_store_database`.`Item` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `manufacturer` VARCHAR(45) NOT NULL,
  `model` VARCHAR(45) NOT NULL,
  `price` DOUBLE(10,2) NOT NULL,
  `in_stock` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gun_store_database`.`Rifle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gun_store_database`.`Rifle` (
  `item_id` INT NOT NULL,
  `caliber` VARCHAR(45) NOT NULL,
  `magazine_capacity` INT NOT NULL,
  PRIMARY KEY (`item_id`),
  CONSTRAINT `fk_Puška_Artikl`
    FOREIGN KEY (`item_id`)
    REFERENCES `gun_store_database`.`Item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gun_store_database`.`Pistol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gun_store_database`.`Pistol` (
  `item_id` INT NOT NULL,
  `caliber` VARCHAR(45) NOT NULL,
  `magazine_capacity` INT NOT NULL,
  PRIMARY KEY (`item_id`),
  CONSTRAINT `fk_Pištolj_Artikl1`
    FOREIGN KEY (`item_id`)
    REFERENCES `gun_store_database`.`Item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gun_store_database`.`Gas_Pistol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gun_store_database`.`Gas_Pistol` (
  `item_id` INT NOT NULL,
  `muzzle_velocity` INT NOT NULL,
  PRIMARY KEY (`item_id`),
  CONSTRAINT `fk_Gas_Pistol_Pistol1`
    FOREIGN KEY (`item_id`)
    REFERENCES `gun_store_database`.`Pistol` (`item_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gun_store_database`.`Airsoft_Pistol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gun_store_database`.`Airsoft_Pistol` (
  `item_id` INT NOT NULL,
  `range` INT NOT NULL,
  `muzzle_velocity` INT NOT NULL,
  PRIMARY KEY (`item_id`),
  CONSTRAINT `fk_Airsoft_Pistol_Pistol1`
    FOREIGN KEY (`item_id`)
    REFERENCES `gun_store_database`.`Pistol` (`item_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gun_store_database`.`Sport_Pistol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gun_store_database`.`Sport_Pistol` (
  `item_id` INT NOT NULL,
  `muzzle_velocity` INT NOT NULL,
  `range` INT NOT NULL,
  PRIMARY KEY (`item_id`),
  CONSTRAINT `fk_Sport_Pistol_Pistol1`
    FOREIGN KEY (`item_id`)
    REFERENCES `gun_store_database`.`Pistol` (`item_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gun_store_database`.`Airsoft_Rifle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gun_store_database`.`Airsoft_Rifle` (
  `item_id` INT NOT NULL,
  `range` INT NOT NULL,
  `muzzle_velocity` INT NULL,
  PRIMARY KEY (`item_id`),
  CONSTRAINT `fk_Airsoft_Rifle_Rifle1`
    FOREIGN KEY (`item_id`)
    REFERENCES `gun_store_database`.`Rifle` (`item_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gun_store_database`.`Sport_Rifle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gun_store_database`.`Sport_Rifle` (
  `item_id` INT NOT NULL,
  `muzzle_velocity` INT NOT NULL,
  `range` INT NOT NULL,
  PRIMARY KEY (`item_id`),
  CONSTRAINT `fk_Sport_Rifle_Rifle1`
    FOREIGN KEY (`item_id`)
    REFERENCES `gun_store_database`.`Rifle` (`item_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gun_store_database`.`Firearm_Pistol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gun_store_database`.`Firearm_Pistol` (
  `item_id` INT NOT NULL,
  PRIMARY KEY (`item_id`),
  CONSTRAINT `fk_Firearm_Pistol_Pistol1`
    FOREIGN KEY (`item_id`)
    REFERENCES `gun_store_database`.`Pistol` (`item_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gun_store_database`.`Firearm_Rifle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gun_store_database`.`Firearm_Rifle` (
  `item_id` INT NOT NULL,
  PRIMARY KEY (`item_id`),
  CONSTRAINT `fk_Firearm_Rifle_Rifle1`
    FOREIGN KEY (`item_id`)
    REFERENCES `gun_store_database`.`Rifle` (`item_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gun_store_database`.`Munition_Type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gun_store_database`.`Munition_Type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gun_store_database`.`Munition`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gun_store_database`.`Munition` (
  `item_id` INT NOT NULL,
  `munition_type_id` INT NOT NULL,
  `package_size` INT NULL,
  `caliber` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`item_id`),
  INDEX `fk_Munition_Munition_Type1_idx` (`munition_type_id` ASC) VISIBLE,
  CONSTRAINT `fk_Munition_Item1`
    FOREIGN KEY (`item_id`)
    REFERENCES `gun_store_database`.`Item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Munition_Munition_Type1`
    FOREIGN KEY (`munition_type_id`)
    REFERENCES `gun_store_database`.`Munition_Type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gun_store_database`.`Firearm_Permit`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gun_store_database`.`Firearm_Permit` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `issue_date` DATE NOT NULL,
  `expiration_date` DATE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gun_store_database`.`Person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gun_store_database`.`Person` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gun_store_database`.`Address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gun_store_database`.`Address` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `city` VARCHAR(45) NOT NULL,
  `street` VARCHAR(45) NOT NULL,
  `number` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gun_store_database`.`Employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gun_store_database`.`Employee` (
  `person_id` INT NOT NULL,
  `address_id` INT NOT NULL,
  `employee_username` VARCHAR(45) NOT NULL,
  `employee_password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`person_id`),
  INDEX `fk_Employee_Address1_idx` (`address_id` ASC) VISIBLE,
  UNIQUE INDEX `employee_username_UNIQUE` (`employee_username` ASC) VISIBLE,
  CONSTRAINT `fk_Employee_Person1`
    FOREIGN KEY (`person_id`)
    REFERENCES `gun_store_database`.`Person` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Employee_Address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `gun_store_database`.`Address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gun_store_database`.`Buyer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gun_store_database`.`Buyer` (
  `person_id` INT NOT NULL,
  `firearm_permit_id` INT NULL,
  PRIMARY KEY (`person_id`),
  INDEX `fk_Buyer_Firearm_Permit1_idx` (`firearm_permit_id` ASC) VISIBLE,
  CONSTRAINT `fk_Buyer_Person1`
    FOREIGN KEY (`person_id`)
    REFERENCES `gun_store_database`.`Person` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Buyer_Firearm_Permit1`
    FOREIGN KEY (`firearm_permit_id`)
    REFERENCES `gun_store_database`.`Firearm_Permit` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gun_store_database`.`Accesories`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gun_store_database`.`Accesories` (
  `item_id` INT NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  `colour` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`item_id`),
  CONSTRAINT `fk_Accesories_Item1`
    FOREIGN KEY (`item_id`)
    REFERENCES `gun_store_database`.`Item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gun_store_database`.`Receipt`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gun_store_database`.`Receipt` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `employee_id` INT NOT NULL,
  `buyer_id` INT NULL,
  `date_time` DATETIME NOT NULL,
  `total_price` DOUBLE NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Receipt_Employee1_idx` (`employee_id` ASC) VISIBLE,
  INDEX `fk_Receipt_Buyer1_idx` (`buyer_id` ASC) VISIBLE,
  CONSTRAINT `fk_Receipt_Employee1`
    FOREIGN KEY (`employee_id`)
    REFERENCES `gun_store_database`.`Employee` (`person_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Receipt_Buyer1`
    FOREIGN KEY (`buyer_id`)
    REFERENCES `gun_store_database`.`Buyer` (`person_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gun_store_database`.`Supplier`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gun_store_database`.`Supplier` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `address_id` INT NOT NULL,
  `email_address` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Supplier_Address1_idx` (`address_id` ASC) VISIBLE,
  CONSTRAINT `fk_Supplier_Address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `gun_store_database`.`Address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gun_store_database`.`Phone_Number`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gun_store_database`.`Phone_Number` (
  `person_id` INT NOT NULL,
  `phone_number` VARCHAR(45) NOT NULL,
  `supplier_id` INT NOT NULL,
  INDEX `fk_Phone_Number_Person1_idx` (`person_id` ASC) VISIBLE,
  PRIMARY KEY (`phone_number`),
  INDEX `fk_Phone_Number_Supplier1_idx` (`supplier_id` ASC) VISIBLE,
  CONSTRAINT `fk_Phone_Number_Person1`
    FOREIGN KEY (`person_id`)
    REFERENCES `gun_store_database`.`Person` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Phone_Number_Supplier1`
    FOREIGN KEY (`supplier_id`)
    REFERENCES `gun_store_database`.`Supplier` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gun_store_database`.`Receipt_has_Item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gun_store_database`.`Receipt_has_Item` (
  `receipt_id` INT NOT NULL,
  `item_id` INT NOT NULL,
  `ammount` INT NOT NULL,
  `item_price` DOUBLE NOT NULL,
  PRIMARY KEY (`receipt_id`, `item_id`),
  INDEX `fk_Receipt_has_Item_Item1_idx` (`item_id` ASC) VISIBLE,
  INDEX `fk_Receipt_has_Item_Receipt1_idx` (`receipt_id` ASC) VISIBLE,
  CONSTRAINT `fk_Receipt_has_Item_Receipt1`
    FOREIGN KEY (`receipt_id`)
    REFERENCES `gun_store_database`.`Receipt` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Receipt_has_Item_Item1`
    FOREIGN KEY (`item_id`)
    REFERENCES `gun_store_database`.`Item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gun_store_database`.`Purchase_Order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gun_store_database`.`Purchase_Order` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `supplier_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Purchase_Order_Supplier1_idx` (`supplier_id` ASC) VISIBLE,
  CONSTRAINT `fk_Purchase_Order_Supplier1`
    FOREIGN KEY (`supplier_id`)
    REFERENCES `gun_store_database`.`Supplier` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gun_store_database`.`Item_has_Purchase_Order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gun_store_database`.`Item_has_Purchase_Order` (
  `item_id` INT NOT NULL,
  `purchase_order_id` INT NOT NULL,
  `ammount` INT NOT NULL,
  `supplier_price` DOUBLE NOT NULL,
  PRIMARY KEY (`item_id`, `purchase_order_id`),
  INDEX `fk_Item_has_Purchase_Order_Purchase_Order1_idx` (`purchase_order_id` ASC) VISIBLE,
  INDEX `fk_Item_has_Purchase_Order_Item1_idx` (`item_id` ASC) VISIBLE,
  CONSTRAINT `fk_Item_has_Purchase_Order_Item1`
    FOREIGN KEY (`item_id`)
    REFERENCES `gun_store_database`.`Item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Item_has_Purchase_Order_Purchase_Order1`
    FOREIGN KEY (`purchase_order_id`)
    REFERENCES `gun_store_database`.`Purchase_Order` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
