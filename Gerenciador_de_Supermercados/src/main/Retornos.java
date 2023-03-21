package main;

import java.sql.ResultSet;

public class Retornos {
	private Retorno erroDeInsercao = new Retorno("Erro de inserção na tabela");
	private Retorno sucessoNaInsercao = new Retorno("Sucesso na insercao na tabela");
	private Retorno erroNaAlteracao = new Retorno("Erro na alteracao do item na tabela");
	private Retorno sucessoNaAlteracao = new Retorno("Sucesso na alteracao do item na tabela");
	private Retorno erroNaBusca = new Retorno("Erro na procura do item");
	private Retorno itemNaoEncontradoBusca = new Retorno("Erro na busca pelo item, item nao encontrado");
	private Retorno sucessoNaBusca = new Retorno("Sucesso na busca, Item encontrado");
	private Retorno erroNaDelecao = new Retorno("Erro na delecao do item");
	private Retorno sucessoNaDelecao = new Retorno("Sucesso na delecao do item");
	private Retorno erroNaListagem = new Retorno("Erro na listagem dos itens");
	private Retorno sucessoNaListagem = new Retorno("Sucesso na listagem dos itens");
	private Retorno compraFinalizadaSucesso = new Retorno("Compra finalizada com sucesso");
	private Retorno compraNaoFinalizadaErro = new Retorno("Compra nao finalizada, ERRO!");
	
	public Retorno retornaRetornoMaisProduto(Retorno retornoRecebido, Produto produto) {
		Retorno retornoEnviar = new Retorno(produto, retornoRecebido.getDescricaoRetorno());
		return retornoEnviar;
	}
	
	public Retorno retornaRetornoMaisCliente(Retorno retornoRecebido, Cliente cliente) {
		Retorno retornoEnviar = new Retorno(cliente, retornoRecebido.getDescricaoRetorno());
		return retornoEnviar;
	}
	
	public Retorno retornaRetornoMaisResultSet(Retorno retornoRecebido, ResultSet resultadoQuery) {
		Retorno retornoEnviar = new Retorno(resultadoQuery, retornoRecebido.getDescricaoRetorno());
		return retornoEnviar;
	}
	
	public Retorno retornaRetornoMaisValorProduto(Retorno retornoRecebido, double valorProduto) {
		Retorno retornoEnviar = new Retorno(valorProduto, retornoRecebido.getDescricaoRetorno());
		return retornoEnviar;
	}
	
	public Retorno retornaRetornoMaisValorCompra(Retorno retornoRecebido, double valorTotalCompra) {
		Retorno retornoEnviar = new Retorno(valorTotalCompra, retornoRecebido.getDescricaoRetorno());
		return retornoEnviar;
	}
	
	public Retorno getSucessoNaInsercao() {
		return sucessoNaInsercao;
	}

	public Retorno getErroDeInsercao() {
		return erroDeInsercao;
	}
	
	
	public Retorno getErroNaAlteracao() {
		return erroNaAlteracao;
	}

	public Retorno getSucessoNaAlteracao() {
		return sucessoNaAlteracao;
	}

	public Retorno getErroNaBusca() {
		return erroNaBusca;
	}

	public Retorno getSucessoNaBusca() {
		return sucessoNaBusca;
	}

	public Retorno getItemNaoEncontradoBusca() {
		return itemNaoEncontradoBusca;
	}

	public Retorno getErroNaDelecao() {
		return erroNaDelecao;
	}

	public Retorno getSucessoNaDelecao() {
		return sucessoNaDelecao;
	}

	public Retorno getErroNaListagem() {
		return erroNaListagem;
	}


	public Retorno getSucessoNaListagem() {
		return sucessoNaListagem;
	}

	public Retorno getCompraFinalizadaSucesso() {
		return compraFinalizadaSucesso;
	}

	public Retorno getCompraNaoFinalizadaErro() {
		return compraNaoFinalizadaErro;
	}

	

	
	
}
