package com.traballhounid02.trabalho02.repositories;


import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.traballhounid02.trabalho02.models.Paciente;

import reactor.core.publisher.Flux;

@Repository

public interface PacienteRepository extends ReactiveCrudRepository<Paciente, Long> {

    @Query("Select * from paciente where paciente.situation = \"Emergencia\" OR paciente.situation = \"Urgente\" OR paciente.situation = \"Muito Urgente\"")
    public Flux<Paciente> findEmergency();
}
