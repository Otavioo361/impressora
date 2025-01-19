IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = 'uf')
BEGIN
  CREATE TABLE aluguel_impressora.dbo.uf (
    id_uf INT NOT NULL IDENTITY(1,1),
    cd_uf VARCHAR(2) NOT NULL,
    nm_estado VARCHAR(64) NOT NULL,
    dt_inclusao DATETIME NOT NULL DEFAULT GETDATE(),
    dt_alteracao DATETIME NULL,
    nm_usuario VARCHAR(60) NULL,
    CONSTRAINT PK_uf PRIMARY KEY (id_uf),
    CONSTRAINT UK01_uf UNIQUE(cd_uf)
  );
END;