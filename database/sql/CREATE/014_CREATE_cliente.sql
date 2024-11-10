IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = 'cliente')
BEGIN
  CREATE TABLE alugel_impressora.dbo.cliente (
    id_cliente INT NOT NULL IDENTITY(1,1),
    id_tipo_cliente INT NOT NULL,
    cd_cpf_cpnpj VARCHAR(14) NOT NULL,
    nm_cliente VARCHAR(30) NOT NULL,
    cd_email VARCHAR(120) NULL,
    nr_ddd INT NULL,
    nr_telefone INT NULL,
    dt_inclusao DATETIME NOT NULL DEFAULT GETDATE(),
    dt_alteracao DATETIME NULL,
    nm_usuario VARCHAR(60) NULL,
    CONSTRAINT PK_cliente PRIMARY KEY (id_cliente),
    CONSTRAINT FK01_cliente_X_tipo_cliente FOREIGN KEY (id_tipo_cliente) REFERENCES alugel_impressora.dbo.tipo_cliente(id_tipo_cliente)
  );
END;