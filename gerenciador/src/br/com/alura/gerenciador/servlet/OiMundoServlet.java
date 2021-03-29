package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * O comando comentado abaixo serve para criar a mesma instancia varias vezes
 */
//@WebServlet(urlPatterns="/oi", loadOnStartup=1)
//@WebServlet(urlPatterns = "/oi")
public class OiMundoServlet extends HttpServlet{
	
	@Override
	protected void service
		(HttpServletRequest req,
		HttpServletResponse resp) throws IOException {
		
		//tem duas formas de devolver os dados em formato bin�rio e caracteres
		//resp.getOutputStream();
		
		//Com o m�todo response, a primeira coisa feita � definir qual vai ser a forma de retorno
		//no caso ela ser� caracteres
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("Parab�ns, voc� escreveu o primeiro servlets!");
		out.println("</body>");
		out.println("</html>");
		
	}
	
}
