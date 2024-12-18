IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = 'impressora_consumivel')
BEGIN
  CREATE TABLE alugel_impressora.dbo.impressora_consumivel (
    id_impressora BIGINT NOT NULL,
    id_consumivel BIGINT NOT NULL,
    dt_inclusao DATETIME NOT NULL DEFAULT GETDATE(),
    dt_alteracao DATETIME NULL,
    nm_usuario VARCHAR(60) NULL,
    CONSTRAINT PK_impressora_consumivel PRIMARY KEY (id_impressora, id_consumivel),
    CONSTRAINT FK01_impressora_consumivel_X_impressora FOREIGN KEY (id_impressora) REFERENCES alugel_impressora.dbo.impressora(id_impressora),
    CONSTRAINT FK02_impressora_consumivel_X_consumivel FOREIGN KEY (id_consumivel) REFERENCES alugel_impressora.dbo.consumivel(id_consumivel)
  );
END;