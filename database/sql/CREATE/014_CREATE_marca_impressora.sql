IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = 'marca_impressora')
BEGIN
  CREATE TABLE aluguel_impressora.dbo.marca_impressora (
    id_marca_impressora INT NOT NULL IDENTITY(1,1),
    nm_marca_impressora VARCHAR(30) NOT NULL,
    dt_inclusao DATETIME2(0) NOT NULL DEFAULT GETDATE(),
    dt_alteracao DATETIME NULL,
    nm_usuario VARCHAR(60) NULL,
    in_marca_impressora_ativo BIT NOT NULL,
    CONSTRAINT PK_marca_impressora PRIMARY KEY (id_marca_impressora)
  );
END;