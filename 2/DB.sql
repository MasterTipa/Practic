CREATE SCHEMA IF NOT EXISTS `registry` DEFAULT CHARACTER SET utf8 ;
USE `registry` ;

-- -----------------------------------------------------
-- Table `registry`.`cafes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `registry`.`cafes` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `place` VARCHAR(45) NOT NULL,
  `score` DOUBLE NOT NULL,
  `table_cout` INT NOT NULL,
  `max_table` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);


-- -----------------------------------------------------
-- Table `registry`.`clients`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `registry`.`clients` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `money` DOUBLE NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);


-- -----------------------------------------------------
-- Table `registry`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `registry`.`orders` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `cafe_id` BIGINT NOT NULL,
  `client_id` BIGINT NOT NULL,
  `bill` DOUBLE NOT NULL,
  `table_number` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Order_Client1_idx` (`client_id` ASC) VISIBLE,
  INDEX `fk_Order_Cafe1_idx` (`cafe_id` ASC) VISIBLE,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  CONSTRAINT `fk_Order_Client1`
    FOREIGN KEY (`client_id`)
    REFERENCES `registry`.`clients` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Order_Cafe1`
    FOREIGN KEY (`cafe_id`)
    REFERENCES `registry`.`cafes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `registry`.`baskets`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `registry`.`baskets` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `order_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Basket_Order1_idx` (`order_id` ASC) VISIBLE,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  CONSTRAINT `fk_Basket_Order1`
    FOREIGN KEY (`order_id`)
    REFERENCES `registry`.`orders` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `registry`.`dishes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `registry`.`dishes` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `basket_id` BIGINT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `cost` DOUBLE NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Dish_Basket1_idx` (`basket_id` ASC) VISIBLE,
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  CONSTRAINT `fk_Dish_Basket1`
    FOREIGN KEY (`basket_id`)
    REFERENCES `registry`.`baskets` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `registry`.`providers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `registry`.`providers` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);


-- -----------------------------------------------------
-- Table `registry`.`dishes_has_providers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `registry`.`dishes_has_providers` (
  `dish_id` BIGINT NOT NULL,
  `provider_id` BIGINT NOT NULL,
  INDEX `fk_Dish_has_Provider_Provider1_idx` (`provider_id` ASC) VISIBLE,
  INDEX `fk_Dish_has_Provider_Dish_idx` (`dish_id` ASC) VISIBLE,
  PRIMARY KEY (`dish_id`, `provider_id`),
  CONSTRAINT `fk_Dish_has_Provider_Dish`
    FOREIGN KEY (`dish_id`)
    REFERENCES `registry`.`dishes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Dish_has_Provider_Provider1`
    FOREIGN KEY (`provider_id`)
    REFERENCES `registry`.`providers` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `registry`.`feedbacks`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `registry`.`feedbacks` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `cafe_id` BIGINT NOT NULL,
  `feedback` VARCHAR(45) NOT NULL,
  `score` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Feedback_Cafe1_idx` (`cafe_id` ASC) VISIBLE,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  CONSTRAINT `fk_Feedback_Cafe1`
    FOREIGN KEY (`cafe_id`)
    REFERENCES `registry`.`cafes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);