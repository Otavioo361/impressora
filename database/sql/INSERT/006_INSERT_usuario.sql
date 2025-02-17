INSERT INTO aluguel_impressora.dbo.usuario
(id_pessoa, nm_usuario, in_usuario_ativo)
VALUES
(1, 'MGFREITAS', 1),
(2, 'OTRISTAO', 1),
(3, 'TESTE', 1);

INSERT INTO aluguel_impressora.dbo.[login]
(id_usuario, nm_username, cd_email, cd_cpf_cnpj, hash_password, in_login_ativo)
VALUES
( 1, 'MGFREITAS', 'misaelg.freitas2000@gmail.com', '08467856505', '$2a$12$G3do05Km3AnNGi94ylsCR.dem.4c3d3l/Fz2pkyt9GOpMC5npyWvW', 1),
( 2, 'OTRISTAO', 'otavio@gmail.com', '59188948021', '$2a$12$G3do05Km3AnNGi94ylsCR.dem.4c3d3l/Fz2pkyt9GOpMC5npyWvW', 1),
( 3, 'TESTE', 'teste@teste.com', '12312312312', '$2a$12$G3do05Km3AnNGi94ylsCR.dem.4c3d3l/Fz2pkyt9GOpMC5npyWvW', 1)
;