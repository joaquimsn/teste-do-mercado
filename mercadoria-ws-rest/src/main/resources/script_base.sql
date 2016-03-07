DROP DATABASE IF EXISTS teste_mercado;
CREATE DATABASE teste_mercado;
USE teste_mercado;

CREATE TABLE mercadoria (
	id_mercadoria INT NOT NULL,
    codigo VARCHAR(64) NOT NULL,
    tipo VARCHAR(128) NOT NULL,
    nome VARCHAR(256) NOT NULL,
    quantidade INT NOT NULL,
    preco DOUBLE NOT NULL,
    tipo_negocio INT NOT NULL,
	data_cadastro TIMESTAMP NOT NULL,
	data_manutencao TIMESTAMP,
	ativo BIT(0) NOT NULL NOT NULL
);

ALTER TABLE mercadoria ADD CONSTRAINT PK_mercadoria PRIMARY KEY(id_mercadoria);
ALTER TABLE mercadoria MODIFY COLUMN id_mercadoria INT AUTO_INCREMENT;

ALTER TABLE mercadoria ALTER COLUMN data_cadastro DROP DEFAULT;