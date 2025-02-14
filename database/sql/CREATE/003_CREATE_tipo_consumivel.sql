IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = 'tipo_consumivel')
BEGIN
  CREATE TABLE aluguel_impressora.dbo.tipo_consumivel (
    id_tipo_consumivel INT NOT NULL IDENTITY(1,1),
    id_tipo_impressora INT NULL,
    cd_tipo_consumivel INT NOT NULL UNIQUE,
    nm_tipo_consumivel VARCHAR(30) NOT NULL,
    dt_inclusao DATETIME2(0) NOT NULL DEFAULT GETDATE(),
    dt_alteracao DATETIME2 NULL,
    nm_usuario VARCHAR(60) NULL,
    in_tipo_consumivel_ativo BIT NOT NULL,
    dt_desativacao DATETIME2 NULL,
    CONSTRAINT PK_tipo_consumivel PRIMARY KEY (id_tipo_consumivel),
    CONSTRAINT FK01_tipo_consumivel_X_tipo_impressora FOREIGN KEY (id_tipo_impressora) REFERENCES aluguel_impressora.dbo.tipo_impressora(id_tipo_impressora)
  );
END;