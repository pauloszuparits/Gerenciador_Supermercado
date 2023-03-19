package main;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;

public class Cliente {
	public static Retornos tiposDeRetornos = new Retornos();
	
	private int idCliente;
	private String nome;
	private String sobrenome;
	private Date dtNasc;
	private String cpf;
	private Endereco endereco;
		
	
	public Cliente(String nome, String sobrenome, Date dtNasc, String cpf, Endereco endereco) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dtNasc = dtNasc;
		this.cpf = cpf;
		this.endereco = endereco;
	}
	
	
	
	public Cliente(int idCliente, String nome, String sobrenome, Date dtNasc, String cpf, Endereco endereco) {
		this.setIdCliente(idCliente);
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dtNasc = dtNasc;
		this.cpf = cpf;
		this.endereco = endereco;
	}



	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public Date getDtNasc() {
		return dtNasc;
	}
	public void setDtNasc(Date dtNasc) {
		this.dtNasc = dtNasc;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public int getIdCliente() {
		return idCliente;
	}



	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	public Retorno InsereCliente(Statement declaracaoConexao) {
		String sql = "INSERT INTO Cliente(Nome, Sobrenome, DtNasc, cpf, Cep, Numero, Complemento)" +
					 " VALUES('"+this.nome+"','"+this.sobrenome+"','"+this.dtNasc+"','"+this.cpf+"','"+
					 this.endereco.getCep()+"','"+this.endereco.getNumero()+"','"+this.endereco.getComplemento()+"')";
				
		
			try {
				declaracaoConexao.executeUpdate(sql);
			} catch (SQLException e) {
				return tiposDeRetornos.getErroDeInsercao();
			}
		
	
		return tiposDeRetornos.getSucessoNaInsercao();
	}
	
}
