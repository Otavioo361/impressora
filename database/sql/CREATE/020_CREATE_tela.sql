IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = 'tela')
BEGIN
  CREATE TABLE aluguel_impressora.dbo.tela (
    id_tela BIGINT NOT NULL IDENTITY(1,1),
    cd_tela VARCHAR(30) NOT NULL,
    nm_tela VARCHAR(30) NOT NULL,
    dt_inclusao DATETIME2(0) NOT NULL DEFAULT GETDATE(),
    dt_alteracao DATETIME NULL,
    CONSTRAINT PK_tela PRIMARY KEY (id_tela),
  );
END;