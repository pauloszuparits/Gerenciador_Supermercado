package main;

import java.sql.SQLException;
import java.sql.Statement;

public class Produto {
	public static Retornos tiposDeRetornos = new Retornos();
	
	private int idProduto;
	private String nome;
	private double peso;
	private double valor;
	
	public Produto(String nome, double peso, double valor) {
		
		this.nome = nome;
		this.peso = peso;
		this.valor = valor;
	}
	
	public Produto(int idProduto,String nome, double peso, double valor) {
		this.idProduto = idProduto;
		this.nome = nome;
		this.peso = peso;
		this.valor = valor;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	
	
	public Retorno InsereProduto(Statement declaracaoConexao) {
		String sql = "INSERT INTO Produtos(Nome, Peso, Valor)" +
					 " VALUES('"+this.nome+"','"+this.peso+"','"+this.valor+"')";
				
			try {
				declaracaoConexao.executeUpdate(sql);
			} catch (SQLException e) {
				return tiposDeRetornos.getErroDeInsercao();
			}
	
		return tiposDeRetornos.getSucessoNaInsercao();
	}

	@Override
	public String toString() {
		return "Produto [idProduto=" + idProduto + ", nome=" + nome + ", peso=" + peso + ", valor=" + valor + "]";
	}

	
	
}
