import mysql.connector
from mysql.connector import errorcode
import datetime

# Funções

# Insere produto
def cadastrarProduto(nome, peso, valor):
    db_connection = mysql.connector.connect(host='localhost', user='root', password='Oicueio1!@#$', database='supermercado');

    cursor = db_connection.cursor()

    sql = "INSERT INTO Produtos(Nome, Peso, Valor) VALUES (%s, %s, %s)";
    values = (nome, peso, valor);

    try:
        cursor.execute(sql, values);

        cursor.close()
        db_connection.commit()
        db_connection.close()
    except:
        print("Erro na inserção");
        cursor.close()
        db_connection.close()
        return;

    


# Execução

print("Seja bem vindo ao sistema do supermercado!");
print("Escolha uma das opções abaixo para prosseguir");


op = input(
    "1 - Cadastrar Produto\n"
    "2 - Procurar Produto\n"
    "3 - Alterar Produto\n"
    "4 - Remover Produto\n"
);

if op == "1":
    nome = input("Digite o nome do produto: \n");
         
    peso = float(input("Digite o peso do produto: \n"));
    valor = float(input("Digite o valor do produto: \n"));
       
    cadastrarProduto(nome, peso, valor);
    