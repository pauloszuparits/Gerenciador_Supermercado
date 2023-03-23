package main;


import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FuncoesParaModulosAdministracao {
	public Retorno cadastrarCliente(Statement declaracaoConexao) throws ParseException {
		Scanner entradaDados = new Scanner(System.in);
		System.out.println("Digite o nome do cliente");
		String nomeCliente = entradaDados.next();
		System.out.println("Digite o sobrenome do cliente");
		String sobrenomeCliente = entradaDados.next();
		System.out.println("Digite a data de nascimento do cliente dd/MM/yyyy");
		String dtNascCliente = entradaDados.next();
		System.out.println("Digite o cpf do cliente");
		String cpfCliente = entradaDados.next();
		System.out.println("Digite o CEP do endereco do cliente");
		String cepEnderecoCliente = entradaDados.next();
		System.out.println("Digite o numero do endereco do cliente");
		int numeroEnderecoCliente = entradaDados.nextInt();
		System.out.println("Digite o complemento do endereco do cliente");
		String complementoEnderecoCliente = entradaDados.next();
		
		Endereco enderecoCliente = new Endereco(cepEnderecoCliente, numeroEnderecoCliente, complementoEnderecoCliente);
		
		Cliente cliente = new Cliente(nomeCliente, sobrenomeCliente, converteStringemData(dtNascCliente),cpfCliente, enderecoCliente);
		entradaDados.close();
		return cliente.InsereCliente(declaracaoConexao);
	}
	
	public Retorno alterarCliente(Statement declaracaoConexao) {
		FuncoesParaClasses funcao = new FuncoesParaClasses();
		Scanner entradaDados = new Scanner(System.in);
		System.out.println("Digite o id do cliente");
		int idCliente = entradaDados.nextInt();
		System.out.println("Digite o campo que será alterado");
		String campoAlterar = entradaDados.next();
		System.out.println("Digite o novo valor para o campo");
		String novoValorCampo = entradaDados.next();
		
		CamposAlteracao camposAlterar = new CamposAlteracao("IdCliente", "Cliente", idCliente, campoAlterar, novoValorCampo);
		
		entradaDados.close();
		return funcao.alteraItemTabela(declaracaoConexao, camposAlterar);
	}
	
	public Date converteStringemData(String dateString) throws ParseException {
		SimpleDateFormat formatadorDeDatas = new SimpleDateFormat("dd/MM/yyyy");
		Date data = formatadorDeDatas.parse(dateString);
		return data;
	}
}
