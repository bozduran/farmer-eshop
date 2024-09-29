DROP SCHEMA IF EXISTS `full-stack-eshop`;
CREATE SCHEMA `full-stack-eshop`;
USE `full-stack-eshop` ;

-- Brand Table
CREATE TABLE IF NOT EXISTS `full-stack-eshop`.`brand` (
                                                          `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
                                                          `brand_name` VARCHAR(255) NOT NULL,
                                                          `version` INT,
                                                          `created_date` DATETIME(6) DEFAULT NULL,
                                                          `update_date` DATETIME(6) DEFAULT NULL,
                                                          PRIMARY KEY (`id`)
)
    ENGINE=InnoDB
    AUTO_INCREMENT = 1;
-- Product Category Table
CREATE TABLE IF NOT EXISTS `full-stack-eshop`.`product_category` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `category_name` VARCHAR(255) NULL DEFAULT NULL,
    PRIMARY KEY (`id`))
    ENGINE=InnoDB
    AUTO_INCREMENT = 1;


-- Product Table
CREATE TABLE IF NOT EXISTS `full-stack-eshop`.`product` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `version` INT,
    `stock_quantity` INT,
    `price` DECIMAL NOT NULL ,
    `product_name` VARCHAR(255) NOT NULL,
    `description` VARCHAR(255),
    `created_date` DATETIME(6) DEFAULT NULL,
    `image_url` VARCHAR(255),
    `update_date` DATETIME(6) DEFAULT NULL,
    `category_id` BIGINT(20) NOT NULL,
    `brand_id` BIGINT(20) NOT NULL,
    PRIMARY KEY (`id`),
    KEY `fk_category` (`category_id`),
    CONSTRAINT `fk_category` FOREIGN KEY (`category_id`) REFERENCES `product_category` (`id`),
    KEY `fk_brand` (`brand_id`),
    CONSTRAINT `fk_brand` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`)
    )
    ENGINE=InnoDB
    AUTO_INCREMENT = 1;

