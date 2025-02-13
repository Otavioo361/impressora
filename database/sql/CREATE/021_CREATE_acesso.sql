IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = 'acesso')
BEGIN
  CREATE TABLE aluguel_impressora.dbo.acesso (
    id_acesso BIGINT NOT NULL IDENTITY(1,1),
    id_tela BIGINT NOT NULL,
    cd_acesso VARCHAR(30) NOT NULL,
    nm_acesso VARCHAR(30) NOT NULL,
    in_read BIT NOT NULL,
    in_create BIT NOT NULL,
    in_update BIT NOT NULL,
    in_delete BIT NOT NULL,
    dt_inclusao DATETIME2(0) NOT NULL DEFAULT GETDATE(),
    dt_alteracao DATETIME NULL,
    CONSTRAINT PK_acesso PRIMARY KEY (id_acesso),
    CONSTRAINT FK01_acesso_X_tela FOREIGN KEY (id_tela) REFERENCES aluguel_impressora.dbo.tela(id_tela)
  );
END;