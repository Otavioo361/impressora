IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = 'boleto')
BEGIN
  CREATE TABLE aluguel_impressora.dbo.boleto (
    id_boleto BIGINT NOT NULL IDENTITY(1,1),
    cd_boleto VARCHAR(128),
    in_boleto_ativo BIT NOT NULL,
    dt_inclusao DATETIME2(0) NOT NULL DEFAULT GETDATE(),
    dt_alteracao DATETIME NULL,
    nm_usuario VARCHAR(60) NULL,
    CONSTRAINT PK_boleto PRIMARY KEY (id_boleto)
  );
END;
