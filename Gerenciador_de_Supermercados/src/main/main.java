package main;
import java.sql.*;
public class main {
	
	public static void main(String[] args) throws SQLException {
		
		Conexao conexaoComMysql = new Conexao();
		
		
		Produto testeJava = new Produto("TesteJava", 99.99, 112.60);
		
		Statement declaracaoConexao = conexaoComMysql.getConection().createStatement();	
		
		Retorno retornoInsercaoProduto = testeJava.InsereProduto(declaracaoConexao);
		
		System.out.println(retornoInsercaoProduto.getDescricaoRetorno());
		
	}

}
