IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = 'usuario_grupo_acesso')
BEGIN
  CREATE TABLE alugel_impressora.dbo.usuario_grupo_acesso (
    id_usuario BIGINT NOT NULL,
    id_grupo_acesso BIGINT NOT NULL,
    dt_inclusao DATETIME NOT NULL DEFAULT GETDATE(),
    dt_alteracao DATETIME NULL,
    nm_usuario VARCHAR(60) NULL,
    CONSTRAINT PK_usuario_grupo_acesso PRIMARY KEY (id_usuario,id_grupo_acesso),
    CONSTRAINT FK01_usuario_grupo_acesso_X_usuario FOREIGN KEY (id_usuario) REFERENCES alugel_impressora.dbo.usuario(id_usuario),
    CONSTRAINT FK01_usuario_grupo_acesso_X_grupo_acesso FOREIGN KEY (id_grupo_acesso) REFERENCES alugel_impressora.dbo.grupo_acesso(id_grupo_acesso)
  );
END;