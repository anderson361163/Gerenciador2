package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class NovaEmpresa {
	
	public void executa
			(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("Empresa cadastrada com sucesso!");
		
		String nome = request.getParameter("nome");
		String paraDataEmpresa = request.getParameter("data");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		//Não da para usar o throws porque não da para mudar a assinatura de um método sobreescrito
		Date dataAbertura = null;
		try {
			dataAbertura = sdf.parse(paraDataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		
		Empresa empresa = new Empresa();
		empresa.setNome(nome);
		empresa.setDataAbertura(dataAbertura);
		
		Banco banco = new Banco();
		banco.adicionar(empresa);
		
		request.setAttribute("empresa", empresa.getNome());
		
		response.sendRedirect("entrada?acao=ListaEmpresas");
		
	}
}
