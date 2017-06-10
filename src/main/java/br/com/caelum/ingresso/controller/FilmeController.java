package br.com.caelum.ingresso.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.ingresso.dao.FilmeDao;
import br.com.caelum.ingresso.dao.SessaoDao;
import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Sessao;

/**
 * Created by nando on 03/03/17.
 */
@Controller
public class FilmeController {

	@Autowired
	private FilmeDao filmeDao;
	@Autowired
	private SessaoDao sessaoDao;

	@GetMapping({ "/filme", "/filme/{id}" })
	public ModelAndView form(@PathVariable("id") Optional<Integer> id, Filme filme) {

		ModelAndView modelAndView = new ModelAndView("filme/filme");

		if (id.isPresent()) {
			filme = filmeDao.findOne(id.get());
		}

		modelAndView.addObject("filme", filme);

		return modelAndView;
	}

	@PostMapping("/filme")
	@Transactional
	public ModelAndView salva(@Valid Filme filme, BindingResult result) {

		if (result.hasErrors()) {
			return form(Optional.ofNullable(filme.getId()), filme);
		}

		filmeDao.save(filme);

		ModelAndView view = new ModelAndView("redirect:/filmes");

		return view;
	}

	@GetMapping(value = "/filmes")
	public ModelAndView lista() {

		ModelAndView modelAndView = new ModelAndView("filme/lista");

		modelAndView.addObject("filmes", filmeDao.findAll());

		return modelAndView;
	}

	@DeleteMapping("/filme/{id}")
	@ResponseBody
	@Transactional
	public void delete(@PathVariable("id") Integer id) {
		filmeDao.delete(id);
	}

	@GetMapping("/filme/em-cartaz")
	public ModelAndView emCartaz() {
		ModelAndView modelAndView = new ModelAndView("filme/em-cartaz");
		modelAndView.addObject("filmes", filmeDao.findAll());
		return modelAndView;
	}

	@GetMapping("/filme/{id}/detalhe")
	public ModelAndView detalhes(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("/filme/detalhe");
		Filme filme = filmeDao.findOne(id);
		List<Sessao> sessoes = sessaoDao.buscaSessoesDoFilme(filme);
		modelAndView.addObject("sessoes", sessoes);
		return modelAndView;
	}

}
