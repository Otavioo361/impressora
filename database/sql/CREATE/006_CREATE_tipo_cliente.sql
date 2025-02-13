IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = 'tipo_cliente')
BEGIN
  CREATE TABLE aluguel_impressora.dbo.tipo_cliente (
    id_tipo_cliente INT NOT NULL IDENTITY(1,1),
    cd_tipo_cliente INT NOT NULL UNIQUE,
    nm_tipo_cliente VARCHAR(30) NOT NULL,
    dt_inclusao DATETIME2(0) NOT NULL DEFAULT GETDATE(),
    dt_alteracao DATETIME NULL,
    nm_usuario VARCHAR(60) NULL,
    in_tipo_cliente_ativo BIT NOT NULL,
    CONSTRAINT PK_tipo_cliente PRIMARY KEY (id_tipo_cliente),
    CONSTRAINT UK01_tipo_cliente UNIQUE(cd_tipo_cliente)
  );
END;