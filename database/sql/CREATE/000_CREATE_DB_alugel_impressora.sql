USE master; 
GO

IF EXISTS (SELECT 1 FROM sys.databases WHERE name = 'aluguel_impressora')
BEGIN
    DROP DATABASE aluguel_impressora;
END;
GO

-- Verifica se o banco de dados 'aluguel_impressora' existe e cria se não existir
IF NOT EXISTS (SELECT 1 FROM sys.databases WHERE name = 'aluguel_impressora')
BEGIN
    CREATE DATABASE aluguel_impressora;
END;
GO

-- Verifica se o login 'usr_aluguel_impressora' existe e cria se não existir
IF NOT EXISTS (SELECT 1 FROM sys.server_principals WHERE name = 'usr_aluguel_impressora')
BEGIN
    CREATE LOGIN usr_aluguel_impressora WITH PASSWORD = 'u5r_@lug3l_1mpr3550r@';
END;
GO

-- Conecta ao banco de dados 'aluguel_impressora'
USE aluguel_impressora;
GO

-- Verifica se o usuário 'usr_aluguel_impressora' existe no banco de dados 'aluguel_impressora' e cria se não existir
IF NOT EXISTS (SELECT 1 FROM sys.database_principals WHERE name = 'usr_aluguel_impressora')
BEGIN
    CREATE USER usr_aluguel_impressora FOR LOGIN usr_aluguel_impressora;
    ALTER ROLE db_owner ADD MEMBER usr_aluguel_impressora;  -- Ajuste de permissão, pode ser necessário
END;
GO

-- Concede permissões necessárias ao usuário 'usr_aluguel_impressora'
GRANT SELECT, INSERT, UPDATE, DELETE ON SCHEMA::dbo TO usr_aluguel_impressora;
GO