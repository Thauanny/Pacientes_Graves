package com.traballhounid02.trabalho02.config;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.traballhounid02.trabalho02.models.Paciente;
import java.util.function.Consumer;

@Configuration
public class KafkaConsumer {

  @Bean
  public Consumer<KStream<String, Paciente>> emergenciaService() {
    return kstream -> kstream.foreach((key, paciente) -> {
      System.out.println(String.format("paciente consumed[%s] Status[%s]", paciente.getName(), paciente
      .getSymptoms()));
    });
  }
}
