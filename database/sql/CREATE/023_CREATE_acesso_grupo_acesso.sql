
IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = 'acesso_grupo_acesso')
BEGIN
    CREATE TABLE aluguel_impressora.dbo.acesso_grupo_acesso (
        id_acesso_grupo_acesso BIGINT NOT NULL IDENTITY(1,1),
        id_grupo_acesso BIGINT NOT NULL,
        id_acesso BIGINT NOT NULL,
        dt_inclusao DATETIME2(0) NOT NULL DEFAULT GETDATE(),
        dt_alteracao DATETIME NULL,
        nm_usuario VARCHAR(60) NULL,
        CONSTRAINT PK_acesso_grupo_acesso PRIMARY KEY (id_acesso_grupo_acesso),
        CONSTRAINT FK01_acesso_grupo_acesso_X_acesso FOREIGN KEY (id_acesso) REFERENCES aluguel_impressora.dbo.acesso(id_acesso),
        CONSTRAINT FK02_acesso_grupo_acesso_X_grupo_acesso FOREIGN KEY (id_grupo_acesso) REFERENCES aluguel_impressora.dbo.grupo_acesso(id_grupo_acesso),
    );
END;
