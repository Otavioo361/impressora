IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = 'impressora')
BEGIN
  CREATE TABLE alugel_impressora.dbo.impressora (
    id_impressora BIGINT NOT NULL IDENTITY(1,1),
    id_tipo_impressora INT NOT NULL,
    id_fornecedor_impressora BIGINT NOT NULL,
    cd_serie_impressora VARCHAR(20) NOT NULL,
    cd_barras_impressora VARCHAR(9) NOT NULL,
    dt_inclusao DATETIME NOT NULL DEFAULT GETDATE(),
    dt_alteracao DATETIME NULL,
    nm_usuario VARCHAR(60) NULL,
    dt_ultima_locacao DATETIME NULL,
    in_impressora_alugada BIT NULL,
    in_impressora_disponivel BIT NULL,
    CONSTRAINT PK_impressora PRIMARY KEY (id_impressora),
    CONSTRAINT FK01_impressora_X_tipo_impressora FOREIGN KEY (id_tipo_impressora) REFERENCES alugel_impressora.dbo.tipo_impressora(id_tipo_impressora),
    CONSTRAINT FK02_impressora_X_fornecedor FOREIGN KEY (id_fornecedor_impressora) REFERENCES alugel_impressora.dbo.fornecedor(id_fornecedor)
  );
END;