package br.com.caelum.ingresso.controller;

import br.com.caelum.ingresso.dao.SalaDao;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.form.SalaForm;

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


    @GetMapping({"/admin/sala", "/admin/sala/{id}"})
    public ModelAndView form(@PathVariable("id") Optional<Integer> id, SalaForm salaForm) {
        ModelAndView modelAndView = new ModelAndView("sala/sala");
        if (id.isPresent()){
            Sala sala = salaDao.findOne(id.get());
            salaForm = new SalaForm(sala);
        }
        modelAndView.addObject("salaForm", salaForm);

        return modelAndView;
    }


    @PostMapping("/admin/sala")
    @Transactional
    public ModelAndView salva(@Valid SalaForm salaForm, BindingResult result) {
        Sala sala = salaForm.toSala();
        if (result.hasErrors()){
            return form(Optional.empty(), salaForm);
        }
        System.out.println(sala.getLugares().size());
        salaDao.save(sala);
        return new ModelAndView("redirect:/admin/salas");
    }

    @GetMapping("/admin/salas")
    public ModelAndView lista(){
        ModelAndView modelAndView = new ModelAndView("sala/lista");

        modelAndView.addObject("salas", salaDao.findAll());

        return modelAndView;
    }


    @GetMapping("/admin/sala/{id}/sessoes")
    public ModelAndView listaSessoes(@PathVariable("id") Integer id) {

        Sala sala = salaDao.findOne(id);

        ModelAndView view = new ModelAndView("sessao/lista");
        view.addObject("sala", sala);

        return view;
    }

    @GetMapping("/admin/sala/{id}/lugares/")
    public ModelAndView listaLugares(@PathVariable("id") Integer id) {

        ModelAndView modelAndView = new ModelAndView("lugar/lista");

        Sala sala = salaDao.findOne(id);
        modelAndView.addObject("sala", sala);

        return modelAndView;
    }


    @DeleteMapping("/admin/sala/{id}")
    @ResponseBody
    @Transactional
    public void delete(@PathVariable("id") Integer id){
        salaDao.delete(id);
    }
}
