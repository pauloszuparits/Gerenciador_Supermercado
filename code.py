import mysql.connector
from mysql.connector import errorcode
from tabulate import tabulate

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

    if op == "1":
        nome = input("Digite o nome do produto: \n");
            
        peso = float(input("Digite o peso do produto: \n"));
        valor = float(input("Digite o valor do produto: \n"));
        
        retorno = cadastrarProduto(nome, peso, valor);
        if(retorno == "-1"):
            print("Erro na inserção");
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

                op3 = input("\n Deseja pesquisar mais algum? (S \ N) ")
                if op3 == "N":
                    break;
                
    if op == "99":
        print("Volte sempre!")
        break; 
    
