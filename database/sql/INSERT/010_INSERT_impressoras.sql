INSERT INTO aluguel_impressora.dbo.tipo_impressora
(
    cd_tipo_impressora, 
    nm_tipo_impressora, 
    qt_impressora, 
    qt_impressora_disponivel, 
    qt_impressora_alugada, 
    nm_usuario, 
    in_tipo_impressora_ativo
)
VALUES
(1,"Jato de tinta",15,15,0,'USUARIO_CRIACAO',1),
(2,"Térmica",20,20,0,'USUARIO_CRIACAO',1),
(3,"Laser",5,5,0,'USUARIO_CRIACAO',1),
(4,"Impressora Matricial",7,7,0,'USUARIO_CRIACAO',1),
(5,"Impressora 3D",4,4,0,'USUARIO_CRIACAO',1)
;


INSERT INTO aluguel_impressora.dbo.marca_impressora (nm_marca_impressora, dt_inclusao, in_marca_impressora_ativo)
SELECT nm_marca_impressora, GETDATE(), 1
FROM (VALUES
    ('HP'),
    ('Epson'),
    ('Canon'),
    ('Brother'),
    ('Lexmark'),
    ('Samsung'),
    ('Ricoh'),
    ('Zebra'),
    ('Dymo'),
    ('Bixolon'),
    ('TSC'),
    ('Xerox'),
    ('Kyocera'),
    ('OKI'),
    ('Ultimaker'),
    ('Prusa'),
    ('Creality'),
    ('MakerBot')
) AS marcas(nm_marca_impressora)
WHERE NOT EXISTS (
    SELECT 1 FROM aluguel_impressora.dbo.marca_impressora mi
    WHERE mi.nm_marca_impressora = marcas.nm_marca_impressora
);



INSERT INTO aluguel_impressora.dbo.modelo_impressora (
    id_marca_impressora, id_tipo_impressora, id_taxa, nm_modelo_impressora, qt_impressora, qt_impressora_disponivel, qt_impressora_alugada, dt_inclusao, in_modelo_impressora_ativo
)
SELECT
    (SELECT id_marca_impressora FROM aluguel_impressora.dbo.marca_impressora WHERE nm_marca_impressora = modelos.nm_marca_impressora),
    (SELECT id_tipo_impressora FROM aluguel_impressora.dbo.tipo_impressora WHERE nm_tipo_impressora = modelos.nm_tipo_impressora),
    (SELECT id_taxa FROM aluguel_impressora.dbo.taxa WHERE id_tipo_taxa = modelos.id_tipo_taxa),
    modelos.nm_modelo_impressora,
    modelos.quantidades, -- Quantidade total fictícia
    modelos.quantidades,  -- Disponíveis para aluguel
    0,  -- Já alugadas
    GETDATE(),
    1 -- Ativo
FROM (VALUES
    -- Jato de Tinta
    ('HP', 'Jato de tinta', 'DeskJet 3776',1,5),
    ('Epson', 'Jato de tinta', 'EcoTank L3250',1,5),
    ('Canon', 'Jato de tinta', 'Pixma G3110',1,3),
    ('Brother', 'Jato de tinta', 'DCP-T420W',1,2),
    
    -- Térmica
    ('Zebra', 'Térmica', 'ZD420',5,4),
    ('Dymo', 'Térmica', 'LabelWriter 450',5,4),
    ('Bixolon', 'Térmica', 'SRP-350III',5,4),
    ('TSC', 'Térmica', 'TTP-244 Pro',5,4),

    -- Laser
    ('Lexmark', 'Laser', 'MS431dw',4,1),
    ('Samsung', 'Laser', 'Xpress SL-M2020W',4,1),
    ('Xerox', 'Laser', 'WorkCentre 3215',4,1),
    ('Kyocera', 'Laser', 'ECOSYS P2040dn',4,1),
    ('Ricoh', 'Laser', 'SP C261DNw',4,1),
    ('OKI', 'Laser', 'C332dn',4,1),

    -- Matricial
    ('Epson', 'Impressora Matricial', 'LX-350',3,5),
    ('OKI', 'Impressora Matricial', 'Microline 320 Turbo',3,2),

    -- 3D
    ('Ultimaker', 'Impressora 3D', 'Ultimaker S3',2,1),
    ('Prusa', 'Impressora 3D', 'Prusa i3 MK3S+',2,1),
    ('Creality', 'Impressora 3D', 'Ender 3 V2',2,1),
    ('MakerBot', 'Impressora 3D', 'Replicator+',2,1)
) AS modelos(nm_marca_impressora, nm_tipo_impressora, nm_modelo_impressora,id_tipo_taxa, quantidades)
WHERE NOT EXISTS (
    SELECT 1 FROM aluguel_impressora.dbo.modelo_impressora mi
    JOIN aluguel_impressora.dbo.marca_impressora m ON mi.id_marca_impressora = m.id_marca_impressora
    JOIN aluguel_impressora.dbo.tipo_impressora t ON mi.id_tipo_impressora = t.id_tipo_impressora
    WHERE m.nm_marca_impressora = modelos.nm_marca_impressora
    AND t.nm_tipo_impressora = modelos.nm_tipo_impressora
    AND mi.nm_modelo_impressora = modelos.nm_modelo_impressora
);


INSERT INTO aluguel_impressora.dbo.impressora (
    id_fornecedor_impressora, id_modelo_impressora, cd_serie_impressora, cd_barras_impressora,
    dt_inclusao, in_impressora_alugada, in_impressora_disponivel
)
SELECT 
    f.id_fornecedor,
    m.id_modelo_impressora,
    CONCAT('SN', RIGHT(NEWID(), 10)), -- Número de série aleatório
    RIGHT(ABS(CHECKSUM(NEWID())), 9), -- Código de barras aleatório
    GETDATE(),
    0, -- Não alugada
    1  -- Disponível
FROM aluguel_impressora.dbo.fornecedor f
JOIN aluguel_impressora.dbo.marca_impressora ma ON f.nm_fornecedor LIKE ma.nm_marca_impressora+'%'
JOIN aluguel_impressora.dbo.modelo_impressora m ON ma.id_marca_impressora = m.id_marca_impressora
WHERE NOT EXISTS (
    SELECT 1 FROM aluguel_impressora.dbo.impressora i
    WHERE i.id_fornecedor_impressora = f.id_fornecedor AND i.id_modelo_impressora = m.id_modelo_impressora
);