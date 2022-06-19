package com.traballhounid02.trabalho02.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import com.traballhounid02.trabalho02.models.Paciente;
import com.traballhounid02.trabalho02.services.PacienteService;

@Controller
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping(value = "/emergencias")
    public ModelAndView findEmergency() {
        ModelAndView mv = new ModelAndView("pacientes/index");
        List<Paciente> pacientes = this.pacienteService.findEmergency();
        mv.addObject("pacientes", pacientes);
        return mv;

    }


    @GetMapping(value = "/emergencias/{id}/delete")
    public String delete(@PathVariable Long id){
        this.pacienteService.deleteById(id);
        return "redirect:http://localhost:9000/EMERGENCIAS/emergencias";
    }
    

}
