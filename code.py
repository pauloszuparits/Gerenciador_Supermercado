import mysql.connector
from random import *
from mysql.connector import errorcode
from tabulate import tabulate

#Função de testes

def testes():
    count = 0
    # Teste 1
    nome = "Teste"+str(randint(0,100));
    peso = uniform(1.0, 50.0);
    valor = uniform(5.0, 100.0)
    try:
        cadastrarProduto(nome, peso, valor);
        count += 1;
    except:
        print("Teste 1 fracassou");
    
    # Teste 2
    try:
        sql = "SELECT IdProduto, Nome, Peso, Valor FROM Produtos WHERE Nome ="+nome
        ret = procura(sql);
        if ret == "-1" or ret == "-2":
            print("Teste 2 fracassou " + ret);
        else:
            count += 1
    except:
        print("Teste 2 fracassou");

    input("Continuar Testes?");
    
    # Teste 3
    nome = "Novo_Teste"+str(randint(0,100));
    peso = 0.0
    valor = 0.0
    try:
        ret = alteraProduto(nome, 1 ,"Nome");
        if ret == "-1":
            print("Teste 3 fracassou");
        ret = alteraProduto(peso, 1 ,"Peso");
        if ret == "-1":
            print("Teste 3 fracassou");
        ret = alteraProduto(valor, 1 ,"Valor");
        if ret == "-1":
            print("Teste 3 fracassou");
        else:
            count += 1
    except:
        print("Teste 3 fracassou");
    
    print("Testes concluídos com sucesso: {}/3".format(count))

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
        return "1";
    except:
        
        cursor.close()
        db_connection.close()
        return "-1";

# Procurar Produto

def procura(sql):  
    db_connection = mysql.connector.connect(host='localhost', user='root', password='Oicueio1!@#$', database='supermercado');
    cursor = db_connection.cursor();
    try:
        cursor.execute(sql);
        lista = []
        for row in cursor:
            lista.append(row);
        if len(lista) == 0:
            return '-1'
        else:
            return lista;
    except:
        return '-2';
    
    
# Altera Produto

def alteraProduto(altera, id, campo):
    db_connection = mysql.connector.connect(host='localhost', user='root', password='Oicueio1!@#$', database='supermercado');
    cursor = db_connection.cursor();
    sql = "UPDATE Produtos SET {} = %s WHERE IdProduto = %s".format(campo)
    values = ( altera, id)
    try:
        cursor.execute(sql, values);
        cursor.close()
        db_connection.commit()
        db_connection.close()
        return "1";
    except:
        return "-1";

# Listar 
def listar(tabela):
    db_connection = mysql.connector.connect(host='localhost', user='root', password='Oicueio1!@#$', database='supermercado');
    cursor = db_connection.cursor();
    sql = "SELECT * FROM {}".format(tabela)
    try:
        cursor.execute(sql);
        lista = []
        for row in cursor:
            lista.append(row);
        if len(lista) == 0:
            return '-1'
        else:
            return lista;
    except:
        return '-2';
    

# testes();

# Execução

print("Seja bem vindo ao sistema do supermercado!");


while 0 == 0:
    print("Escolha uma das opções abaixo para prosseguir");


    op = input(
        "1 - Cadastrar Produto\n"
        "2 - Procurar Produto\n"
        "3 - Alterar Produto\n"
        "4 - Remover Produto\n"
        "5 - Listar Produtos\n"
        "99 - Sair\n"
    );

    if op == "1": # colocar um while aqui
        nome = input("Digite o nome do produto: \n");
            
        peso = float(input("Digite o peso do produto: \n"));
        valor = float(input("Digite o valor do produto: \n"));
        
        retorno = cadastrarProduto(nome, peso, valor);
        if(retorno == "-1"):
            print("Erro na inserção"); # colocar um continue aqui
        else:
            print("Produto cadastrado com sucesso!");
        
    if op == "2":
        
        while 0 == 0: # Só sai quando digita 3 ou quando termina a busca e o user digita N
            op2 = input(
                "Você deseja procurar o produto por:\n"
                "1 - Id\n"
                "2 - Nome do Produto\n"
                "3 - Voltar para o Menu\n"
            )
            if(op2 == "3"):
                break;
            if(op2 == "1"):
                ipt = input("Digite o ID do Produto:\n");
                sql = "SELECT IdProduto, Nome, Peso, Valor  FROM Produtos WHERE IdProduto ={}".format(ipt);      
                lista = procura(sql);
            if(op2 == "2"):
                
                ipt = "'"+input("Digite o nome do produto:\n")+"'";
                sql = "SELECT IdProduto, Nome, Peso, Valor  FROM Produtos WHERE Nome ={}".format(ipt);
                lista = procura(sql);

            if lista == '-1':
                print("Produto não encontrado, tente novamente");
            elif lista == '-2':
                print("Ocorreu algum erro!")
            else:
                print("Abaixo os produtos encontrados:\n");       

                print(tabulate(lista, headers=["Id", "Nome", "Peso", "Valor"]));

                op3 = input("\n Deseja pesquisar mais algum? (S \ N) ").upper();
                if op3 == "N":
                    break;

    if op == "3":
        while(1 == 1):
            idProd = input("Digite o Id do produto a ser alterado");
            sql = "SELECT IdProduto, Nome, Peso, Valor  FROM Produtos WHERE IdProduto ={}".format(idProd); 
            ret = procura(sql);
            if ret == "-1":
                print("Produto não encontrado!");
                continue
            else:
                print(tabulate(ret, headers=["Id", "Nome", "Peso", "Valor"]));
                op4 = input("O produto que você deseja alterar é o produto acima? (S / N)").upper()
                if op4 == 'S':
                    op5 = input("O que você deseja alterar?\n"
                          "1 - Nome\n"
                          "2 - Valor\n"
                          "3 - Peso\n"
                          "4 - Voltar para menu\n")
                    if op5 == "1":
                        newName = input("Digite o novo nome: ")
                        ret = alteraProduto(newName, idProd, "Nome");
                    elif op5 == "2":
                        newVal = float(input("Digite o novo valor: "))
                        ret = alteraProduto(newVal, idProd, "Valor")
                    elif op5 == "3":
                        newPes = float(input("Digite o novo peso: "))
                        ret = alteraProduto(newPes, idProd, "Peso")
                    if ret == "-1":
                        print("Erro em alterar, tente novamente")
                        continue
                    if ret == "1":
                        op6 = input("Alteração feita, gostaria de fazer mais alguma alteração? (S / N)").upper();
                        if op6 == 'N':
                            break;
                    else:
                        continue
                else:
                    continue
    if op == "5":
        lista = listar("Produtos");
        print(tabulate(lista, headers=["Id", "Nome", "Peso", "Valor"]));


    if op == "99":
        print("Volte sempre!")
        break; 
    
