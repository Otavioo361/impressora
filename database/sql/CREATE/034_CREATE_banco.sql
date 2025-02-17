IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = 'banco')
BEGIN
  CREATE TABLE aluguel_impressora.dbo.banco (
    id_banco BIGINT NOT NULL IDENTITY(1,1),
    cd_banco INT NOT NULL,
    nm_banco VARCHAR(64) NOT NULL,
    in_banco_ativo BIT NOT NULL,
    dt_inclusao DATETIME2(0) NOT NULL DEFAULT GETDATE(),
    dt_alteracao DATETIME NULL,
    nm_usuario VARCHAR(60) NULL,
    CONSTRAINT PK_banco PRIMARY KEY (id_banco),
    CONSTRAINT UK01_cd_banco UNIQUE(cd_banco)
  );
END;
