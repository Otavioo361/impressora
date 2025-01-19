IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = 'consumivel_taxa')
BEGIN
  CREATE TABLE alugel_impressora.dbo.consumivel_taxa (
    id_consumivel BIGINT NOT NULL,
    id_taxa BIGINT NOT NULL,
    qmn_consumivel INT NOT NULL,
    qmx_consumivel INT NOT NULL,
    dt_inclusao DATETIME NOT NULL DEFAULT GETDATE(),
    dt_alteracao DATETIME NULL,
    nm_usuario VARCHAR(60) NULL,
    CONSTRAINT PK_consumivel_taxa PRIMARY KEY (id_consumivel, id_taxa),
    CONSTRAINT FK01_consumivel_taxa_X_impressora FOREIGN KEY (id_consumivel) REFERENCES alugel_impressora.dbo.consumivel(id_consumivel),
    CONSTRAINT FK02_consumivel_taxa_X_consumivel FOREIGN KEY (id_taxa) REFERENCES alugel_impressora.dbo.taxa(id_taxa)
  );
END;