IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = 'tipo_fornecedor')
BEGIN
  CREATE TABLE aluguel_impressora.dbo.tipo_fornecedor (
    id_tipo_fornecedor INT NOT NULL IDENTITY(1,1),
    cd_tipo_fornecedor INT NOT NULL UNIQUE,
    nm_tipo_fornecedor VARCHAR(30) NOT NULL,
    dt_inclusao DATETIME2(0) NOT NULL DEFAULT GETDATE(),
    dt_alteracao DATETIME NULL,
    nm_usuario VARCHAR(60) NULL,
    in_tipo_fornecedor_ativo BIT NOT NULL,
    CONSTRAINT PK_tipo_fornecedor PRIMARY KEY (id_tipo_fornecedor),
    CONSTRAINT UK01_tipo_fornecedor UNIQUE(cd_tipo_fornecedor)
  );
END;



