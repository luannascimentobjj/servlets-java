package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import br.com.alura.gerenciador.web.Cookies;


@WebFilter(urlPatterns = "/*")
public class FiltroDeAuditoria implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();
		String usuario = getUsuario(req);
		System.out.println("Usuário " + usuario + " acessando a URI " + uri);
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

	private String getUsuario(HttpServletRequest req) {

		Cookie cookie = new Cookies(req.getCookies()).buscaUsuarioLogado();
		if(cookie==null) return "<deslogado>";
		return cookie.getValue();
	}

}