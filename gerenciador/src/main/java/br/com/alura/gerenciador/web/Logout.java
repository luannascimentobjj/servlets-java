package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.alura.gerenciador.web.Cookies;

@WebServlet(urlPatterns = "/logout")
public class Logout extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		req.getSession().removeAttribute("usuario.logado");
		writer.println("<html><body>Deslogado com sucesso!</html></body>");
	}

}
