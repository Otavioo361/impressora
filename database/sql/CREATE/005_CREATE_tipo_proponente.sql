IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = 'tipo_proponente')
BEGIN
  CREATE TABLE alugel_impressora.dbo.tipo_proponente (
    id_tipo_proponente INT NOT NULL IDENTITY(1,1),
    cd_tipo_proponente INT NOT NULL UNIQUE,
    nm_tipo_proponente VARCHAR(30) NOT NULL,
    dt_inclusao DATETIME NOT NULL DEFAULT GETDATE(),
    dt_alteracao DATETIME NULL,
    nm_usuario VARCHAR(60) NULL,
    in_tipo_proponente_ativo BIT NOT NULL,
    CONSTRAINT PK_tipo_proponente PRIMARY KEY (id_tipo_proponente)
  );
END;