INSERT INTO aluguel_impressora.dbo.tipo_recorrencia
(cd_tipo_recorrencia, nm_tipo_recorrencia, nm_usuario, in_tipo_recorrencia_ativo)
VALUES
(1, 'DIÁRIO', 'USUARIO_CRIACAO', 1),
(2, 'MENSAL', 'USUARIO_CRIACAO', 1),
(3, 'BIMESTRAL', 'USUARIO_CRIACAO', 1),
(4, 'SEMESTRAL', 'USUARIO_CRIACAO', 1),
(5, 'ANUAL', 'USUARIO_CRIACAO', 1),
(6, 'ÚNICA', 'USUARIO_CRIACAO', 1)
;

INSERT INTO aluguel_impressora.dbo.tipo_taxa
(cd_tipo_taxa, nm_tipo_taxa, nm_usuario, in_tipo_taxa_ativo)
VALUES
(1, 'Taxa básica aluguel impressora Jato de tinta', 'USUARIO_CRIACAO', 1),
(2, 'Taxa básica aluguel impressora 3D', 'USUARIO_CRIACAO', 1),
(3, 'Taxa básica aluguel impressora Matricial', 'USUARIO_CRIACAO', 1),
(4, 'Taxa básica aluguel impressora Laser', 'USUARIO_CRIACAO', 1),
(5, 'Taxa básica aluguel impressora Térmica', 'USUARIO_CRIACAO', 1),
(6, 'Taxa Cartucho', 'USUARIO_CRIACAO', 1),
(7, 'Taxa Toner', 'USUARIO_CRIACAO', 1),
(8, 'Taxa Fita', 'USUARIO_CRIACAO', 1),
(9, 'Taxa Bobina térmica', 'USUARIO_CRIACAO', 1),
(10, 'Taxa Papel carbono', 'USUARIO_CRIACAO', 1),
(11, 'Taxa Filamento PLA', 'USUARIO_CRIACAO', 1),
(12, 'Taxa Filamento ABS', 'USUARIO_CRIACAO', 1),
(13, 'Taxa Filamento PETG', 'USUARIO_CRIACAO', 1),
(15, 'Taxa Filamento PC', 'USUARIO_CRIACAO', 1),
(16, 'Taxa Filamento PVA', 'USUARIO_CRIACAO', 1),
(17, 'Taxa Filamento Fibra de carbono', 'USUARIO_CRIACAO', 1)
;

INSERT INTO aluguel_impressora.dbo.taxa
(id_tipo_taxa, vl_taxa, nm_usuario, in_taxa_ativo,id_tipo_recorrencia)
VALUES
(1, 30.00, 'USUARIO_CRIACAO', 1,2),
(2, 120.00, 'USUARIO_CRIACAO', 1,2),
(3, 15.00, 'USUARIO_CRIACAO', 1,2),
(4, 25.00, 'USUARIO_CRIACAO', 1,2),
(5, 5.00, 'USUARIO_CRIACAO', 1,2),
(6, 85.00, 'USUARIO_CRIACAO', 1,6),
(7, 179.00, 'USUARIO_CRIACAO', 1,6),
(8, 69.00, 'USUARIO_CRIACAO', 1,6),
(9, 36.00, 'USUARIO_CRIACAO', 1,6),
(10, 95.00, 'USUARIO_CRIACAO', 1,6),
(11, 245.00, 'USUARIO_CRIACAO', 1,6),
(12, 300.00, 'USUARIO_CRIACAO', 1,6),
(13, 190.00, 'USUARIO_CRIACAO', 1,6),
(14, 340.00, 'USUARIO_CRIACAO', 1,6),
(15, 260.00, 'USUARIO_CRIACAO', 1,6),
(16, 450.00, 'USUARIO_CRIACAO', 1,6)
;