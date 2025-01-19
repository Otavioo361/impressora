IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = 'cliente')
BEGIN
  CREATE TABLE alugel_impressora.dbo.cliente (
    id_cliente BIGINT NOT NULL IDENTITY(1,1),
    id_pessoa BIGINT NOT NULL,
    id_endereco BIGINT NULL,
    id_tipo_cliente INT NOT NULL,
    dt_inclusao DATETIME NOT NULL DEFAULT GETDATE(),
    dt_alteracao DATETIME NULL,
    nm_usuario VARCHAR(60) NULL,
    CONSTRAINT PK_cliente PRIMARY KEY (id_cliente),
    CONSTRAINT FK01_cliente_X_tipo_cliente FOREIGN KEY (id_tipo_cliente) REFERENCES alugel_impressora.dbo.tipo_cliente(id_tipo_cliente),
    CONSTRAINT FK02_cliente_X_pessoa FOREIGN KEY (id_pessoa) REFERENCES alugel_impressora.dbo.pessoa(id_pessoa),
    CONSTRAINT FK02_cliente_X_endereco FOREIGN KEY (id_endereco) REFERENCES alugel_impressora.dbo.endereco(id_endereco)
  );
END;