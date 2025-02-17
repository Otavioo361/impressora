IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = 'marca')
BEGIN
  CREATE TABLE aluguel_impressora.dbo.marca (
    id_marca INT NOT NULL IDENTITY(1,1),
    nm_marca VARCHAR(30) NOT NULL,
    dt_inclusao DATETIME2(0) NOT NULL DEFAULT GETDATE(),
    dt_alteracao DATETIME NULL,
    nm_usuario VARCHAR(60) NULL,
    in_marca_ativo BIT NOT NULL,
    CONSTRAINT PK_marca PRIMARY KEY (id_marca)
  );
END;