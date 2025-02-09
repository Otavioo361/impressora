import os
import re
import sys


template = """
IF NOT EXISTS(SELECT 1 FROM sys.tables WHERE NAME = '{nm_tabela}')
BEGIN
    CREATE TABLE aluguel_impressora.dbo.{nm_tabela} (
        id_{nm_tabela} BIGTIN NOT NULL IDENTITY(1,1),

        dt_inclusao DATETIME NOT NULL DEFAULT GETDATE(),
        dt_alteracao DATETIME NULL,
        nm_usuario VARCHAR(60) NULL,
        CONSTRAINT PK_{nm_tabela} PRIMARY KEY (id_{nm_tabela})
    );
END;
"""

def renumerar_arquivos(diretorio, numero_inicial, quantidade):
    """
    Renumera arquivos SQL para abrir espaço na sequência.
    
    :param diretorio: Caminho da pasta contendo os arquivos SQL.
    :param numero_inicial: Número sequencial a partir do qual abrir espaço.
    :param quantidade: Quantidade de espaços a abrir.
    """
    arquivos = [f for f in os.listdir(diretorio) if re.match(r"^\d{3}_.*\.sql$", f)]
    arquivos.sort()

    for arquivo in reversed(arquivos):
        numero_atual = int(arquivo[:3])
        if numero_atual >= numero_inicial:
            novo_numero = numero_atual + quantidade
            novo_nome = f"{novo_numero:03d}_{'_'.join(arquivo.split('_')[1:])}"
            os.rename(os.path.join(diretorio, arquivo), os.path.join(diretorio, novo_nome))

def organizar_sequencia(diretorio):
    """
    Reorganiza os arquivos SQL para corrigir a sequência numérica.
    
    :param diretorio: Caminho da pasta contendo os arquivos SQL.
    """
    arquivos = [f for f in os.listdir(diretorio) if re.match(r"^\d{3}_.*\.sql$", f)]
    arquivos.sort()

    for i, arquivo in enumerate(arquivos):
        novo_numero = i
        novo_nome = f"{novo_numero:03d}_{'_'.join(arquivo.split('_')[1:])}"
        os.rename(os.path.join(diretorio, arquivo), os.path.join(diretorio, novo_nome))

def criar_novo_arquivo(diretorio, numero_antecessor, nome_tabela):
    """
    Cria um novo arquivo SQL na sequência correta.

    :param diretorio: Caminho da pasta contendo os arquivos SQL.
    :param numero_antecessor: Número do arquivo que antecederá o novo arquivo.
    :param nome_tabela: Nome da tabela para o novo arquivo.
    """
    arquivos = [f for f in os.listdir(diretorio) if re.match(r"^\d{3}_.*\.sql$", f)]
    arquivos.sort()

    # Renomear para abrir espaço
    renumerar_arquivos(diretorio, numero_antecessor + 1, 1)

    # Nome do novo arquivo
    novo_numero = numero_antecessor + 1
    novo_nome = f"{novo_numero:03d}_CREATE_{nome_tabela}.sql"

    # Caminho do novo arquivo
    caminho_novo_arquivo = os.path.join(diretorio, novo_nome)
    
    # Criar o arquivo
    with open(caminho_novo_arquivo, "w") as arquivo:
        arquivo.write(template.format(nome_tabela))

    print(f"Novo arquivo criado: {caminho_novo_arquivo}")

if __name__ == "__main__":
    if len(sys.argv) < 2:
        print("Uso: python gerenciar_sequencia.py <caminho_da_pasta>")
        sys.exit(1)
    
    caminho_pasta = sys.argv[1]
    
    if not os.path.isdir(caminho_pasta):
        print(f"Erro: O caminho '{caminho_pasta}' não é um diretório válido.")
        sys.exit(1)
    
    print("Escolha uma opção:")
    print("1. Abrir espaço na sequência")
    print("2. Organizar sequência")
    print("3. Criar um novo arquivo")
    opcao = int(input("Opção: ").strip())
    
    if opcao == 1:
        seq_inicial = int(input("Digite o número sequencial inicial: ").strip())
        qtd = int(input("Digite a quantidade de espaços a abrir: ").strip())
        renumerar_arquivos(caminho_pasta, seq_inicial, qtd)
        print("Espaço aberto na sequência com sucesso!")
    elif opcao == 2:
        organizar_sequencia(caminho_pasta)
        print("Sequência reorganizada com sucesso!")
    elif opcao == 3:
        numero_antecessor = int(input("Digite o número do arquivo que antecede o novo: ").strip())
        nome_tabela = input("Digite o nome da tabela: ").strip()
        criar_novo_arquivo(caminho_pasta, numero_antecessor, nome_tabela)
    else:
        print("Opção inválida!")
