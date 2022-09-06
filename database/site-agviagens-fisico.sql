CREATE DATABASE agencia_viagens;

USE agencia_viagens;

CREATE TABLE acesso (
id_acesso INT PRIMARY KEY AUTO_INCREMENT,
tipo_acesso VARCHAR(10)
);

CREATE TABLE destino (
id_destino INT PRIMARY KEY AUTO_INCREMENT,
pais VARCHAR(50) ,
cidade VARCHAR(50),
data_ida DATE,
data_volta DATE,
preco DECIMAL(10,2)
);

CREATE TABLE cliente (
id_cliente INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(80),
email VARCHAR(80),
senha VARCHAR(15),
cpf VARCHAR(14),
id_acesso INT,
FOREIGN KEY(id_acesso) REFERENCES acesso (id_acesso)
);

CREATE TABLE compra (
id_compra INT PRIMARY KEY AUTO_INCREMENT,
data_compra DATETIME,
quantidade INT,
total DECIMAL(10,2),
id_destino INT,
id_cliente INT,
FOREIGN KEY(id_destino) REFERENCES destino (id_destino),
FOREIGN KEY(id_cliente) REFERENCES cliente (id_cliente)
);

