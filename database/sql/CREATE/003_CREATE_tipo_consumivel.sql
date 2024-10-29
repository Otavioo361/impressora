IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = 'tipo_consumivel')
BEGIN
  CREATE TABLE alugel_impressora.dbo.tipo_consumivel (
    id_tipo_consumivel INT NOT NULL IDENTITY(1,1),
    cd_tipo_consumivel INT NOT NULL UNIQUE,
    nm_tipo_consumivel VARCHAR(30) NOT NULL,
    dt_inclusao DATETIME NOT NULL DEFAULT GETDATE(),
    dt_alteracao DATETIME NULL,
    nm_usuario VARCHAR(60) NULL,
    in_tipo_consumivel_ativo BIT NOT NULL,
    dt_desativacao DATETIME NOT NULL,
    CONSTRAINT PK_tipo_consumivel PRIMARY KEY (id_tipo_consumivel)
  );
END;