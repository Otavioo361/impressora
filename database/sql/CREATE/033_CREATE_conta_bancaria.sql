IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = 'conta_bancaria')
BEGIN
  CREATE TABLE aluguel_impressora.dbo.conta_bancaria (
    id_conta_bancaria BIGINT NOT NULL IDENTITY(1,1),
    id_banco BIGINT NOT NULL,
    nr_agencia INT NOT NULL,
    cd_agencia_dv INT,
    nr_conta_bancaria INT NOT NULL,
    cd_conta_bancaria_dv INT NOT NULL,

    in_conta_bancaria_ativo BIT NOT NULL,
    dt_inclusao DATETIME NOT NULL DEFAULT GETDATE(),
    dt_alteracao DATETIME NULL,
    nm_usuario VARCHAR(60) NULL,
    CONSTRAINT PK_conta_bancaria PRIMARY KEY (id_conta_bancaria)
  );
END;
