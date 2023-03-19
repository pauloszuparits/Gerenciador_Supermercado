package main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Funcoes {
	public Retornos tiposDeRetornos = new Retornos();
	
	public boolean isEmptyList(ArrayList lista) {
		return lista.size() == 0;
	}
	
	
	public ArrayList<Retorno> buscaProduto(Statement declaracaoConexao, String nome) {
		ArrayList<Retorno> retornos = new ArrayList<Retorno>();
		String sql = "SELECT IdProduto, Nome, Peso, Valor From Produtos"
					+" WHERE Nome = '"+nome+"'";
		
		try {
			ResultSet resultadoDaBusca = declaracaoConexao.executeQuery(sql);
			while(resultadoDaBusca.next()) {
				
				int idProduto = resultadoDaBusca.getInt("IdProduto");
				String nomeProduto = resultadoDaBusca.getString("Nome");
				double pesoProduto = resultadoDaBusca.getDouble("Peso");
				double valorProduto = resultadoDaBusca.getDouble("Valor");
				
				Produto produtoEncontrado = new Produto(idProduto, nomeProduto, pesoProduto, valorProduto);
				retornos.add(tiposDeRetornos.retornaRetornoMaisProduto(tiposDeRetornos.getSucessoNaBusca(), produtoEncontrado));
			}
			
		} catch (SQLException e) {
			retornos.add(tiposDeRetornos.getErroNaBusca());
			
		}
		if(isEmptyList(retornos)) {
			retornos.add(tiposDeRetornos.getItemNaoEncontradoBusca());
		}
		
		return(retornos);
	}
	
	public Retorno removeItemTabela(Statement declaracaoConexao, CamposAlteracao campos) {
		String sql = "DELETE FROM "+campos.getTabela()
					+" WHERE "+campos.getCampo()+" = '"+campos.getId()+"'";
				
		try {
			declaracaoConexao.executeUpdate(sql);
		} catch (SQLException e) {
			return tiposDeRetornos.getErroNaDelecao();
		}
		
		return tiposDeRetornos.getSucessoNaDelecao();
		
	}
	
	
	public Retorno alteraItemTabela(Statement declaracaoConexao, CamposAlteracao campos) {
		String sql = "UPDATE "+campos.getTabela()
					+" SET "+campos.getCampo()+"='"+campos.getValorParaAlterarCampo()+"'"
					+" WHERE IdProduto = "+campos.getId();		
		
		try {
			declaracaoConexao.executeUpdate(sql);
		} catch (SQLException e) {
			
			return tiposDeRetornos.getErroNaAlteracao();
		}
		
		
		return tiposDeRetornos.getSucessoNaAlteracao();
	}
}
