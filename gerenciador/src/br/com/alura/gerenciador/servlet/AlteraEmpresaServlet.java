package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;


//@WebServlet("/alteraEmpresa")
public class AlteraEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomeEmpresa = request.getParameter("nome");
		String paraDataEmpresa = request.getParameter("data");
		String paramId = request.getParameter("id");
		
		Integer id = Integer.valueOf(paramId);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		/*Não da para usar o throws porque não da para mudar 
		 * a assinatura de um método sobreescrito
		 */
		Date dataAbertura = null;
		try {
			dataAbertura = sdf.parse(paraDataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Banco banco = new Banco();
		
		Empresa empresa = banco.buscaEmpresaPeloId(id);
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);

		response.sendRedirect("listaEmpresas");
	}

}
