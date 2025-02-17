IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = 'pesquisa_satisfacao')
BEGIN
  CREATE TABLE aluguel_impressora.dbo.pesquisa_satisfacao (
    id_pesquisa_satisfacao  BIGINT NOT NULL IDENTITY(1,1),
    id_cliente BIGINT NOT NULL,
    qt_pontos_avaliados TINYINT NOT NULL,
    tx_descricao_avalicao VARCHAR(400),
    dt_inclusao DATETIME2(0) NOT NULL DEFAULT GETDATE(),
    nm_usuario VARCHAR(60) NULL,
    CONSTRAINT PK_pesquisa_satisfacao PRIMARY KEY (id_pesquisa_satisfacao),
    CONSTRAINT FK01_pesquisa_satisfacao_X_cliente FOREIGN KEY (id_cliente) REFERENCES aluguel_impressora.dbo.cliente(id_cliente)
  );
END;
