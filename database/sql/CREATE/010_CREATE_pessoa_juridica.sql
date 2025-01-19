IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = 'pessoa_juridica')
BEGIN
  CREATE TABLE aluguel_impressora.dbo.pessoa_juridica (
    id_pessoa_juridica BIGINT NOT NULL IDENTITY(1,1),
    nm_razao_social VARCHAR(60),
    dt_abertura DATETIME,
    nm_natureza_jurica VARCHAR(120),
    dt_inclusao DATETIME NOT NULL DEFAULT GETDATE(),
    dt_alteracao DATETIME NULL,
    nm_usuario VARCHAR(60) NULL,
    CONSTRAINT PK_pessoa_juridica PRIMARY KEY (id_pessoa_juridica)
  );
END;