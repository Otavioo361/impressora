IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = 'atentendente')
BEGIN
  CREATE TABLE aluguel_impressora.dbo.atentendente (
    id_atentendente BIGINT NOT NULL IDENTITY(1,1),
    id_usuario BIGINT NOT NULL,
    nm_atentendente VARCHAR(30) NOT NULL,
    dt_inclusao DATETIME NOT NULL DEFAULT GETDATE(),
    dt_alteracao DATETIME NULL,
    nm_usuario VARCHAR(60) NULL,
    CONSTRAINT PK_atentendente PRIMARY KEY (id_atentendente),
    CONSTRAINT FK01_atentendente_X_usuario FOREIGN KEY (id_usuario) REFERENCES aluguel_impressora.dbo.usuario(id_usuario)
  );
END;