package br.com.caelum.jdbc.teste;

import java.util.Calendar;

import br.com.caelum.jdbc.Contato;
import br.com.caelum.jdbc.dao.ContatoDao;

public class TestaRemove {
	public static void main(String[] args) {
		
		// pronto para remover
		Contato contato = new Contato();
		contato.setId(2L);
		contato.setNome("Caelum");
		contato.setEmail("contato@caelum.com.br");
		contato.setEndereco("R.	Vergueiro	3185	cj57");
		contato.setDataNascimento(Calendar.getInstance());

		// remova nessa conexão!!!
		ContatoDao dao = new ContatoDao();

		// método elegante
		dao.remove(contato);
		System.out.println("Removido!");
	}

}
