package com.traballhounid02.trabalho02.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traballhounid02.trabalho02.models.Paciente;
import com.traballhounid02.trabalho02.repositories.PacienteRepository;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private EntityManager entityManager;


    public List<Paciente> findAll(){
        Query result = entityManager.createNativeQuery("Select * from paciente where paciente.situation = \"Emergencia\" OR paciente.situation = \"Urgente\" OR paciente.situation = \"Muito Urgente\"", Paciente.class);
       
        @SuppressWarnings("unchecked")
        List<Paciente> items = (List<Paciente>) result.getResultList();
        return items;

    } 

    public void deleteById(Long id){
        this.pacienteRepository.deleteById(id);

    }
     
}
