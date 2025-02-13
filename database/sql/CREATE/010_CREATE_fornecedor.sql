IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = 'fornecedor')
BEGIN
  CREATE TABLE aluguel_impressora.dbo.fornecedor (
    id_fornecedor BIGINT NOT NULL IDENTITY(1,1),
    id_tipo_fornecedor INT NOT NULL,
    nm_fornecedor VARCHAR(120) NOT NULL,
    cd_url_site_fornecedor VARCHAR(260) NULL,
    nm_contato_fornecedor VARCHAR(60) NULL,
    cd_telefone_contato_fornecedor VARCHAR(20) NULL,
    cd_email_contato_fornecedor VARCHAR(60) NULL,
    dt_inicio_contrato DATETIME NULL,
    dt_inclusao DATETIME2(0) NOT NULL DEFAULT GETDATE(),
    dt_alteracao DATETIME NULL,
    nm_usuario VARCHAR(60) NULL,
    in_fornecedor_disponivel BIT NULL,
    dt_fim_contrato DATETIME NULL,
    CONSTRAINT PK_fornecedor PRIMARY KEY (id_fornecedor),
    CONSTRAINT FK01_fornecedor_X_tipo_fornecedor FOREIGN KEY (id_tipo_fornecedor) REFERENCES aluguel_impressora.dbo.tipo_fornecedor(id_tipo_fornecedor)
  );
END;