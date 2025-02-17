IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = 'modelo_impressora')
BEGIN
  CREATE TABLE aluguel_impressora.dbo.modelo_impressora (
    id_modelo_impressora BIGINT NOT NULL IDENTITY(1,1),
    id_marca_impressora INT NOT NULL,
    id_tipo_impressora INT NOT NULL,
    id_taxa BIGINT NOT NULL,
    nm_modelo_impressora VARCHAR(64) NOT NULL,
    qt_impressora INT NULL,
    qt_impressora_disponivel INT NULL,
    qt_impressora_alugada INT NULL,
    dt_inclusao DATETIME2(0) NOT NULL DEFAULT GETDATE(),
    dt_alteracao DATETIME2 NULL,
    nm_usuario VARCHAR(60) NULL,
    in_modelo_impressora_ativo BIT NOT NULL,
    CONSTRAINT PK_modelo_impressora PRIMARY KEY (id_modelo_impressora),
    CONSTRAINT FK01_modelo_impressora_X_marca FOREIGN KEY (id_marca_impressora) REFERENCES aluguel_impressora.dbo.marca(id_marca),
    CONSTRAINT FK02_modelo_impressora_X_tipo_impressora FOREIGN KEY (id_tipo_impressora) REFERENCES aluguel_impressora.dbo.tipo_impressora(id_tipo_impressora),
    CONSTRAINT FK02_modelo_impressora_X_taxa FOREIGN KEY (id_taxa) REFERENCES aluguel_impressora.dbo.taxa(id_taxa)
);
END;