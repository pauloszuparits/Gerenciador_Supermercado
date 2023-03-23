package main;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class FuncoesModuloCompra {
	public ArrayList <Retorno> listarComprasCliente(Statement declaracaoConexao){
		ArrayList<Retorno> retornos = new ArrayList<Retorno>();
		Retornos tiposDeRetornos = new Retornos();
		Scanner entradaDados = new Scanner(System.in);
		System.out.println("Digite o cpf do cliente");
		String cpf = entradaDados.next();
		
		String sql = "SELECT CLI.IdCliente,CLI.NOME, CLI.SOBRENOME,CLI.DtNasc, COMP.Valor, COMP.DtCompra\n"
				+ "FROM Cliente CLI\n"
				+ "INNER JOIN Compras COMP ON CLI.IdCliente = COMP.IdCliente\n"
				+ "WHERE CLI.cpf = '"+cpf+"'";
		try {
			ResultSet resultadoListagem = declaracaoConexao.executeQuery(sql);
			while(resultadoListagem.next()) {
				int idCliente = resultadoListagem.getInt("IdCliente");
				String nomeCliente = resultadoListagem.getString("Nome");
				String sobrenomeCliente = resultadoListagem.getString("Sobrenome");
				Date dtNasc = resultadoListagem.getDate("DtNasc");
				double valorCompra = resultadoListagem.getDouble("Valor");
				Date dtCompra = resultadoListagem.getDate("DtCompra");
				
				Compra compra = new Compra(idCliente, valorCompra, dtCompra);
				Cliente cliente = new Cliente(nomeCliente, sobrenomeCliente, dtNasc, compra);
				
				retornos.add(tiposDeRetornos.retornaRetornoMaisCliente(tiposDeRetornos.getSucessoNaListagem(), cliente));
				
			}
		} catch (SQLException e) {
			retornos.add(tiposDeRetornos.getErroNaListagem());
		}
		
		return retornos;
	}
}
