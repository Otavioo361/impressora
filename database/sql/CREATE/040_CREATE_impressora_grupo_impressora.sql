IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = 'impressora_grupo_impressora')
BEGIN
  CREATE TABLE aluguel_impressora.dbo.impressora_grupo_impressora (
    id_impressora_grupo_impressora  BIGINT NOT NULL IDENTITY(1,1),
    id_grupo_impressora BIGINT NOT NULL,
    id_impressora BIGINT NOT NULL,
    dt_inclusao DATETIME2(0) NOT NULL DEFAULT GETDATE(),
    dt_alteracao DATETIME NULL,
    nm_usuario VARCHAR(60) NULL,
    CONSTRAINT PK_impressora_grupo_impressora PRIMARY KEY (id_impressora_grupo_impressora),
    CONSTRAINT FK01_impressora_grupo_impressora_X_grupo_impressora FOREIGN KEY (id_grupo_impressora) REFERENCES aluguel_impressora.dbo.grupo_impressora(id_grupo_impressora),
    CONSTRAINT FK01_impressora_grupo_impressora_X_impressora FOREIGN KEY (id_impressora) REFERENCES aluguel_impressora.dbo.impressora(id_impressora)
  );
END;
