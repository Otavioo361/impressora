INSERT INTO aluguel_impressora.dbo.tipo_cliente
( cd_tipo_cliente, nm_tipo_cliente, nm_usuario, in_tipo_cliente_ativo)
VALUES( 1, 'Titular', 'USUARIO_CRIACAO', 1);


INSERT INTO aluguel_impressora.dbo.pessoa_fisica (dt_nascimento, in_ppe, nm_usuario)
VALUES 
('1985-03-15', 1, 'USUARIO_CRIACAO'),
('1990-07-22', 0, 'USUARIO_CRIACAO'),
('1995-01-30', 1, 'USUARIO_CRIACAO'),
('1980-11-12', 0, 'USUARIO_CRIACAO'),
('2000-05-05', 1, 'USUARIO_CRIACAO');

INSERT INTO aluguel_impressora.dbo.pessoa_juridica (nm_razao_social, dt_abertura, nm_natureza_jurica, nm_usuario)
VALUES 
('Empresa A Ltda', '2010-02-20', 'Sociedade Limitada', 'USUARIO_CRIACAO'),
('Empresa B S/A', '2005-08-15', 'Sociedade Anônima', 'USUARIO_CRIACAO'),
('Empresa C Eireli', '2018-10-01', 'Empresa Individual', 'USUARIO_CRIACAO'),
('Empresa D Ltda', '2012-04-25', 'Sociedade Limitada', 'USUARIO_CRIACAO'),
('Empresa E S/A', '2015-09-18', 'Sociedade Anônima', 'USUARIO_CRIACAO');

INSERT INTO aluguel_impressora.dbo.pessoa (id_pessoa_fisica, cd_cpf_cnpj, nm_pessoa, cd_email, nr_ddd, nr_telefone, nm_usuario)
VALUES 
(1, '12345678901', 'Pessoa Física 1', 'pessoa1@dominio.com', 11, 123456789, 'USUARIO_CRIACAO'),
(2, '23456789012', 'Pessoa Física 2', 'pessoa2@dominio.com', 21, 234567890, 'USUARIO_CRIACAO'),
(3, '34567890123', 'Pessoa Física 3', 'pessoa3@dominio.com', 31, 345678901, 'USUARIO_CRIACAO'),
(4, '45678901234', 'Pessoa Física 4', 'pessoa4@dominio.com', 41, 456789012, 'USUARIO_CRIACAO'),
(5, '56789012345', 'Pessoa Física 5', 'pessoa5@dominio.com', 51, 567890123, 'USUARIO_CRIACAO');


INSERT INTO aluguel_impressora.dbo.pessoa (id_pessoa_juridica, cd_cpf_cnpj, nm_pessoa, cd_email, nr_ddd, nr_telefone, nm_usuario)
VALUES 
(1, '12345678000199', 'Empresa A Ltda', 'empresa1@dominio.com', 11, 123456789, 'USUARIO_CRIACAO'),
(2, '23456789000188', 'Empresa B S/A', 'empresa2@dominio.com', 21, 234567890, 'USUARIO_CRIACAO'),
(3, '34567890000177', 'Empresa C Eireli', 'empresa3@dominio.com', 31, 345678901, 'USUARIO_CRIACAO'),
(4, '45678901000166', 'Empresa D Ltda', 'empresa4@dominio.com', 41, 456789012, 'USUARIO_CRIACAO'),
(5, '56789012000155', 'Empresa E S/A', 'empresa5@dominio.com', 51, 567890123, 'USUARIO_CRIACAO');

INSERT INTO aluguel_impressora.dbo.cliente (id_pessoa, id_tipo_cliente, nm_usuario)
VALUES 
(1, 1, 'usuUSUARIO_CRIACAOario1'),
(2, 1, 'USUARIO_CRIACAO'),
(3, 1, 'USUARIO_CRIACAO'),
(4, 1, 'USUARIO_CRIACAO'),
(5, 1, 'USUARIO_CRIACAO'),
(6, 1, 'USUARIO_CRIACAO'),
(7, 1, 'USUARIO_CRIACAO'),
(8, 1, 'USUARIO_CRIACAO'),
(9, 1, 'USUARIO_CRIACAO'),
(10, 1, 'USUARIO_CRIACAO');
