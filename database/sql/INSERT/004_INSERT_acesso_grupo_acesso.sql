INSERT INTO aluguel_impressora.dbo.acesso_grupo_acesso
(id_grupo_acesso, id_acesso, nm_usuario)
SELECT
  (SELECT TOP 1 id_grupo_acesso FROM aluguel_impressora.dbo.grupo_acesso WHERE cd_grupo_acesso = 'ADM_ACCES_GP'),
  id_acesso,
  'USUARIO_CRIACAO' AS nm_usuario
FROM aluguel_impressora.dbo.acesso a
WHERE a.cd_acesso = 'adm_access'

INSERT INTO aluguel_impressora.dbo.acesso_grupo_acesso
(id_grupo_acesso, id_acesso, nm_usuario)
SELECT
  (SELECT TOP 1 id_grupo_acesso FROM aluguel_impressora.dbo.grupo_acesso WHERE cd_grupo_acesso = 'FUNC_ACCES_GP'),
  id_acesso,
  'USUARIO_CRIACAO' AS nm_usuario
FROM aluguel_impressora.dbo.acesso a
WHERE a.cd_acesso = 'func_access_default'