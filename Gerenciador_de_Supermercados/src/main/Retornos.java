package main;

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
	
	public Retorno retornaRetornoMaisProduto(Retorno retornoRecebido, Produto produto) {
		Retorno retornoEnviar = new Retorno(produto, retornoRecebido.getDescricaoRetorno());
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

	

	
	
}
