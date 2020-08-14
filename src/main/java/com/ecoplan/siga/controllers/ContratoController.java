package com.ecoplan.siga.controllers;

import com.ecoplan.siga.model.Contrato;
import com.ecoplan.siga.repository.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContratoController {

    @Autowired(required = true)
    private ContratoRepository cr;

    @RequestMapping(value="/cadastrarContrato", method = RequestMethod.GET)
    public ModelAndView form() {
        ModelAndView mv = new ModelAndView("formulario");
        Iterable<Contrato> contratos = cr.findAll();
        mv.addObject("contratos", contratos);
        return mv;
    }

    @RequestMapping(value="/cadastrarContrato", method = RequestMethod.POST)
    public String form(Contrato contrato) {
        cr.save(contrato);
        return "redirect:/cadastrarContrato";
    }

    @RequestMapping(value="/deletarContrato")
    public String deletarContrato(long id) {
        Contrato contrato = cr.findById(id);
        cr.delete(contrato);
        return "redirect:/cadastrarContrato";
    }


}

