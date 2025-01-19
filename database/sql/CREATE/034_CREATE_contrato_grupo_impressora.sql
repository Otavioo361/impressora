IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = 'grupo_impressora')
BEGIN
  CREATE TABLE alugel_impressora.dbo.grupo_impressora (
    id_grupo_impressora BIGINT NOT NULL IDENTITY(1,1)
    id_contrato BIGINT NOT NULL,
    id_endereco BIGINT NOT NULL,
    nm_grupo_impressora VARCHAR(64),
    qt_impressora INT NULL,
    vl_aluguel_grupo_impressora DECIMAL(10,2),

    dt_inclusao DATETIME NOT NULL DEFAULT GETDATE(),
    dt_alteracao DATETIME NULL,
    nm_usuario VARCHAR(60) NULL,
    CONSTRAINT PK_grupo_impressora PRIMARY KEY (id_grupo_impressora),
    CONSTRAINT FK01_grupo_impressora_X_contrato FOREIGN KEY (id_contrato) REFERENCES alugel_impressora.dbo.contrato(id_contrato),
    CONSTRAINT FK01_grupo_impressora_X_endereco FOREIGN KEY (id_endereco) REFERENCES alugel_impressora.dbo.endereco(id_endereco)
  );
END;
