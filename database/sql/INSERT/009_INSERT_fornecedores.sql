INSERT INTO aluguel_impressora.dbo.tipo_fornecedor
( cd_tipo_fornecedor, nm_tipo_fornecedor,nm_usuario, in_tipo_fornecedor_ativo)
VALUES
(1, 'Distribuidor Oficial','USUARIO_CRIACAO', 1),
(2, 'Direto da fábrica','USUARIO_CRIACAO', 1),
(3, 'Revendedor','USUARIO_CRIACAO', 1),
(4, 'Suprimentos consumiveis','USUARIO_CRIACAO', 1),
(5, 'Assistência técnica','USUARIO_CRIACAO', 1)
;


INSERT INTO aluguel_impressora.dbo.fornecedor (
    id_tipo_fornecedor, nm_fornecedor,cd_cnpj_fornecedor, cd_url_site_fornecedor, nm_contato_fornecedor, 
    cd_telefone_contato_fornecedor, cd_email_contato_fornecedor, dt_inicio_contrato, in_fornecedor_disponivel
)
SELECT 
    (SELECT id_tipo_fornecedor FROM aluguel_impressora.dbo.tipo_fornecedor WHERE nm_tipo_fornecedor = 'Distribuidor Oficial'), -- Ajuste conforme necessário
    fornecedores.nm_fornecedor, 
    fornecedores.cd_cnpj_fornecedor,
    fornecedores.cd_url_site_fornecedor, 
    fornecedores.nm_contato_fornecedor, 
    fornecedores.cd_telefone_contato_fornecedor, 
    fornecedores.cd_email_contato_fornecedor, 
    DATEADD(YEAR, -2, GETDATE()),
    1 
FROM (VALUES
    ('HP Distribuidora','22345678000190', 'https://www.hp.com', 'João Silva', '5511999990001', 'contato@hp.com'),
    ('Epson Brasil','52109345000165', 'https://www.epson.com.br', 'Maria Souza', '5511999990002', 'contato@epson.com.br'),
    ('Canon Solutions','18456789000132', 'https://www.canon.com.br', 'Carlos Oliveira', '5511999990003', 'contato@canon.com.br'),
    ('Brother Suprimentos','33987654000178', 'https://www.brother.com.br', 'Fernanda Lima', '5511999990004', 'contato@brother.com.br'),
    ('Lexmark Parceiros','41234567000121', 'https://www.lexmark.com', 'Ricardo Mendes', '5511999990005', 'contato@lexmark.com'),
    ('Samsung Impressoras','29876543000145', 'https://www.samsung.com.br', 'Aline Castro', '5511999990006', 'contato@samsung.com.br'),
    ('Ricoh Distribuição','11223344000167', 'https://www.ricoh.com.br', 'Bruno Ferreira', '5511999990007', 'contato@ricoh.com.br'),
    ('Zebra Tecnologias','55667889000189', 'https://www.zebra.com', 'Tatiane Almeida', '5511999990008', 'contato@zebra.com'),
    ('Dymo Soluções','66778899000134', 'https://www.dymo.com', 'Gustavo Ramos', '5511999990009', 'contato@dymo.com'),
    ('Bixolon América','77889900000156', 'https://www.bixolon.com', 'Sandra Martins', '5511999990010', 'contato@bixolon.com'),
    ('TSC Automação','88990111000178', 'https://www.tscprinters.com', 'Daniel Rocha', '5511999990011', 'contato@tsc.com'),
    ('Xerox Brasil','99101112000190', 'https://www.xerox.com', 'Helena Carvalho', '5511999990012', 'contato@xerox.com'),
    ('Kyocera Solutions','10112113000112', 'https://www.kyocera.com.br', 'Fábio Nunes', '5511999990013', 'contato@kyocera.com.br'),
    ('OKI Impressoras','20123124000123', 'https://www.oki.com.br', 'Patrícia Duarte', '5511999990014', 'contato@oki.com.br'),
    ('Ultimaker 3D','30134145000134', 'https://www.ultimaker.com', 'Marcelo Teixeira', '5511999990015', 'contato@ultimaker.com'),
    ('Prusa Research','40145156000145', 'https://www.prusa3d.com', 'Raquel Vasconcelos', '5511999990016', 'contato@prusa.com'),
    ('Creality Store','50156167000156', 'https://www.creality.com', 'Henrique Lopes', '5511999990017', 'contato@creality.com'),
    ('MakerBot Brasil','60167178000167', 'https://www.makerbot.com', 'Gabriela Santos', '5511999990018', 'contato@makerbot.com')
) AS fornecedores(nm_fornecedor,cd_cnpj_fornecedor, cd_url_site_fornecedor, nm_contato_fornecedor, cd_telefone_contato_fornecedor, cd_email_contato_fornecedor)
WHERE NOT EXISTS (
    SELECT 1 FROM aluguel_impressora.dbo.fornecedor f
    WHERE f.nm_fornecedor = fornecedores.nm_fornecedor
);