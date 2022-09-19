CREATE DATABASE IF NOT EXISTS Portal;
USE Portal;


-- LOGIN USUARIO
CREATE TABLE Usuario (
	idUsuario INT AUTO_INCREMENT PRIMARY KEY,
    usuario VARCHAR(20) NOT NULL,
    telefone VARCHAR(15),
    login VARCHAR(15) NOT NULL UNIQUE,
    senha VARCHAR(20) NOT NULL
);

DESC Usuario;

-- Insere um usuario na tabela acima
INSERT INTO Usuario(idUsuario, usuario, telefone, login, senha)
VALUES(1, 'Administrador', '1199999999', 'admin', 'admin');

SELECT * FROM Usuario;

-- Modifica os dados de um usuario criado
UPDATE Usuario SET idUsuario = '1' WHERE idUsuario = 2;

-- Apaga registro da tabela.
DELETE FROM Usuario WHERE idUsuario = 1;

-- CADASTRO DO FUNCIONARIO
CREATE TABLE Cliente (
	idCliente INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(45) NOT NULL,
    CPF CHAR(11) NOT NULL,
    empresa VARCHAR(20),
    setor VARCHAR(45),
    dataCadastro DATE NOT NULL
);

DESC Cliente;

INSERT INTO Cliente(nome, CPF, empresa, setor, dataCadastro)
VALUES('Diego Silva', '39144622958', 'LUFT', 'TI', '2022/09/18');

SELECT * FROM Cliente;

-- CADASTRO DOS ATIVOS PERTENCENTES AOS FUNCIONÁRIOS
CREATE TABLE Ativos(
	idAtivos INT AUTO_INCREMENT PRIMARY KEY,
    dataAtivos TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modeloCelular VARCHAR(30),
    imeiCelular VARCHAR(30),
    corCelular VARCHAR(15),
    foneOuvido VARCHAR(15),
    corFone VARCHAR(30),
    modeloRelogio VARCHAR(30),
    imeiRelogio VARCHAR(30),
    corRelogio VARCHAR(30),
    carregadorSN VARCHAR(30),
    idCliente INT NOT NULL,
    FOREIGN KEY(idCliente) REFERENCES Cliente(idCliente)
);

DESC Ativos;

INSERT INTO Ativos (modeloCelular, imeiCelular, corCelular, foneOuvido, corFone, modeloRelogio, imeiRelogio, corRelogio, carregadorSN, idCliente)
VALUES ('Xiaomi MI 11Lite', '134687986516516', 'Preto', 'Sim', 'Branco', 'Samsung Smart Watch', '5646576541657', 'Preto', '321576541651', 1);

SELECT * FROM Ativos;

-- Relatório Geral ( CLiente, Ativos )
SELECT
A.modeloCelular, imeiCelular, corCelular, foneOuvido, corFone, modeloRelogio, imeiRelogio, corRelogio, carregadorSN,
C.nome, CPF, setor
FROM Ativos AS A
INNER JOIN Cliente AS C
ON (A.idCliente = C.idCliente);