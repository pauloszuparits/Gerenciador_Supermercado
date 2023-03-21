package main;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
public class main {
	
	public static void main(String[] args) throws SQLException {
		Scanner entradaDados = new Scanner(System.in);
		System.out.println("Bem-vindo ao gerenciador de supermercado");
		System.out.println("Deseja \n1-Iniciar uma Venda\n2-Administrar o sistema");
		int vendaOuAdministracao = entradaDados.nextInt();
		if(vendaOuAdministracao == 1) {
			iniciaVenda();
		}else {
			iniciaAdministracaoSistema();
		}
		/*
		Funcoes funcao = new Funcoes();
		Conexao conexaoComMysql = new Conexao();
		Statement declaracaoConexao = conexaoComMysql.getConection().createStatement();
		*/
		/*
		Retorno retorno = funcao.listaItensTabela(declaracaoConexao, "Produtos");
		ResultSet resultadoQuery = retorno.getResultadoQuery();
		try {
			while(resultadoQuery.next()) {
				int idProduto = resultadoQuery.getInt("IdProduto");
				String nomeProduto = resultadoQuery.getString("Nome");
				double peso = resultadoQuery.getDouble("Peso");
				double valor = resultadoQuery.getDouble("Valor");
				
				//String formatada = String.format("IdProduto: %i\nNome do Produto: %s\nPeso: %d\nValor:%d\n", idProduto,nomeProduto,peso,valor);
				System.out.println(idProduto + "\n" + nomeProduto + "\n" + peso + "\n" + valor + "\n");
				
			}
		}catch(Exception e) {
			System.out.println(retorno.getDescricaoRetorno());
		}
		*/
		/*
		Compra compra = new Compra(2, 1200.00, new Date(01012022));
		Retorno retorno = compra.InsereCompra(declaracaoConexao);
		System.out.println(retorno.getDescricaoRetorno());
		*/
		
		/*
		ArrayList<Retorno> retornos = funcao.buscaCliente(declaracaoConexao,"123123123");
		try {
			retornos.forEach((n)->System.out.println(n.getCliente().getNome() + " " + n.getCliente().getSobrenome()));
		}catch(Exception e) {
			System.out.println(retornos.get(0).getDescricaoRetorno());
		}
		*/
		
		/*
		Endereco endereco = new Endereco("04622012", 45, "Ap.212");
		Cliente cliente = new Cliente("Isabela", "Halker", new Date(26,06,1998), "1597322022", endereco);
		Retorno retorno = cliente.InsereCliente(declaracaoConexao);
		System.out.println(retorno.getDescricaoRetorno());
		*/
		
		/*
		CamposAlteracao campos = new CamposAlteracao("Produtos","IdProduto" ,106);
		Retorno retorno = funcao.removeItem(declaracaoConexao, campos);
		System.out.println(retorno.getDescricaoRetorno());
		*/
		
		/*
		Statement declaracaoConexao = conexaoComMysql.getConection().createStatement();
		
		ArrayList<Retorno> retornos= funcao.buscaProduto(declaracaoConexao, "Fandangos");
		try {
			retornos.forEach((n)-> System.out.println(n.getProduto().getValor()));
		}catch(Exception e) {
			System.out.println(retornos.get(0).getDescricaoRetorno());
		}
		*/
		
		/*
		CamposAlteracao campos = new CamposAlteracao("Produtos",106, "Peso", "7.66");		
		
		Retorno retornoAlteracaoProduto = funcao.altera(declaracaoConexao, campos);
		System.out.println(retornoAlteracaoProduto.getDescricaoRetorno());
		*/
		
		/*
		Produto testeJava = new Produto("TesteJava", 99.99, 112.60);
		
		Statement declaracaoConexao = conexaoComMysql.getConection().createStatement();	
		
		Retorno retornoInsercaoProduto = testeJava.InsereProduto(declaracaoConexao);
		
		System.out.println(retornoInsercaoProduto.getDescricaoRetorno());
		*/
		
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
	
	public static void iniciaAdministracaoSistema() throws SQLException{	
		Scanner entradaDados = new Scanner(System.in);
		
		System.out.println("Bem vindo a administracao do sistema");
		System.out.println("Deseja administrar qual Módulo:");
		System.out.println("1-Cliente\n2-Produto\n3-Compra");
		int escolhaModuloUsuario = entradaDados.nextInt();
		switch(escolhaModuloUsuario) {
			case 1:
				moduloCliente();
			case 2:
				moduloProduto();
			case 3:
				moduloCompra();
			default:
				System.out.println("Opcao Invalida");
		}
	}
	
	public static void moduloCliente() throws SQLException {
		FuncoesParaModulosAdministracao funcaoModulo = new FuncoesParaModulosAdministracao();
		Conexao conexaoComMysql = new Conexao();
		Statement declaracaoConexao = conexaoComMysql.getConection().createStatement();
		Scanner entradaDados = new Scanner(System.in);
		
		System.out.println("Você deseja:");
		System.out.println("1-Cadastrar cliente\n2-Alterar cliente\n3-RemoverCliente\n4-Listar clientes");
		int escolhaAcaoUsuario = entradaDados.nextInt();
		switch(escolhaAcaoUsuario) {
			case 1:
			try {
				Retorno retorno = funcaoModulo.cadastrarCliente(declaracaoConexao);
				System.out.println(retorno);	
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			case 2:
			
			
		}
	}

	public static void moduloProduto() throws SQLException {
		FuncoesParaClasses funcao = new FuncoesParaClasses();
		Conexao conexaoComMysql = new Conexao();
		Statement declaracaoConexao = conexaoComMysql.getConection().createStatement();
		Scanner entradaDados = new Scanner(System.in);
		
		
	}
	
	public static void moduloCompra() throws SQLException {
		FuncoesParaClasses funcao = new FuncoesParaClasses();
		Conexao conexaoComMysql = new Conexao();
		Statement declaracaoConexao = conexaoComMysql.getConection().createStatement();
		Scanner entradaDados = new Scanner(System.in);
		
		
	}
	
	public static boolean isZero(double numero) {
		return numero <= 0.0;
	}

}
