IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = 'impressora')
BEGIN
  CREATE TABLE aluguel_impressora.dbo.impressora (
    id_impressora BIGINT NOT NULL IDENTITY(1,1),
    id_fornecedor_impressora BIGINT NOT NULL,
    id_modelo_impressora BIGINT NOT NULL,
    cd_serie_impressora VARCHAR(20) NOT NULL,
    cd_barras_impressora VARCHAR(9) NOT NULL,
    dt_inclusao DATETIME2(0) NOT NULL DEFAULT GETDATE(),
    dt_alteracao DATETIME NULL,
    nm_usuario VARCHAR(60) NULL,
    dt_ultima_locacao DATETIME NULL,
    in_impressora_alugada BIT NULL,
    in_impressora_disponivel BIT NULL,
    CONSTRAINT PK_impressora PRIMARY KEY (id_impressora),
    CONSTRAINT FK01_impressora_X_fornecedor FOREIGN KEY (id_fornecedor_impressora) REFERENCES aluguel_impressora.dbo.fornecedor(id_fornecedor),
    CONSTRAINT FK02_impressora_X_modelo_impressora FOREIGN KEY (id_modelo_impressora) REFERENCES aluguel_impressora.dbo.modelo_impressora(id_modelo_impressora)
  );
END;