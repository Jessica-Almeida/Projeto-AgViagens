CREATE DATABASE agc_viagens;
USE agc_viagens;
INSERT INTO acesso (tipo)
VALUES ('Admin');
SELECT * FROM acesso;
INSERT INTO cliente (cpf, email, nome, senha, id_acesso) # A senha criptografada é senha123
VALUES (12312312312, 'jessi@email', 'jessi','$2a$10$/F001C9r0Km1rE.xL4DcrupHlNikymdyOL4ieIRGfcJCq/IPhn8WS', 1);
SELECT * FROM cliente;