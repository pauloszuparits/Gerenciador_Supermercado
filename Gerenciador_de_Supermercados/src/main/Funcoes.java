package main;
import java.sql.*;
public class Funcoes {
	public Retornos tiposDeRetornos = new Retornos();
	
	public Retorno InsereProduto(Produto produto, Statement declaracaoConexao) {
		String sql = "INSERT INTO Produtos(Nome, Peso, Valor)" +
					 " VALUES('"+produto.getNome()+"','"+produto.getPeso()+"','"+produto.getValor()+"')";
				
			try {
				declaracaoConexao.executeUpdate(sql);
			} catch (SQLException e) {
				return tiposDeRetornos.getErroDeInsercao();
			}
	
		return tiposDeRetornos.getSucessoNaInsercao();
	}
}
