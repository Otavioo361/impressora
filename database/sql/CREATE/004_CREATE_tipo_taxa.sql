IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = 'tipo_taxa')
BEGIN
  CREATE TABLE alugel_impressora.dbo.tipo_taxa (
    id_tipo_taxa INT NOT NULL IDENTITY(1,1),
    cd_tipo_taxa INT NOT NULL UNIQUE,
    nm_tipo_taxa VARCHAR(30) NOT NULL,
    dt_inclusao DATETIME NOT NULL DEFAULT GETDATE(),
    dt_alteracao DATETIME NULL,
    nm_usuario VARCHAR(60) NULL,
    in_tipo_taxa_ativo BIT NOT NULL,
    CONSTRAINT PK_tipo_taxa PRIMARY KEY (id_tipo_taxa),
    CONSTRAINT UK01_tipo_taxa UNIQUE(cd_tipo_taxa)
  );
END;