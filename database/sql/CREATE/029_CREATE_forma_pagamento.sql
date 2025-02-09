IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = 'forma_pagamento')
BEGIN
  CREATE TABLE aluguel_impressora.dbo.forma_pagamento (
    id_forma_pagamento INT NOT NULL IDENTITY(1,1),
    cd_forma_pagamento INT NOT NULL UNIQUE,
    nm_forma_pagamento VARCHAR(30) NOT NULL,
    dt_inclusao DATETIME NOT NULL DEFAULT GETDATE(),
    dt_alteracao DATETIME NULL,
    nm_usuario VARCHAR(60) NULL,
    in_forma_pagamento_ativo BIT NOT NULL,
    CONSTRAINT PK_forma_pagamento PRIMARY KEY (id_forma_pagamento),
    CONSTRAINT UK01_forma_pagamento UNIQUE(cd_forma_pagamento)
  );
END;