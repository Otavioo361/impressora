IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = 'grupo_acesso')
BEGIN
  CREATE TABLE aluguel_impressora.dbo.grupo_acesso (
    id_grupo_acesso BIGINT NOT NULL IDENTITY(1,1),
    cd_grupo_acesso VARCHAR(30) NOT NULL,
    nm_grupo_acesso VARCHAR(30) NOT NULL,
    dt_inclusao DATETIME NOT NULL DEFAULT GETDATE(),
    dt_alteracao DATETIME NULL,
    CONSTRAINT PK_grupo_acesso PRIMARY KEY (id_grupo_acesso),

  );
END;