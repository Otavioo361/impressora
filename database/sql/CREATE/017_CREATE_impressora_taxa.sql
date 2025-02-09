IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = 'impressora_taxa')
BEGIN
  CREATE TABLE aluguel_impressora.dbo.impressora_taxa (
    id_impressora_taxa BIGINT NOT NULL IDENTITY(1,1),
    id_impressora BIGINT NOT NULL,
    id_taxa BIGINT NOT NULL,
    qmn_impressora INT NOT NULL,
    qmx_impressora INT NOT NULL,
    dt_inclusao DATETIME2(0) NOT NULL DEFAULT GETDATE(),
    dt_alteracao DATETIME NULL,
    nm_usuario VARCHAR(60) NULL,
    CONSTRAINT PK_impressora_taxa PRIMARY KEY (id_impressora_taxa),
    CONSTRAINT FK01_impressora_taxa_X_impressora FOREIGN KEY (id_impressora) REFERENCES aluguel_impressora.dbo.impressora(id_impressora),
    CONSTRAINT FK02_impressora_taxa_X_consumivel FOREIGN KEY (id_taxa) REFERENCES aluguel_impressora.dbo.taxa(id_taxa)
  );
END;