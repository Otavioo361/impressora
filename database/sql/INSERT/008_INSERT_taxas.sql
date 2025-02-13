INSERT INTO aluguel_impressora.dbo.tipo_recorrencia
(cd_tipo_recorrencia, nm_tipo_recorrencia, nm_usuario, in_tipo_recorrencia_ativo)
VALUES
(1, 'DIÁRIO', 'USUARIO_CRIACAO', 1),
(2, 'MENSAL', 'USUARIO_CRIACAO', 1),
(3, 'BIMESTRAL', 'USUARIO_CRIACAO', 1),
(4, 'SEMESTRAL', 'USUARIO_CRIACAO', 1),
(5, 'ANUAL', 'USUARIO_CRIACAO', 1)
;

INSERT INTO aluguel_impressora.dbo.tipo_taxa
(cd_tipo_taxa, nm_tipo_taxa, nm_usuario, in_tipo_taxa_ativo)
VALUES
(1, 'Taxa básica aluguel impressora Jato de tinta', 'USUARIO_CRIACAO', 1),
(2, 'Taxa básica aluguel impressora 3D', 'USUARIO_CRIACAO', 1),
(3, 'Taxa básica aluguel impressora Matricial', 'USUARIO_CRIACAO', 1),
(4, 'Taxa básica aluguel impressora Laser', 'USUARIO_CRIACAO', 1),
(5, 'Taxa básica aluguel impressora Térmica', 'USUARIO_CRIACAO', 1),
(6, 'Taxa corretagem', 'USUARIO_CRIACAO', 1)
;

INSERT INTO aluguel_impressora.dbo.taxa
(id_tipo_taxa, vl_taxa, nm_usuario, in_taxa_ativo,id_tipo_recorrencia)
VALUES
(1, 30.00, 'USUARIO_CRIACAO', 1,2),
(2, 120.00, 'USUARIO_CRIACAO', 1,2),
(3, 15.00, 'USUARIO_CRIACAO', 1,2),
(4, 25.00, 'USUARIO_CRIACAO', 1,2),
(5, 5.00, 'USUARIO_CRIACAO', 1,2),
(6, 10.00, 'USUARIO_CRIACAO', 1,2)
;