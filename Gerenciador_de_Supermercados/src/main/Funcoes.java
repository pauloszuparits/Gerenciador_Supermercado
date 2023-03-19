package main;

import java.sql.SQLException;
import java.sql.Statement;

public class Funcoes {
	public Retornos tiposDeRetornos = new Retornos();
	
	
	public Retorno altera(Statement declaracaoConexao, CamposAlteracao campos) {
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
