INSERT INTO aluguel_impressora.dbo.usuario
(id_pessoa, nm_usuario, in_usuario_ativo)
VALUES(1, 'MGFREITAS', 1);

INSERT INTO aluguel_impressora.dbo.[login]
(id_usuario, nm_username, cd_email, cd_cpf_cnpj, hash_password, in_login_ativo)
VALUES( 1, 'MGFREITAS', 'misaelg.freitas2000@gmail.com', '08467856505', '$2a$10$v9jAnvwAQzaaYpScqjiXCupZATI/1z5sHrIO1z5kKCgkQrFIWWJ.O', 1);