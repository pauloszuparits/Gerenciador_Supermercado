package main;
import java.sql.*;
public class main {
	
	public static void main(String[] args) throws SQLException {
		Funcoes funcao = new Funcoes();
		Conexao conexaoComMysql = new Conexao();
		Statement declaracaoConexao = conexaoComMysql.getConection().createStatement();
		
		
		
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

}
