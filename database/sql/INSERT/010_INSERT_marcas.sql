
INSERT INTO aluguel_impressora.dbo.marca (nm_marca, dt_inclusao, in_marca_ativo)
SELECT nm_marca, GETDATE(), 1
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
    ('MakerBot'),
    ('3D Systems'),
    ('Creality')
) AS marcas(nm_marca)
WHERE NOT EXISTS (
    SELECT 1 FROM aluguel_impressora.dbo.marca mi
    WHERE mi.nm_marca = marcas.nm_marca
);