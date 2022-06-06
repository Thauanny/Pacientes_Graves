package com.traballhounid02.trabalho02.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.stereotype.Service;
import com.traballhounid02.trabalho02.models.Paciente;
import com.traballhounid02.trabalho02.repositories.PacienteRepository;
import reactor.core.publisher.Flux;

@Service
public class PacienteService {
    
    @Autowired
    private PacienteRepository pacienteRepository;


   
    public Flux<Paciente> findEmergency(){
        return this.pacienteRepository.findEmergency();
    } 

    public void deleteById(Long id){
        this.pacienteRepository.deleteById(id).subscribe();

    }
    
     
}
