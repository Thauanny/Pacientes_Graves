package com.traballhounid02.trabalho02.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.thymeleaf.spring5.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;
import com.traballhounid02.trabalho02.services.PacienteService;



@Controller
public class PacienteController {

    @Autowired  
    private PacienteService pacienteService;

    @GetMapping(path  = "/emergencias")
    public String findEmergency(final Model model) {

        IReactiveDataDriverContextVariable reactiveDataDrivenMode =
            new ReactiveDataDriverContextVariable( this.pacienteService.findEmergency());
  
        model.addAttribute("pacientes", reactiveDataDrivenMode);

        return "pacientes/index";
    }

    @GetMapping(value = "/emergencias/{id}/delete")
    public String delete(@PathVariable Long id){
        this.pacienteService.deleteById(id);
        return "redirect:/emergencias";
    }


}
