package main;
import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
public class main {
	
	public static void main(String[] args) throws SQLException, ParseException {
		
		Scanner entradaDados = new Scanner(System.in);
		System.out.println("Bem-vindo ao gerenciador de supermercado");
		System.out.println("Deseja \n1-Iniciar uma Venda\n2-Administrar o sistema");
		int vendaOuAdministracao = entradaDados.nextInt();
		if(vendaOuAdministracao == 1) {
			iniciaVenda();
		}else {
			iniciaAdministracaoSistema();
		}
		
		entradaDados.close();
	}
	
	public static void iniciaVenda() throws SQLException {
		
		
		FuncoesParaClasses funcao = new FuncoesParaClasses();
		Conexao conexaoComMysql = new Conexao();
		Statement declaracaoConexao = conexaoComMysql.getConection().createStatement();
		
		Scanner entradaDados = new Scanner(System.in);
		
		System.out.println("Deseja incluir cliente na compra (S/N)");
		boolean incluiClienteCompra = entradaDados.next().toUpperCase().equals("S");
		
		System.out.println("Passe as compras! - Escape = exit");
		String idProduto = "0";
		double valorProduto = 0.0;
		double somaValorProduto = 0.0;
		int idClienteGenerico = -1;
		
		while(!idProduto.equals("exit")) {
			idProduto = entradaDados.next();
			valorProduto = funcao.buscaValorProduto(declaracaoConexao, idProduto).getValorProduto();
			somaValorProduto += valorProduto;
		}
		
		if(incluiClienteCompra) {
			int idClienteEncontrado = idClienteGenerico;
			System.out.println("Digite o CPF do cliente");
			String cpfDigitado = entradaDados.next();
			try {
				idClienteEncontrado = funcao.buscaCliente(declaracaoConexao, cpfDigitado).get(0).getCliente().getIdCliente();
			}catch(Exception e) {
				System.out.println(funcao.buscaCliente(declaracaoConexao, cpfDigitado).get(0).getDescricaoRetorno());
			}
			
			Compra compraComCliente = new Compra(idClienteEncontrado,somaValorProduto,new Date(System.currentTimeMillis()));
			Retorno retornoCompra = compraComCliente.InsereCompra(declaracaoConexao);
			try {
				System.out.println(retornoCompra.getDescricaoRetorno() + "\nValor total da compra: " + retornoCompra.getValorProduto());
			}catch(Exception e) {
				System.out.println(retornoCompra.getDescricaoRetorno());
			}
			
		}else {
			Compra compraSemCliente = new Compra(idClienteGenerico, somaValorProduto, new Date(System.currentTimeMillis()));
			Retorno retornoCompra = compraSemCliente.InsereCompra(declaracaoConexao);
			try {
				System.out.println(retornoCompra.getDescricaoRetorno() + "\nValor total da compra: " + retornoCompra.getValorProduto());
			}catch(Exception e) {
				System.out.println(retornoCompra.getDescricaoRetorno());
			}
		}
		
		entradaDados.close();
	}
	
	public static void iniciaAdministracaoSistema() throws SQLException, ParseException{	
		Scanner entradaDados = new Scanner(System.in);
		
		System.out.println("Bem vindo a administracao do sistema");
		System.out.println("Deseja administrar qual Módulo:");
		System.out.println("1-Cliente\n2-Produto\n3-Compra");
		int escolhaModuloUsuario = entradaDados.nextInt();
		switch(escolhaModuloUsuario) {
			case 1:
				moduloCliente();
				break;
			case 2:
				moduloProduto();
				break;
			case 3:
				moduloCompra();
			default:
				System.out.println("Opcao Invalida");
		}
		entradaDados.close();
	}
	
