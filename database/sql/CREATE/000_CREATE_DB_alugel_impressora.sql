USE master; 
GO

IF EXISTS (SELECT 1 FROM sys.databases WHERE name = 'alugel_impressora')
BEGIN
    DROP DATABASE alugel_impressora;
END;
GO

-- Verifica se o banco de dados 'alugel_impressora' existe e cria se não existir
IF NOT EXISTS (SELECT 1 FROM sys.databases WHERE name = 'alugel_impressora')
BEGIN
    CREATE DATABASE alugel_impressora;
END;
GO

-- Verifica se o login 'usr_alugel_impressora' existe e cria se não existir
IF NOT EXISTS (SELECT 1 FROM sys.server_principals WHERE name = 'usr_alugel_impressora')
BEGIN
    CREATE LOGIN usr_alugel_impressora WITH PASSWORD = 'u5r_@lug3l_1mpr3550r@';
END;
GO

-- Conecta ao banco de dados 'alugel_impressora'
USE alugel_impressora;
GO

-- Verifica se o usuário 'usr_alugel_impressora' existe no banco de dados 'alugel_impressora' e cria se não existir
IF NOT EXISTS (SELECT 1 FROM sys.database_principals WHERE name = 'usr_alugel_impressora')
BEGIN
    CREATE USER usr_alugel_impressora FOR LOGIN usr_alugel_impressora;
    ALTER ROLE db_owner ADD MEMBER usr_alugel_impressora;  -- Ajuste de permissão, pode ser necessário
END;
GO

-- Concede permissões necessárias ao usuário 'usr_alugel_impressora'
GRANT SELECT, INSERT, UPDATE, DELETE ON SCHEMA::dbo TO usr_alugel_impressora;
GO