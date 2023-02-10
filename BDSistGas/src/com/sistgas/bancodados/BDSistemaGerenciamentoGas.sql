-- MySQL Script generated by MySQL Workbench
-- Sun Feb  5 09:34:38 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema BDSistemaGerenciamentoGas
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema BDSistemaGerenciamentoGas
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `BDSistemaGerenciamentoGas` DEFAULT CHARACTER SET utf8 ;
USE `BDSistemaGerenciamentoGas` ;

-- -----------------------------------------------------
-- Table `BDSistemaGerenciamentoGas`.`funcionarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BDSistemaGerenciamentoGas`.`funcionarios` (
  `cpf` INT NOT NULL,
  `nome` VARCHAR(200) NOT NULL,
  `contato` VARCHAR(14) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `endereco` VARCHAR(100) NULL,
  PRIMARY KEY (`cpf`));


-- -----------------------------------------------------
-- Table `BDSistemaGerenciamentoGas`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BDSistemaGerenciamentoGas`.`clientes` (
  `id` INT AUTO_INCREMENT,
  `nome` VARCHAR(200) NOT NULL,
  `telefone` VARCHAR(13) NOT NULL,
  `endereco` TEXT NOT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `BDSistemaGerenciamentoGas`.`caixa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BDSistemaGerenciamentoGas`.`caixa` (
  `id` INT AUTO_INCREMENT NOT NULL,
  `data_abertura` DATE NOT NULL,
  `data_fechamento` DATE ,
  `valor_abertura` DOUBLE NOT NULL,
  `valor_fechamento` DOUBLE ,
  `situacao` VARCHAR(10) ,
  `fkFuncionarios_cpf` INT NOT NULL,
  PRIMARY KEY (`id`),
    FOREIGN KEY (`fkFuncionarios_cpf`)
    REFERENCES `BDSistemaGerenciamentoGas`.`funcionarios` (`cpf`)
    );

select * from funcionarios;
-- -----------------------------------------------------
-- Table `BDSistemaGerenciamentoGas`.`pedidos`
-- -----------------------------------------------------
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
    FOREIGN KEY (`fkClientes_id`)
    REFERENCES `BDSistemaGerenciamentoGas`.`clientes` (`id`),
    FOREIGN KEY (`fkFuncionarios_cpf`)
    REFERENCES `BDSistemaGerenciamentoGas`.`funcionarios` (`cpf`)
    );


-- -----------------------------------------------------
-- Table `BDSistemaGerenciamentoGas`.`produtos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BDSistemaGerenciamentoGas`.`produtos` (
  `id` INT NOT NULL auto_increment,
  `nome` VARCHAR(200) NOT NULL,
  `descricao` VARCHAR(500) NOT NULL,
  `preco_unitario` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`)
  );


-- -----------------------------------------------------
-- Table `BDSistemaGerenciamentoGas`.`cupom_fiscal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BDSistemaGerenciamentoGas`.`cupom_fiscal` (
  `id` INT NOT NULL,
  `data` DATE NOT NULL,
  `hora` TIME NOT NULL,
  `valor_total` DOUBLE NOT NULL,
  `fkPedidos_id` INT NOT NULL,
  PRIMARY KEY (`id`),
    FOREIGN KEY (`fkPedidos_id`)
    REFERENCES `BDSistemaGerenciamentoGas`.`pedidos` (`id`)
    );

-- -----------------------------------------------------
-- Table `BDSistemaGerenciamentoGas`.`produtos_cupom`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BDSistemaGerenciamentoGas`.`produtos_cupom` (
  `qtd` INT NOT NULL,
  `nome_itens` VARCHAR(200) NOT NULL,
  `fkProdutos_id` INT NOT NULL,
  `cupom_fiscal_id` INT NOT NULL,
  PRIMARY KEY (`cupom_fiscal_id`),
    FOREIGN KEY (`fkProdutos_id`)
    REFERENCES `BDSistemaGerenciamentoGas`.`produtos` (`id`),
    FOREIGN KEY (`cupom_fiscal_id`)
    REFERENCES `BDSistemaGerenciamentoGas`.`cupom_fiscal` (`id`)
    );


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