	public static void moduloCliente() throws SQLException, ParseException {
		FuncoesModuloCliente funcaoCliente = new FuncoesModuloCliente();
		Conexao conexaoComMysql = new Conexao();
		Statement declaracaoConexao = conexaoComMysql.getConection().createStatement();
		Scanner entradaDados = new Scanner(System.in);
		
		System.out.println("Você deseja:");
		System.out.println("1-Cadastrar cliente\n2-Alterar cliente\n3-Listar clientes\n4-Buscar Cliente");
		int escolhaAcaoUsuario = entradaDados.nextInt();
		
		switch(escolhaAcaoUsuario) {
			case 1:			
				Retorno retornoCadastroCliente = funcaoCliente.cadastrarCliente(declaracaoConexao);
				System.out.println(retornoCadastroCliente.getDescricaoRetorno());
				break;
			
			case 2:
				Retorno retornoAlterarCliente = funcaoCliente.alterarCliente(declaracaoConexao);
				System.out.println(retornoAlterarCliente.getDescricaoRetorno());
				break;
			
			case 3:
				ArrayList<Retorno> listaDeClientes = funcaoCliente.listaClientes(declaracaoConexao);
				try {
					listaDeClientes.forEach(cliente -> System.out.println(cliente.getCliente()));
				}catch(Exception e) {
					System.out.println(listaDeClientes.get(0).getDescricaoRetorno());
				}
				break;
			
			case 4:
				ArrayList<Retorno> retornoBuscaCliente = funcaoCliente.buscarCliente(declaracaoConexao);
				try {
					if(retornoBuscaCliente.get(0).getCliente() != null) {
						retornoBuscaCliente.forEach((cliente)->System.out.println(cliente.getCliente()));
					}else {
						System.out.println(retornoBuscaCliente.get(0).getDescricaoRetorno());
					}
				}catch(Exception e) {
					System.out.println(retornoBuscaCliente.get(0).getDescricaoRetorno());
				}
				
			entradaDados.close();
		}
	}

	public static void moduloProduto() throws SQLException {
		FuncoesModuloProduto funcaoProduto = new FuncoesModuloProduto();
		Conexao conexaoComMysql = new Conexao();
		Statement declaracaoConexao = conexaoComMysql.getConection().createStatement();
		Scanner entradaDados = new Scanner(System.in);
		
		System.out.println("Você deseja:");
		System.out.println("1-Cadastrar produto\n2-Alterar produto\n3-Listar produtos\n4-Buscar produto");
		int escolhaUsuario = entradaDados.nextInt();
		
		switch(escolhaUsuario) {
			case 1:
				Retorno retornoInserirProduto = funcaoProduto.cadastrarProduto(declaracaoConexao);
				System.out.println(retornoInserirProduto.getDescricaoRetorno());
				break;
			case 2:
				Retorno retornoAlterarProduto = funcaoProduto.alterarProduto(declaracaoConexao);
				System.out.println(retornoAlterarProduto.getDescricaoRetorno());
				break;
			case 3:
				ArrayList<Retorno> listaDeProdutos = funcaoProduto.listarProdutos(declaracaoConexao);
				try {
					listaDeProdutos.forEach(produto -> System.out.println(produto.getProduto()));
				}catch(Exception e) {
					System.out.println(listaDeProdutos.get(0).getDescricaoRetorno());
				}
				break;
			case 4:
				ArrayList<Retorno> retornoBuscaProduto = funcaoProduto.buscaProduto(declaracaoConexao);
				try {
					if(retornoBuscaProduto.get(0).getProduto() != null) {
						retornoBuscaProduto.forEach((produto)->System.out.println(produto.getProduto()));
					}else {
						System.out.println(retornoBuscaProduto.get(0).getDescricaoRetorno());
					}
				}catch(Exception e) {
					System.out.println(retornoBuscaProduto.get(0).getDescricaoRetorno());
				}
				
			entradaDados.close();
			break;
		}
		
	}
	
	public static void moduloCompra() throws SQLException {
		FuncoesModuloCompra funcoesCompras = new FuncoesModuloCompra();
		Conexao conexaoComMysql = new Conexao();
		Statement declaracaoConexao = conexaoComMysql.getConection().createStatement();
		Scanner entradaDados = new Scanner(System.in);
		
		System.out.println("Você deseja:");
		System.out.println("1-Listar compras por cliente");
		int escolhaUsuario = entradaDados.nextInt();
		
		switch(escolhaUsuario) {
			case 1:
				ArrayList <Retorno> retonosListagem = funcoesCompras.listarComprasCliente(declaracaoConexao);
				retonosListagem.forEach((compra)->System.out.println(compra.getCliente().retornaClienteMaisCompra()));
				break;
				
		}
		
	}
	
	public static boolean isZero(double numero) {
		return numero <= 0.0;
	}

}
