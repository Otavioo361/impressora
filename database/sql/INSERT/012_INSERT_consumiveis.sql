INSERT INTO aluguel_impressora.dbo.tipo_consumivel (
    cd_tipo_consumivel,
    nm_tipo_consumivel, 
    id_tipo_impressora,
    nm_usuario, 
    in_tipo_consumivel_ativo
) 
VALUES 
    (1, 'Cartucho',1, 'USUARIO_CRIACAO', 1),
    (2, 'Toner',3,  'USUARIO_CRIACAO', 1),
    (3, 'Fita',null, 'USUARIO_CRIACAO', 1),
    (4, 'Bobina térmica',2, 'USUARIO_CRIACAO', 1),
    (5, 'Papel carbono',4, 'USUARIO_CRIACAO', 1),
    (6, 'Filamento PLA',5, 'USUARIO_CRIACAO', 1),
    (7, 'Filamento ABS',5, 'USUARIO_CRIACAO', 1),
    (8, 'Filamento PETG',5, 'USUARIO_CRIACAO', 1),
    (9, 'Filamento PC',5, 'USUARIO_CRIACAO', 1),
    (10, 'Filamento PVA',5, 'USUARIO_CRIACAO', 1),
    (11, 'Filamento Fibra de carbono',5, 'USUARIO_CRIACAO', 1)
;


INSERT INTO aluguel_impressora.dbo.modelo_consumivel (
    id_marca_consumivel, 
    id_tipo_consumivel, 
    id_taxa, 
    nm_modelo_consumivel, 
    qt_consumivel, 
    qt_consumivel_disponivel, 
    qt_consumivel_usado, 
    nm_usuario, 
    in_modelo_consumivel_ativo
) 
VALUES 
    (1, 1, 6, 'HP 901', 100, 100, 0,  'USUARIO_CRIACAO', 1),
    (2, 2, 7, 'Epson 664', 200, 200, 0, 'USUARIO_CRIACAO', 1),
    (3, 3, 8, 'Brother TZe-231', 150, 150, 0, 'USUARIO_CRIACAO', 1),
    (4, 4, 9, 'Canon KP-108IN', 120, 120, 0, 'USUARIO_CRIACAO', 1),
    (5, 5, 10, 'Lexmark 12A1970', 90, 90, 0, 'USUARIO_CRIACAO', 1),
    (6, 6, 11, 'Zebra Z-Perform', 110, 110, 0, 'USUARIO_CRIACAO', 1),
    (7, 7, 11, '3D Systems PLA', 80, 80, 0, 'USUARIO_CRIACAO', 1),
    (8, 8, 11, 'Creality Ender PLA', 85, 85, 0, 'USUARIO_CRIACAO', 1),
    (9, 9, 13, 'Prusa PETG', 95, 95, 0, 'USUARIO_CRIACAO', 1);




INSERT INTO aluguel_impressora.dbo.consumivel (
    id_tipo_consumivel,
    id_fornecedor_consumivel,
    id_modelo_consumivel,
    id_impressora,
    cd_barras_consumivel,
    nm_consumivel,
    dt_consumido,
    in_em_consumo,
    dt_validade_consumivel,
    nm_usuario,
    in_consumivel_ativo
) 
SELECT 
    id_tipo_consumivel, 
    (
    SELECT f.id_fornecedor FROM aluguel_impressora.dbo.fornecedor f
    JOIN aluguel_impressora.dbo.marca ma ON f.nm_fornecedor LIKE ma.nm_marca+'%'
    JOIN aluguel_impressora.dbo.modelo_consumivel m ON ma.id_marca = m.id_marca_consumivel
    WHERE id_modelo_consumivel = mc.id_modelo_consumivel
    ) AS  id_fornecedor_consumivel, 
    mc.id_modelo_consumivel, 
    NULL AS id_impressora, 
    RIGHT(ABS(CHECKSUM(NEWID())), 9) AS cd_barras_consumivel,
    mc.nm_modelo_consumivel AS nm_consumivel,
    NULL AS dt_consumido,
    0 AS in_em_consumo,
    DATEADD(YEAR, 2, GETDATE()) AS dt_validade_consumivel,
    'USUARIO_CRIACAO' AS nm_usuario,
    1 AS in_consumivel_ativo
FROM aluguel_impressora.dbo.modelo_consumivel mc
CROSS APPLY (SELECT TOP (qt_consumivel) 1 AS n FROM master.dbo.spt_values) AS x;
