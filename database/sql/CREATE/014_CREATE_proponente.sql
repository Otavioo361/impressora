IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = 'proponente')
BEGIN
  CREATE TABLE alugel_impressora.dbo.proponente (
    id_proponente INT NOT NULL IDENTITY(1,1),
    id_tipo_proponente INT NOT NULL,
    cd_cpf_cpnpj VARCHAR(14) NOT NULL,
    nm_proponente VARCHAR(30) NOT NULL,
    cd_email VARCHAR(120) NULL,
    nr_ddd INT NULL,
    nr_telefone INT NULL,
    dt_inclusao DATETIME NOT NULL DEFAULT GETDATE(),
    dt_alteracao DATETIME NULL,
    nm_usuario VARCHAR(60) NULL,
    CONSTRAINT PK_proponente PRIMARY KEY (id_proponente),
    CONSTRAINT FK01_proponente_X_tipo_proponente FOREIGN KEY (id_tipo_proponente) REFERENCES alugel_impressora.dbo.tipo_proponente(id_tipo_proponente)
  );
END;