package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;


//@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	
	protected void doPost
			(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		
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
		
//		PrintWriter out = response.getWriter();
//		
//		out.println("<html><body>Empresa " + nome + " cadastrada com sucesso!");
//		out.close();
		
		request.setAttribute("empresa", empresa.getNome());
		
		//o status do protocolo fica 305 (que é o de redirecionamento)
		response.sendRedirect("listaEmpresas");
//		RequestDispatcher rd = request.getRequestDispatcher("/nomeEmpresaCriada.jsp");
//		//SERIA AS VARIAVEIS PARA SEREM ACESSADAS NO JSP
//		request.setAttribute("empresa", empresa.getNome());
//		rd.forward(request, response);
//		
	}
	
//	protected void doPost
//			  (HttpServletRequest request,
//			   HttpServletResponse response) throws IOException{
//		
//		System.out.println("Empresa cadastrada com sucesso!");
//	
//		String nome = request.getParameter("nome");
//		
//		Empresa empresa = new Empresa();
//		empresa.setNome(nome);
//		
//		Banco banco = new Banco();
//		banco.adicionar(empresa);
//		
//		PrintWriter out = response.getWriter();
//		
//		out.println("<html><body>Empresa " + nome +" cadastrada com sucesso!"); //Nome: "+productId+" Desconto: "+discount+"</body></html>");
//		out.close();
//	}

}
