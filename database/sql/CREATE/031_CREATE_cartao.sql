IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = 'cartao')
BEGIN
  CREATE TABLE aluguel_impressora.dbo.cartao (
    id_cartao BIGINT NOT NULL IDENTITY(1,1),
    cd_token_cartao VARCHAR(64),
    cd_ultimos_digitos VARCHAR(4),
    dt_validade VARCHAR(7),
    in_cartao_ativo BIT NOT NULL,
    dt_inclusao DATETIME NOT NULL DEFAULT GETDATE(),
    dt_alteracao DATETIME NULL,
    nm_usuario VARCHAR(60) NULL,
    CONSTRAINT PK_cartao PRIMARY KEY (id_cartao)
  );
END;
