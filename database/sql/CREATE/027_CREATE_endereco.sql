IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = 'endereco')
BEGIN
  CREATE TABLE aluguel_impressora.dbo.endereco (
    id_endereco BIGINT NOT NULL IDENTITY(1,1),
    id_cliente BIGINT NULL,
    id_uf INT NOT NULL,
    nr_logradouro INT,
    nm_endereco VARCHAR(60),
    nm_cidade VARCHAR(60),
    nm_logradouro VARCHAR(120),
    nm_bairro VARCHAR(30),
    nm_cep VARCHAR(11),
    nm_complemento VARCHAR(32),
    nm_referencia VARCHAR(32),
    dt_inclusao DATETIME2(0) NOT NULL DEFAULT GETDATE(),
    dt_alteracao DATETIME NULL,
    nm_usuario VARCHAR(60) NULL,
    
    CONSTRAINT PK_endereco PRIMARY KEY (id_endereco),
    CONSTRAINT FK01_endereco_x_uf FOREIGN KEY (id_uf) REFERENCES aluguel_impressora.dbo.uf(id_uf),
    CONSTRAINT FK02_endereco_x_cliente FOREIGN KEY (id_cliente) REFERENCES aluguel_impressora.dbo.cliente(id_cliente)
  );
END;