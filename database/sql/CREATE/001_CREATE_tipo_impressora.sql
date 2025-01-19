IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = 'tipo_impressora')
BEGIN
  CREATE TABLE aluguel_impressora.dbo.tipo_impressora (
    id_tipo_impressora INT NOT NULL IDENTITY(1,1),
    cd_tipo_impressora INT NOT NULL,
    nm_tipo_impressora VARCHAR(30) NOT NULL,
    qt_impressora INT NULL,
    qt_impressora_disponivel INT NULL,
    qt_impressora_alugada INT NULL,
    dt_inclusao DATETIME NOT NULL DEFAULT GETDATE(),
    dt_alteracao DATETIME NULL,
    nm_usuario VARCHAR(60) NULL,
    in_tipo_impressora_ativo BIT NOT NULL,
    CONSTRAINT PK_tipo_impressora PRIMARY KEY (id_tipo_impressora),
    CONSTRAINT UK01_tipo_impressora UNIQUE(cd_tipo_impressora),
  );
END;