IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = 'consumivel')
BEGIN
  CREATE TABLE alugel_impressora.dbo.consumivel (
    id_consumivel INT NOT NULL IDENTITY(1,1),
    id_fornecedor_consumivel INT NOT NULL,
    cd_consumivel INT NOT NULL,
    nm_consumivel VARCHAR(30) NOT NULL,
    dt_inclusao DATETIME NOT NULL DEFAULT GETDATE(),
    dt_alteracao DATETIME NULL,
    nm_usuario VARCHAR(60) NULL,
    in_consumivel_ativo BIT NOT NULL,
    CONSTRAINT PK_consumivel PRIMARY KEY (id_consumivel),
    CONSTRAINT FK01_consumivel_X_tipo_consumivel FOREIGN KEY (id_consumivel) REFERENCES alugel_impressora.dbo.tipo_consumivel(id_tipo_consumivel) 
  );
END;