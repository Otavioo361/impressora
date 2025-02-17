IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = 'consumivel')
BEGIN
  CREATE TABLE aluguel_impressora.dbo.consumivel (
    id_consumivel BIGINT NOT NULL IDENTITY(1,1),
    id_tipo_consumivel INT NOT NULL,
    id_fornecedor_consumivel BIGINT NOT NULL,
    id_modelo_consumivel BIGINT NOT NULL,
    id_impressora BIGINT NULL,
    cd_barras_consumivel VARCHAR(30) NOT NULL,
    nm_consumivel VARCHAR(30) NOT NULL,
    dt_consumido DATETIME2 NULL,
    in_em_consumo BIT NOT NULL,
    dt_validade_consumivel DATETIME2 NULL,
    dt_inclusao DATETIME2(0) NOT NULL DEFAULT GETDATE(),
    dt_alteracao DATETIME NULL,
    nm_usuario VARCHAR(60) NULL,
    in_consumivel_ativo BIT NOT NULL,
    CONSTRAINT PK_consumivel PRIMARY KEY (id_consumivel),
    CONSTRAINT FK01_consumivel_X_tipo_consumivel FOREIGN KEY (id_tipo_consumivel) REFERENCES aluguel_impressora.dbo.tipo_consumivel(id_tipo_consumivel),
    CONSTRAINT FK02_consumivel_X_fornecedor FOREIGN KEY (id_fornecedor_consumivel) REFERENCES aluguel_impressora.dbo.fornecedor(id_fornecedor),
    CONSTRAINT FK03_consumivel_X_modelo_consumivel FOREIGN KEY (id_modelo_consumivel) REFERENCES aluguel_impressora.dbo.modelo_consumivel(id_modelo_consumivel),
    CONSTRAINT FK04_consumivel_X_impressora FOREIGN KEY (id_impressora) REFERENCES aluguel_impressora.dbo.impressora(id_impressora)
  );
END;