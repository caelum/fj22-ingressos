package br.com.caelum.ingresso.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.ingresso.dao.CompraDao;
import br.com.caelum.ingresso.dao.LugarDao;
import br.com.caelum.ingresso.dao.SessaoDao;
import br.com.caelum.ingresso.model.Carrinho;
import br.com.caelum.ingresso.model.Cartao;
import br.com.caelum.ingresso.model.form.CarrinhoForm;

@Controller
public class CompraController {

	@Autowired
	private SessaoDao sessaoDao;
	@Autowired
	private LugarDao lugarDao;
	@Autowired
	private CompraDao compraDao;
	@Autowired
	private Carrinho carrinho;


	@PostMapping("/compra/ingressos")
	public ModelAndView enviarParaPagamento(CarrinhoForm carrinhoForm) {
		ModelAndView modelAndView = new ModelAndView("redirect:/compra");

		// System.out.println("checkpoint 1");

		carrinhoForm.toIngressos(sessaoDao, lugarDao).forEach(carrinho::add);

		return modelAndView;
	}

	@GetMapping("/compra")
	public ModelAndView checkout(Cartao cartao) {

		ModelAndView modelAndView = new ModelAndView("compra/pagamento");

		modelAndView.addObject("carrinho", carrinho);
		return modelAndView;
	}

	@PostMapping("/compra/comprar")
	@Transactional
	public ModelAndView comprar(@Valid Cartao cartao, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("redirect:/");
		if (cartao.isValido()) {
			compraDao.save(carrinho.toCompra());
		} else {
			result.rejectValue("vencimento", "Vencimento inválido");
			return checkout(cartao);
		}
		carrinho.clear();
		return modelAndView;
	}

}
