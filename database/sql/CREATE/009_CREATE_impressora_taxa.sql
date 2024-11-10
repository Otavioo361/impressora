IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = 'impressora_taxa')
BEGIN
  CREATE TABLE alugel_impressora.dbo.impressora_taxa (
    id_impressora BIGINT NOT NULL,
    id_taxa BIGINT NOT NULL,
    qmn_impressora INT NOT NULL,
    qmx_impressora INT NOT NULL,
    dt_inclusao DATETIME NOT NULL DEFAULT GETDATE(),
    dt_alteracao DATETIME NULL,
    nm_usuario VARCHAR(60) NULL,
    CONSTRAINT PK_impressora_taxa PRIMARY KEY (id_impressora, id_taxa),
    CONSTRAINT FK01_impressora_taxa_X_impressora FOREIGN KEY (id_impressora) REFERENCES alugel_impressora.dbo.impressora(id_impressora),
    CONSTRAINT FK02_impressora_taxa_X_consumivel FOREIGN KEY (id_taxa) REFERENCES alugel_impressora.dbo.taxa(id_taxa)
  );
END;