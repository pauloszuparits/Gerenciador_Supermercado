package main;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class FuncoesModuloProduto {
	public Retorno cadastrarProduto(Statement declaracaoConexao) {
		Scanner entradaDados = new Scanner(System.in);

		System.out.println("Digite o nome do produto");
		String nomeProduto = entradaDados.next();
		System.out.println("Digite o peso do produto");
		double pesoProduto = entradaDados.nextDouble();
		System.out.println("Digite o valor do produto");
		double valorProduto = entradaDados.nextDouble();
		
		Produto produto = new Produto(nomeProduto, pesoProduto, valorProduto);
		
		entradaDados.close();
		return produto.InsereProduto(declaracaoConexao);
	}
	
	public Retorno alterarProduto(Statement declaracaoConexao) {
		FuncoesParaClasses funcao = new FuncoesParaClasses();
		Scanner entradaDados = new Scanner(System.in);
		System.out.print("Digite o id do produto");
		int idProduto = entradaDados.nextInt();
		System.out.println("Digite o campo que será alterado");
		String campoAlterar = entradaDados.next();
		System.out.println("Digite o novo valor para o campo");
		String novoValorCampo = entradaDados.next();
		
		CamposAlteracao camposAlterar = new CamposAlteracao("IdProduto", "Produtos", idProduto, campoAlterar, novoValorCampo);
		
		entradaDados.close();
		return funcao.alteraItemTabela(declaracaoConexao, camposAlterar);
	}
	
	public ArrayList<Retorno> listarProdutos(Statement declaracaoConexao){
		Retornos tiposDeRetornos = new Retornos();
		ArrayList<Retorno> retornosListagem = new ArrayList<>();
		FuncoesParaClasses funcao = new FuncoesParaClasses();
		
		try {
			Retorno retorno = funcao.listaItensTabela(declaracaoConexao, "Produtos");
			ResultSet resultadoListagem = retorno.getResultadoQuery();
			while(resultadoListagem.next()) {
				int idProduto = resultadoListagem.getInt("IdProduto");
				String nomeProduto = resultadoListagem.getString("Nome");
				double pesoProduto = resultadoListagem.getDouble("Peso");
				double valorProduto = resultadoListagem.getDouble("Valor");
				
				Produto produto = new Produto(idProduto,nomeProduto, pesoProduto, valorProduto);
				retornosListagem.add(tiposDeRetornos.retornaRetornoMaisProduto(tiposDeRetornos.getSucessoNaListagem(), produto));
			}
		}catch(Exception e) {
			retornosListagem.add(tiposDeRetornos.getErroNaListagem());
		}
		
		return retornosListagem;
	}
	
	public ArrayList<Retorno> buscaProduto(Statement declaracaoConexao) {
		Scanner entradaDados = new Scanner(System.in);
		FuncoesParaClasses funcao = new FuncoesParaClasses();
		
		System.out.println("Digite o nome do produto");
		String nomeProdutoBusca = entradaDados.next();
		
		entradaDados.close();
		return funcao.buscaProduto(declaracaoConexao, nomeProdutoBusca);
		
	}
}
