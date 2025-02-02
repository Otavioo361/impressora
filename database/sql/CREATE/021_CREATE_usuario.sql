IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = 'usuario')
BEGIN
  CREATE TABLE alugel_impressora.dbo.usuario (
    id_usuario BIGINT NOT NULL IDENTITY(1,1),
    id_pessoa BIGINT NOT NULL,
    dt_inclusao DATETIME NOT NULL DEFAULT GETDATE(),
    dt_alteracao DATETIME NULL,
    in_usuario_ativo BIT NOT NULL,
    CONSTRAINT PK_usuario PRIMARY KEY (id_usuario),
    CONSTRAINT FK01_usuario_X_pessoa FOREIGN KEY (id_pessoa) REFERENCES alugel_impressora.dbo.pessoa(id_pessoa)
  );
END;

--- CREATE SEARCH INDEX

CREATE INDEX IX2_USUARIO_NM_USUARIO ON alugel_impressora.dbo.usuario (nm_usuario)
