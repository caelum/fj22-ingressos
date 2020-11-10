package br.com.caelum.jdbc.teste;

import java.util.List;
import br.com.caelum.jdbc.Contato;
import br.com.caelum.jdbc.dao.ContatoDao;

public class TestaLista {

	public static void main(String[] args) {

		ContatoDao dao = new ContatoDao();

		List<Contato> contatos = dao.getLista();

		for (Contato contato : contatos) {
			System.out.println("Nome:	" + contato.getNome());
			System.out.println("Email:	" + contato.getEmail());
			System.out.println("Endereço:	" + contato.getEndereco());
			System.out.println("Data	de	Nascimento:	" + contato.getDataNascimento().getTime() + "\n");
		}
	}

}
