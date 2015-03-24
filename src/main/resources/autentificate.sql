CREATE SCHEMA `autentificate` ;

CREATE TABLE `autentificate`.`users` (
  `user_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(25) NOT NULL,
  `login` VARCHAR(25) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `salt` VARCHAR(20) NOT NULL,
  `date_last_login` DATE NULL DEFAULT NULL,
  `IP` VARCHAR(20) NULL DEFAULT NULL,
  `email` VARCHAR(100) NOT NULL,
  `role` INT NOT NULL DEFAULT 2,
  PRIMARY KEY (`user_id`));


CREATE TABLE `autentificate`.`entrance` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `iduser` INT UNSIGNED NOT NULL,
  `IP` VARCHAR(20) NULL DEFAULT NULL,
  `failed_attempts` INT NOT NULL DEFAULT 0,
  `blocking` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  INDEX `iduser_idx` (`iduser` ASC),
  CONSTRAINT `iduser`
    FOREIGN KEY (`iduser`)
    REFERENCES `autentificate`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


ALTER TABLE `autentificate`.`users` 
DROP FOREIGN KEY `role`;
ALTER TABLE `autentificate`.`users` 
ADD CONSTRAINT `role`
  FOREIGN KEY (`role`)
  REFERENCES `autentificate`.`role` (`idrole`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


INSERT INTO `autentificate`.`role` (`idrole`, `role`) VALUES ('1', 'admin');
INSERT INTO `autentificate`.`role` (`idrole`, `role`) VALUES ('2', 'user');

ALTER TABLE `autentificate`.`role` 
ADD CONSTRAINT `idrole`
  FOREIGN KEY (`idrole`)
  REFERENCES `autentificate`.`users` (`role`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
