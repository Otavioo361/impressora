IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = 'pessoa_fisica')
BEGIN
  CREATE TABLE aluguel_impressora.dbo.pessoa_fisica (
    id_pessoa_fisica BIGINT NOT NULL IDENTITY(1,1),
    dt_nascimento DATE,
    in_ppe BIT NULL,
    dt_inclusao DATETIME2(0) NOT NULL DEFAULT GETDATE(),
    dt_alteracao DATETIME NULL,
    nm_usuario VARCHAR(60) NULL,
    CONSTRAINT PK_pessoa_fisica PRIMARY KEY (id_pessoa_fisica)
  );
END;