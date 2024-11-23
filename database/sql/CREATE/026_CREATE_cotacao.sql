IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = 'cotacao')
BEGIN
  CREATE TABLE alugel_impressora.dbo.cotacao (
    id_cotacao BIGINT NOT NULL IDENTITY(1,1),
    nr_cotacao BIGINT NOT NULL,
    nr_versao_cotacao INT NOT NULL,
    id_cliente BIGINT NOT NULL,
    
    dt_inclusao DATETIME NOT NULL DEFAULT GETDATE(),
    dt_alteracao DATETIME NULL,
    nm_usuario VARCHAR(60) NULL,
    CONSTRAINT PK_cotacao PRIMARY KEY (id_cotacao),
    CONSTRAINT UI1_cotacao_nr_cotacao_E_nr_versao UNIQUE(nr_cotacao, nr_versao_cotacao),
    CONSTRAINT FK01_cotacao_X_cliente FOREIGN KEY (id_cliente) REFERENCES alugel_impressora.dbo.cliente(id_cliente)
  );
END;
CREATE INDEX IX2_COTACAO_NR_COTACAO ON alugel_impressora.dbo.cotacao (nr_cotacao)