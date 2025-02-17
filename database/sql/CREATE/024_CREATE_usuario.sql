IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = 'usuario')
BEGIN
  CREATE TABLE aluguel_impressora.dbo.usuario (
    id_usuario BIGINT NOT NULL IDENTITY(1,1),
    id_pessoa BIGINT NOT NULL,
    nm_usuario VARCHAR(30) NOT NULL UNIQUE,
    dt_inclusao DATETIME2(0) NOT NULL DEFAULT GETDATE(),
    dt_alteracao DATETIME NULL,
    in_usuario_ativo BIT NOT NULL,
    CONSTRAINT PK_usuario PRIMARY KEY (id_usuario),
    CONSTRAINT FK01_usuario_X_pessoa FOREIGN KEY (id_pessoa) REFERENCES aluguel_impressora.dbo.pessoa(id_pessoa)
  );
END;

--- CREATE SEARCH INDEX

CREATE INDEX IX2_USUARIO_NM_USUARIO ON aluguel_impressora.dbo.usuario (nm_usuario)
