INSERT INTO aluguel_impressora.dbo.acesso
(id_tela, cd_acesso, nm_acesso, in_read, in_create, in_update, in_delete)
VALUES
((SELECT TOP 1 id_tela FROM aluguel_impressora.dbo.tela WHERE cd_tela = 'CLIENTE'),'adm_access_cliente','Acesso admnistrativo cliente',1,1,1,1),
((SELECT TOP 1 id_tela FROM aluguel_impressora.dbo.tela WHERE cd_tela = 'FUNCIONARIO'),'adm_access_cliente','Acesso admnistrativo cliente',1,1,1,1),
((SELECT TOP 1 id_tela FROM aluguel_impressora.dbo.tela WHERE cd_tela = 'IMPRESSORA'),'adm_access_cliente','Acesso admnistrativo cliente',1,1,1,1)
;