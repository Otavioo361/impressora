IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = 'taxa')
BEGIN
  CREATE TABLE aluguel_impressora.dbo.taxa (
    id_taxa BIGINT NOT NULL IDENTITY(1,1),
    id_tipo_taxa INT NOT NULL,
    vl_taxa DECIMAL(10,2) NOT NULL,
    dt_inclusao DATETIME2(0) NOT NULL DEFAULT GETDATE(),
    dt_alteracao DATETIME NULL,
    nm_usuario VARCHAR(60) NULL,
    in_taxa_ativo BIT NOT NULL,
    CONSTRAINT PK_taxa PRIMARY KEY (id_taxa),
    CONSTRAINT FK01_taxa_X_tipo_taxa FOREIGN KEY (id_tipo_taxa) REFERENCES aluguel_impressora.dbo.tipo_taxa(id_tipo_taxa)
  );
END;