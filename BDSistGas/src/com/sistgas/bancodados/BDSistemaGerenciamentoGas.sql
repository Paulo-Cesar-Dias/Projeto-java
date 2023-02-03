-- MySQL Script generated by MySQL Workbench
-- Fri Jan 27 15:53:44 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema BDSistemaGerenciamentoGas
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `BDSistemaGerenciamentoGas` ;

-- -----------------------------------------------------
-- Schema BDSistemaGerenciamentoGas
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `BDSistemaGerenciamentoGas` DEFAULT CHARACTER SET utf8 ;
USE `BDSistemaGerenciamentoGas` ;

-- -----------------------------------------------------
-- Table `BDSistemaGerenciamentoGas`.`funcionarios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BDSistemaGerenciamentoGas`.`funcionarios` ;

CREATE TABLE IF NOT EXISTS `BDSistemaGerenciamentoGas`.`funcionarios` (
  `cpf` INT NOT NULL,
  `nome` VARCHAR(200) NOT NULL,
  `contato` VARCHAR(14) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `endereco` VARCHAR(100) NULL,
  PRIMARY KEY (`cpf`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BDSistemaGerenciamentoGas`.`clientes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BDSistemaGerenciamentoGas`.`clientes` ;

CREATE TABLE IF NOT EXISTS `BDSistemaGerenciamentoGas`.`clientes` (
  `id` INT NOT NULL,
  `nome` VARCHAR(200) NOT NULL,
  `telefone` VARCHAR(13) NOT NULL,
  `endereco` TEXT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BDSistemaGerenciamentoGas`.`caixa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BDSistemaGerenciamentoGas`.`caixa` ;

CREATE TABLE IF NOT EXISTS `BDSistemaGerenciamentoGas`.`caixa` (
  `id` INT NOT NULL,
  `data_abertura` DATE NOT NULL,
  `data_fechamento` DATE NOT NULL,
  `valor_abertura` DOUBLE NOT NULL,
  `valor_fechamento` DOUBLE NOT NULL,
  `situacao` VARCHAR(10) NOT NULL,
  `diferenca` VARCHAR(45) NOT NULL,
  `fkFuncionarios_cpf` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_caixa_funcionarios_idx` (`fkFuncionarios_cpf` ASC) VISIBLE,
  CONSTRAINT `fk_caixa_funcionarios`
    FOREIGN KEY (`fkFuncionarios_cpf`)
    REFERENCES `BDSistemaGerenciamentoGas`.`funcionarios` (`cpf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BDSistemaGerenciamentoGas`.`pedidos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BDSistemaGerenciamentoGas`.`pedidos` ;

CREATE TABLE IF NOT EXISTS `BDSistemaGerenciamentoGas`.`pedidos` (
  `id` INT NOT NULL,
  `data_pedido` DATE NOT NULL,
  `data_entrega` DATE NOT NULL,
  `telefone_cliente` VARCHAR(11) NOT NULL,
  `telefone_destinatario` VARCHAR(11) NOT NULL,
  `hora_pedido` TIME NULL,
  `hora_entrega` TIME NULL,
  `endereco_entrega` VARCHAR(30) NOT NULL,
  `fkClientes_id` INT NOT NULL,
  `fkFuncionarios_cpf` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_pedidos_clientes1_idx` (`fkClientes_id` ASC) VISIBLE,
  INDEX `fk_pedidos_funcionarios1_idx` (`fkFuncionarios_cpf` ASC) VISIBLE,
  CONSTRAINT `fk_pedidos_clientes1`
    FOREIGN KEY (`fkClientes_id`)
    REFERENCES `BDSistemaGerenciamentoGas`.`clientes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pedidos_funcionarios1`
    FOREIGN KEY (`fkFuncionarios_cpf`)
    REFERENCES `BDSistemaGerenciamentoGas`.`funcionarios` (`cpf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BDSistemaGerenciamentoGas`.`produtos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BDSistemaGerenciamentoGas`.`produtos` ;

CREATE TABLE IF NOT EXISTS `BDSistemaGerenciamentoGas`.`produtos` (
  `id` INT NOT NULL,
  `nome` VARCHAR(200) NOT NULL,
  `descricao` VARCHAR(500) NOT NULL,
  `preco_unitario` VARCHAR(45) NOT NULL,
  `fkPedidos_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_produtos_pedidos1_idx` (`fkPedidos_id` ASC) VISIBLE,
  CONSTRAINT `fk_produtos_pedidos1`
    FOREIGN KEY (`fkPedidos_id`)
    REFERENCES `BDSistemaGerenciamentoGas`.`pedidos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BDSistemaGerenciamentoGas`.`cupom_fiscal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BDSistemaGerenciamentoGas`.`cupom_fiscal` ;

CREATE TABLE IF NOT EXISTS `BDSistemaGerenciamentoGas`.`cupom_fiscal` (
  `id` INT NOT NULL,
  `data` DATE NOT NULL,
  `hora` TIME NOT NULL,
  `valor_total` DOUBLE NOT NULL,
  `fkPedidos_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_cupom_fiscal_pedidos1_idx` (`fkPedidos_id` ASC) VISIBLE,
  CONSTRAINT `fk_cupom_fiscal_pedidos1`
    FOREIGN KEY (`fkPedidos_id`)
    REFERENCES `BDSistemaGerenciamentoGas`.`pedidos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BDSistemaGerenciamentoGas`.`produtos_cupom`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BDSistemaGerenciamentoGas`.`produtos_cupom` ;

CREATE TABLE IF NOT EXISTS `BDSistemaGerenciamentoGas`.`produtos_cupom` (
  `qtd` INT NOT NULL,
  `nome_itens` VARCHAR(200) NOT NULL,
  `fkProdutos_id` INT NOT NULL,
  `cupom_fiscal_id` INT NOT NULL,
  INDEX `fk_produtos_cupom_produtos1_idx` (`fkProdutos_id` ASC) VISIBLE,
  PRIMARY KEY (`cupom_fiscal_id`),
  CONSTRAINT `fk_produtos_cupom_produtos1`
    FOREIGN KEY (`fkProdutos_id`)
    REFERENCES `BDSistemaGerenciamentoGas`.`produtos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_produtos_cupom_cupom_fiscal1`
    FOREIGN KEY (`cupom_fiscal_id`)
    REFERENCES `BDSistemaGerenciamentoGas`.`cupom_fiscal` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;