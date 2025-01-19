IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = 'dado_cobranca')
BEGIN
  CREATE TABLE alugel_impressora.dbo.dado_cobranca (
    id_dado_cobranca BIGINT NOT NULL IDENTITY(1,1),
    id_cliente BIGINT NOT NULL,
    id_forma_pagamento INT NOT NULL,
    id_cartao BIGINT NULL,
    id_conta_bancaria BIGINT NULL,
    id_boleto BIGINT NULL,
    id_dado_cobranca_alternativo BIGINT NULL,
    in_dado_cobranca_ativo BIT NOT NULL,
    dt_inclusao DATETIME NOT NULL DEFAULT GETDATE(),
    dt_alteracao DATETIME NULL,
    nm_usuario VARCHAR(60) NULL,
    CONSTRAINT PK_dado_cobranca PRIMARY KEY (id_dado_cobranca),
    CONSTRAINT FK01_dado_cobranca_X_cliente FOREIGN KEY (id_cliente) REFERENCES alugel_impressora.dbo.cliente(id_cliente),
    CONSTRAINT FK01_dado_cobranca_X_forma_pagamento FOREIGN KEY (id_forma_pagamento) REFERENCES alugel_impressora.dbo.forma_pagamento(id_forma_pagamento),
    CONSTRAINT FK01_dado_cobranca_X_cartao FOREIGN KEY (id_cartao) REFERENCES alugel_impressora.dbo.cartao(id_cartao),
    CONSTRAINT FK02_dado_cobranca_X_conta_bancaria FOREIGN KEY (id_conta_bancaria) REFERENCES alugel_impressora.dbo.conta_bancaria(id_conta_bancaria),
    CONSTRAINT FK03_dado_cobranca_X_boleto FOREIGN KEY (id_boleto) REFERENCES alugel_impressora.dbo.boleto(id_boleto),
    CONSTRAINT FK04_dado_cobranca_X_dado_cobranca FOREIGN KEY (id_dado_cobranca) REFERENCES alugel_impressora.dbo.dado_cobranca(d_dado_cobranca_alternativo)
  );
END;
