package main;
import java.sql.*;
import java.util.ArrayList;
public class main {
	
	public static void main(String[] args) throws SQLException {
		Funcoes funcao = new Funcoes();
		Conexao conexaoComMysql = new Conexao();
		Statement declaracaoConexao = conexaoComMysql.getConection().createStatement();
		
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

}
