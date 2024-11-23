IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = 'pessoa')
BEGIN
  CREATE TABLE alugel_impressora.dbo.pessoa (
    id_pessoa BIGINT NOT NULL IDENTITY(1,1),
    id_pessoa_fisica BIGINT NULL,
    id_pessoa_juridica BIGINT NULL,
    cd_cpf_cpnpj VARCHAR(14) NOT NULL,
    nm_pessoa VARCHAR(60),
    cd_email VARCHAR(120) NOT NULL,
    nr_ddd INT NULL,
    nr_telefone INT NULL,
    dt_inclusao DATETIME NOT NULL DEFAULT GETDATE(),
    dt_alteracao DATETIME NULL,
    nm_usuario VARCHAR(60) NULL,
    CONSTRAINT PK_pessoa PRIMARY KEY (id_pessoa),
    CONSTRAINT FK01_pessoa_X_pessoa_fisica FOREIGN KEY (id_pessoa_fisica) REFERENCES alugel_impressora.dbo.pessoa_fisica(id_pessoa_fisica),
    CONSTRAINT FK01_pessoa_X_pessoa_juridica FOREIGN KEY (id_pessoa_juridica) REFERENCES alugel_impressora.dbo.pessoa_juridica(id_pessoa_juridica),
    CONSTRAINT UK01_pessoa_nm_email UNIQUE(cd_email),
    CONSTRAINT UK01_pessoa_cd_cpf_cpnpj UNIQUE(cd_cpf_cpnpj)
  );
END;

CREATE NONCLUSTERED INDEX IX1_PESSOA_EMAIL ON alugel_impressora.dbo.pessoa (cd_email)
CREATE NONCLUSTERED INDEX IX2_PESSOA_CD_CPF_CPNPJ ON alugel_impressora.dbo.pessoa (cd_cpf_cpnpj)
CREATE INDEX IX3_PESSOA_NM_PESSOA ON alugel_impressora.dbo.pessoa (nm_pessoa)
