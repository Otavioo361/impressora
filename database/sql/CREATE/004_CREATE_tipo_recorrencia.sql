IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = 'tipo_recorrencia')
BEGIN
  CREATE TABLE aluguel_impressora.dbo.tipo_recorrencia (
    id_tipo_recorrencia INT NOT NULL IDENTITY(1,1),
    cd_tipo_recorrencia INT NOT NULL UNIQUE,
    nm_tipo_recorrencia VARCHAR(64) NOT NULL,
    ds_tipo_recorrencia VARCHAR(64) NULL,
    qt_dias_recorrencia INT NULL,
    dt_inclusao DATETIME2(0) NOT NULL DEFAULT GETDATE(),
    dt_alteracao DATETIME NULL,
    nm_usuario VARCHAR(60) NULL,
    in_tipo_recorrencia_ativo BIT NOT NULL,
    CONSTRAINT PK_tipo_recorrencia PRIMARY KEY (id_tipo_recorrencia),
    CONSTRAINT UK01_tipo_recorrencia UNIQUE(cd_tipo_recorrencia)
  );
END;