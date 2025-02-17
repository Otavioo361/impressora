INSERT INTO aluguel_impressora.dbo.acesso
(id_tela, cd_acesso, nm_acesso, in_read, in_create, in_update, in_delete)
VALUES
  ((SELECT TOP 1 id_tela FROM aluguel_impressora.dbo.tela WHERE cd_tela = 'CLIENTE'),'adm_access','Acesso admnistrativo',1,1,1,1),
  ((SELECT TOP 1 id_tela FROM aluguel_impressora.dbo.tela WHERE cd_tela = 'FUNCIONARIO'),'adm_access','Acesso admnistrativo',1,1,1,1),
  ((SELECT TOP 1 id_tela FROM aluguel_impressora.dbo.tela WHERE cd_tela = 'IMPRESSORA'),'adm_access','Acesso admnistrativo',1,1,1,1),
  ((SELECT TOP 1 id_tela FROM aluguel_impressora.dbo.tela WHERE cd_tela = 'FORNECEDOR'),'adm_access','Acesso admnistrativo',1,1,1,1),
  ((SELECT TOP 1 id_tela FROM aluguel_impressora.dbo.tela WHERE cd_tela = 'MODELO_IMPRESSORA'),'adm_access','Acesso admnistrativo',1,1,1,1),
  ((SELECT TOP 1 id_tela FROM aluguel_impressora.dbo.tela WHERE cd_tela = 'NOVO_CONTRATO'),'adm_access','Acesso admnistrativo',1,1,1,1),
  ((SELECT TOP 1 id_tela FROM aluguel_impressora.dbo.tela WHERE cd_tela = 'HOME'),'adm_access','Acesso admnistrativo',1,1,1,1)
;


INSERT INTO aluguel_impressora.dbo.acesso
(id_tela, cd_acesso, nm_acesso, in_read, in_create, in_update, in_delete)
VALUES
  ((SELECT TOP 1 id_tela FROM aluguel_impressora.dbo.tela WHERE cd_tela = 'CLIENTE'),'func_access_default','Acesso funcionario',1,1,1,1),
  ((SELECT TOP 1 id_tela FROM aluguel_impressora.dbo.tela WHERE cd_tela = 'IMPRESSORA'),'func_access_default','Acesso funcionario',1,1,1,1),
  ((SELECT TOP 1 id_tela FROM aluguel_impressora.dbo.tela WHERE cd_tela = 'NOVO_CONTRATO'),'func_access_default','Acesso funcionario',1,1,1,1),
  ((SELECT TOP 1 id_tela FROM aluguel_impressora.dbo.tela WHERE cd_tela = 'HOME'),'func_access_default','Acesso funcionario',1,1,1,1)
;