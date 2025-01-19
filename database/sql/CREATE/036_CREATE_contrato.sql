IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = 'contrato')
BEGIN
  CREATE TABLE aluguel_impressora.dbo.contrato (
    id_contrato BIGINT NOT NULL IDENTITY(1,1),
    nr_contrato BIGINT NOT NULL,
    nr_versao_contrato INT NOT NULL,
    id_cliente BIGINT NOT NULL,
    
    dt_inclusao DATETIME NOT NULL DEFAULT GETDATE(),
    dt_alteracao DATETIME NULL,
    nm_usuario VARCHAR(60) NULL,
    CONSTRAINT PK_contrato PRIMARY KEY (id_contrato),
    CONSTRAINT UI1_contrato_nr_contrato_E_nr_versao UNIQUE(nr_contrato, nr_versao_contrato),
    CONSTRAINT FK01_contrato_X_cliente FOREIGN KEY (id_cliente) REFERENCES aluguel_impressora.dbo.cliente(id_cliente)
  );
END;
CREATE INDEX IX2_CONTRATO_NR_CONTRATO ON aluguel_impressora.dbo.contrato (nr_contrato)