package main;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FuncoesParaClasses {
	public Retornos tiposDeRetornos = new Retornos();
	
	public boolean isEmptyList(ArrayList lista) {
		return lista.size() == 0;
	}
	
	public ArrayList<Retorno> buscaCliente(Statement declaracaoConexao, String cpfBusca) {
		ArrayList<Retorno> retornos = new ArrayList<Retorno>();
		
		String sql = "SELECT IdCliente,Nome, Sobrenome, DtNasc, cpf, Cep, Numero, Complemento From Cliente"
					+" WHERE cpf = '"+cpfBusca+"'";
		
		try {
			ResultSet resultadoDaBusca = declaracaoConexao.executeQuery(sql);
			while(resultadoDaBusca.next()) {
				
				int idCliente= resultadoDaBusca.getInt("IdCliente");
				String nome = resultadoDaBusca.getString("Nome");
				String sobrenome = resultadoDaBusca.getString("Sobrenome");
				Date dtNasc = resultadoDaBusca.getDate("DtNasc");
				String cpf = resultadoDaBusca.getString("cpf");
				String cep = resultadoDaBusca.getString("cep");
				int numeroEndereco = resultadoDaBusca.getInt("Numero");
				String complemento = resultadoDaBusca.getString("Complemento");
				
				Endereco enderecoClienteEncontrado = new Endereco(cep, numeroEndereco, complemento);
				Cliente clienteEncontrado = new Cliente(idCliente, nome, sobrenome, dtNasc, cpf, enderecoClienteEncontrado);
				
				retornos.add(tiposDeRetornos.retornaRetornoMaisCliente(tiposDeRetornos.getSucessoNaBusca(), clienteEncontrado));
			}
			
		} catch (SQLException e) {
			retornos.add(tiposDeRetornos.getErroNaBusca());
			
		}
		if(isEmptyList(retornos)) {
			retornos.add(tiposDeRetornos.getItemNaoEncontradoBusca());
		}
		
		return(retornos);
	}
	
	public Retorno buscaValorProduto(Statement declaracaoConexao, String id) {
		double valorProduto = 0.0;
		String sql = "SELECT Valor FROM Produtos WHERE IdProduto = '"+id+"'";
		try {
			ResultSet resultadoDaBusca = declaracaoConexao.executeQuery(sql);
			while(resultadoDaBusca.next()) {
				valorProduto = resultadoDaBusca.getDouble("Valor");				
			}		
		} catch (SQLException e) {
			return tiposDeRetornos.retornaRetornoMaisValorProduto(tiposDeRetornos.getErroNaBusca(), 0.0);
		}
		
		return tiposDeRetornos.retornaRetornoMaisValorProduto(tiposDeRetornos.getSucessoNaBusca(), valorProduto);
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
	
	
	
	public Retorno listaItensTabela(Statement declaracaoConexao, String tabela) {
		String sql = "SELECT * FROM "+tabela;
		
		try {
			ResultSet resultadoDaBusca = declaracaoConexao.executeQuery(sql);
			return tiposDeRetornos.retornaRetornoMaisResultSet(tiposDeRetornos.getSucessoNaListagem(), resultadoDaBusca);
		} catch (SQLException e) {
			return tiposDeRetornos.retornaRetornoMaisResultSet(tiposDeRetornos.getErroNaListagem(), null);
		}
				
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
					+" WHERE "+campos.getNomeClausulaWhere()+"="+campos.getId();		
		
		try {
			declaracaoConexao.executeUpdate(sql);
		} catch (SQLException e) {
			
			return tiposDeRetornos.getErroNaAlteracao();
		}
		
		
		return tiposDeRetornos.getSucessoNaAlteracao();
	}
}
