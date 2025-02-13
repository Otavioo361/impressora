IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = 'modelo_consumivel')
BEGIN
  CREATE TABLE aluguel_impressora.dbo.modelo_consumivel (
    id_modelo_consumivel BIGINT NOT NULL IDENTITY(1,1),
    id_marca_consumivel INT NOT NULL,
    id_tipo_consumivel INT NOT NULL,
    id_taxa BIGINT NOT NULL,
    nm_modelo_consumivel VARCHAR(64) NOT NULL,
    qt_consumivel INT NULL,
    qt_consumivel_disponivel INT NULL,
    qt_consumivel_alugada INT NULL,
    dt_inclusao DATETIME2(0) NOT NULL DEFAULT GETDATE(),
    dt_alteracao DATETIME2 NULL,
    nm_usuario VARCHAR(60) NULL,
    in_modelo_consumivel_ativo BIT NOT NULL,
    CONSTRAINT PK_modelo_consumivel PRIMARY KEY (id_modelo_consumivel),
    CONSTRAINT FK01_modelo_consumivel_X_marca FOREIGN KEY (id_marca_consumivel) REFERENCES aluguel_impressora.dbo.marca(id_marca),
    CONSTRAINT FK02_modelo_consumivel_X_tipo_consumivel FOREIGN KEY (id_tipo_consumivel) REFERENCES aluguel_impressora.dbo.tipo_consumivel(id_tipo_consumivel),
    CONSTRAINT FK02_modelo_consumivel_X_taxa FOREIGN KEY (id_taxa) REFERENCES aluguel_impressora.dbo.taxa(id_taxa)
);
END;