# Gerenciador de Supemercado

## Objetivo
Com o objetivo de ser um gerenciador básico para supermercados, este software feito na **linguagem java** visa gerenciar clientes, produtos e compras usando de um **banco de dados mysql**.

## Funcionalidades

#### Iniciar Venda   

A funcionalidade de iniciar venda é feita para que o usuário consiga vender um ou mais produtos do supermercado em questão. Nessa venda, o usuário pode ou não vincular um cliente.Após escolher se irá ou não vincular a venda a um cliente, o usuário irá digitar cada produto que será vendido pelo estabelecimento.Ao finalizar a venda, será mostrado o valor que foi gasto nessa venda.  

![Imagem exemplo de uma venda sem cliente](imgs/VendaSemCliente.png)  

#### Administrar o sistema  

A funcionalidade de administrar o sistema serve para o usuário ter um acesso ao banco de dados de maneira mais profunda. Esta funcionalidade está dividida em módulos, sendo eles:  
**Módulo Cliente**  
**Módulo Produto** 
**Módulo Compra**  
Cada um destes módulos possui funcionalidades.  
Os módulos **cliente e produto** possuem as funcionalidades de:  
Cadastrar, alterar, listar e buscar.  

![Imagem exemplo de um cadastro de produto](imgs/ExemploCadastroProduto.png)  

Já o módulo de **compras** possui a funcionalidade de listar todas as compras feitas por um cliente em específico.  

![Imagem exemplo de uma listagem de compra por cliente](imgs/ExemploListagemCompras.png)

## Documentação técnica  

### Classes  

#### Cliente  

A classe cliente possui 7 parâmetros, sendo eles:
-	int idCliente;
-	String nome;
-	String sobrenome;
-	Date dtNasc;
-	String cpf;
-	Endereco endereco;
-	Compra compra;

E possui 3 construtores, 1 deles recebe nome, sobrenome, dtNasc, cpf, endereço, o outro construtor recebe nome, sobrenome, drNasc e compra e o ulitmo construtor recebe idCliente, nome, sobrenome, dtNasc, cpf, endereco.  

![Construtores classe cliente]()

##### Métodos

Todos os parametros possuem métodos "get e set".  

O cliente possue 3 métodos:  
- InsereCLiente -> recebe a declaração de conexão ,insere o cliente no banco de dados e retorna um objeto Retorno
- retornaClienteMaisCompra -> retorna uma string que contém nome, sobrenome, dtNasc, e compra
- toString -> retorna uma string contendo os dados do cliente.  

![Métodos classe cliente]()  

#### Produto

A classe produto possui 4 parametros, sendo eles:
-	int idProduto;
-	String nome;
-	double peso;
-	double valor;  

E possui 2 construtores, 1 deles recebe nome, peso e valor. O outro recebe IdProduto, nome, peso e valor.  

![Construtores classe produto]()  

##### Métodos  

O produto possui 2 métodos:
- InsereProduto -> recebe a declaração de conexão, insere o cliente no banco de dados e retorna um objeto Retorno
- toString -> retorna uma string contendo os dados do produto.  

![Metodos classe produto]()  


#### Compra  

A classe compra possui 3 parametros, sendo eles:
-	int idCliente;
-	double somaCompraCliente;
-	Date dtCompra;  

E possui um construtor que recebe, idCliente, somaCompraCliente, dtCompra  

![Construtores classe compra]()

##### Métodos  

A compra possui 2 métodos:
- InsereCompra -> recebe a declaração de conexão, insere a compra no banco de dados e retorna um objeto Retorno.
- toString -> retorna uma string contendo os dados da compra  

![Metodos classe compra]()  

#### Conexao

A classe conexao possui 6 parametros, sendo eles:  

- String server;
- String database;
- String port;               
- String user;
- String passwd;
	
- Connection conection;

A classe não possui construtor. Ao instancia-la, a classe entra em um "try catch" onde os parametros são inicializados com os dados do banco e a variavel conection é atribuida por uma função getConnection da classe DriveManager.  

![Classe conexao]()

##### Métodos  

A classe conexão possui 1 método:
-getConection -> Retorna this.conection;  
    
![Metodos da classe conexao]()  
