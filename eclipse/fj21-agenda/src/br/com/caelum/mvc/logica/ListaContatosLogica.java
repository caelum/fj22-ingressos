package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

public class ListaContatosLogica implements Logica {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		
		
		Connection connection = (Connection) request.getAttribute("conexao");
		
		
		List<Contato> contatos = new ContatoDao(connection).getLista();
		
		request.setAttribute("contatos", contatos);
		
		return "lista-contatos.jsp";
	}
}