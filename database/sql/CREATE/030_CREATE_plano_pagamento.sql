IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = 'plano_pagamento')
BEGIN
  CREATE TABLE aluguel_impressora.dbo.plano_pagamento (
    id_plano_pagamento BIGINT NOT NULL IDENTITY(1,1),
    id_forma_pagamento INT NOT NULL,
    cd_plano_pagamento BIGINT NOT NULL,
    nm_plano_pagamento VARCHAR(32),
    qt_min_parcelas TINYINT NOT NULL,
    qt_max_parcelas TINYINT NOT NULL,
    in_a_vista BIT NOT NULL,
    in_cobranca_recorrente BIT NOT NULL,
    in_cobranca_primeira_ato BIT NOT NULL,
    dt_inclusao DATETIME NOT NULL DEFAULT GETDATE(),
    dt_alteracao DATETIME NULL,
    nm_usuario VARCHAR(60) NULL,
    CONSTRAINT PK_plano_pagamento PRIMARY KEY (id_plano_pagamento),
    CONSTRAINT UI1_cd_plano_pagamento UNIQUE(cd_plano_pagamento)
  );
END;
