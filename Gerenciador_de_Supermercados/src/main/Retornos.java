package main;

public class Retornos {
	private Retorno erroDeInsercao = new Retorno("Erro de inserção na tabela");
	private Retorno sucessoNaInsercao = new Retorno("Sucesso na insercao na tabela");
	
	
	public Retorno getSucessoNaInsercao() {
		return sucessoNaInsercao;
	}

	public Retorno getErroDeInsercao() {
		return erroDeInsercao;
	}
	
}
