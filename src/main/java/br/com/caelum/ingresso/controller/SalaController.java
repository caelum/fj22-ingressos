package br.com.caelum.ingresso.controller;

import br.com.caelum.ingresso.dao.SalaDao;
import br.com.caelum.ingresso.dao.SessaoDao;
import br.com.caelum.ingresso.model.Sala;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

/**
 * Created by nando on 03/03/17.
 */
@Controller
public class SalaController {

    @Autowired
    private SalaDao salaDao;

    @Autowired
    private SessaoDao sessaoDao;


    @GetMapping({"/sala", "/sala/{id}"})
    public ModelAndView form(@PathVariable("id")Optional<Integer> id, Sala sala){
        ModelAndView modelAndView = new ModelAndView("sala/sala");

        if (id.isPresent()){
            sala = salaDao.findOne(id.get());
        }

        modelAndView.addObject("sala", sala);

        return modelAndView;
    }




    @PostMapping("/sala")
    @Transactional
    public ModelAndView salva(@Valid Sala sala, BindingResult result){

        if (result.hasErrors()){
            return form(Optional.ofNullable(sala.getId()) ,sala);
        }

        salaDao.save(sala);
        return new ModelAndView("redirect:/salas");
    }

    @GetMapping("/salas")
    public ModelAndView lista(){
        ModelAndView modelAndView = new ModelAndView("sala/lista");

        modelAndView.addObject("salas", salaDao.findAll());

        return modelAndView;
    }


    @GetMapping("/sala/{id}/sessoes")
    public ModelAndView listaSessoes(@PathVariable("id") Integer id) {

        Sala sala = salaDao.findOne(id);

        ModelAndView view = new ModelAndView("sessao/lista");
        view.addObject("sala", sala);
        view.addObject("sessoes", sessaoDao.buscaSessoesDaSala(sala));

        return view;
    }

    @GetMapping("/sala/{id}/lugares/")
    public ModelAndView listaLugares(@PathVariable("id") Integer id) {

        ModelAndView modelAndView = new ModelAndView("lugar/lista");

        Sala sala = salaDao.findOne(id);
        modelAndView.addObject("sala", sala);

        return modelAndView;
    }


    @DeleteMapping("/sala/{id}")
    @ResponseBody
    @Transactional
    public void delete(@PathVariable("id") Integer id){
        salaDao.delete(id);
    }
}
