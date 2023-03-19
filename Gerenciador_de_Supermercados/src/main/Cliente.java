package main;

import java.sql.Date;

public class Cliente {
	private String nome;
	private String sobrenome;
	private Date DtNasc;
	private String cpf;
	
	
	
	public Cliente(String nome, String sobrenome, Date dtNasc, String cpf) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		DtNasc = dtNasc;
		this.cpf = cpf;
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
		return DtNasc;
	}
	public void setDtNasc(Date dtNasc) {
		DtNasc = dtNasc;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
}
