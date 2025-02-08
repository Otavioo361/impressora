IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = 'login')
BEGIN
  CREATE TABLE aluguel_impressora.dbo.login (
    id_login BIGINT NOT NULL,
    id_usuario BIGINT NOT NULL,
    nm_username VARCHAR(30) NULL,
    cd_email VARCHAR(60) NOT NULL,
    cd_cpf_cnpj VARCHAR(14) NOT NULL,
    hash_password VARCHAR(64),
    in_login_ativo BIT NOT NULL,
    dt_inclusao DATETIME NOT NULL DEFAULT GETDATE(),
    dt_alteracao DATETIME NULL,
    CONSTRAINT PK_login PRIMARY KEY (id_login),
    CONSTRAINT FK01_login_X_usuario FOREIGN KEY (id_usuario) REFERENCES aluguel_impressora.dbo.usuario(id_usuario)
  );
END;

CREATE UNIQUE INDEX IX1_USUARIO_NM_USERNAME ON aluguel_impressora.dbo.login (nm_username);
CREATE UNIQUE INDEX IX2_USUARIO_CD_EMAIL ON aluguel_impressora.dbo.login (cd_email);
CREATE UNIQUE INDEX IX3_USUARIO_CD_CPF_CNPJ ON aluguel_impressora.dbo.login (cd_cpf_cnpj);
