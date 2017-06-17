package br.com.caelum.ingresso.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import br.com.caelum.ingresso.dao.LoginDao;
import br.com.caelum.ingresso.dao.PermissaoDao;
import br.com.caelum.ingresso.model.Permissao;
import br.com.caelum.ingresso.model.Usuario;

@RestController
public class MagicController {

	@Autowired
	private PermissaoDao permissaoDao;
	@Autowired
	private LoginDao usuarioDao;

	@GetMapping(value = "/magic/xpto")
	@Transactional
	public ModelAndView salvaTudo(@RequestParam("email") String email) {

		String password = new BCryptPasswordEncoder().encode("1234");

		Set<Permissao> permissoes = new HashSet<>();

		Permissao admin = new Permissao();
		admin.setNome("ROLE_ADMIN");

		Permissao comprador = new Permissao();
		comprador.setNome("ROLE_COMPRADOR");

		permissoes.add(admin);
		permissoes.add(comprador);

		permissaoDao.save(admin);
		permissaoDao.save(comprador);

		Usuario usuario = new Usuario(email, password, permissoes);
		usuarioDao.save(usuario);

		ModelAndView modelAndView = new ModelAndView("redirect:/");
		return modelAndView;
	}

}
