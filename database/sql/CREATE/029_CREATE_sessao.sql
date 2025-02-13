
IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = 'sessao')
BEGIN
    CREATE TABLE aluguel_impressora.dbo.sessao (
        id_sessao BIGINT NOT NULL IDENTITY(1,1),
        
        dt_inclusao DATETIME2(0) NOT NULL DEFAULT GETDATE(),
        dt_alteracao DATETIME NULL,
        nm_usuario VARCHAR(60) NULL,
        CONSTRAINT PK_sessao PRIMARY KEY (id_sessao)
    );
END;
