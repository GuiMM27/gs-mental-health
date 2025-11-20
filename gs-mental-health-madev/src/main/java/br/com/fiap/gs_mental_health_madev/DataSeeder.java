package br.com.fiap.gs_mental_health_madev;

import br.com.fiap.gs_mental_health_madev.model.Paciente;
import br.com.fiap.gs_mental_health_madev.model.RegistroDiario;
import br.com.fiap.gs_mental_health_madev.repository.PacienteRepository;
import br.com.fiap.gs_mental_health_madev.repository.RegistroDiarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private RegistroDiarioRepository registroRepository;

    @Override
    public void run(String... args) throws Exception {
        // Só cadastra se o banco estiver vazio
        if (pacienteRepository.count() == 0) {
            Paciente p1 = new Paciente();
            p1.setNome("João Silva");
            p1.setEmail("joao@email.com");
            p1.setDataNascimento(LocalDate.of(1990, 5, 20));
            
            Paciente p2 = new Paciente();
            p2.setNome("Maria Oliveira");
            p2.setEmail("maria@email.com");
            p2.setDataNascimento(LocalDate.of(1985, 10, 15));
            
            pacienteRepository.saveAll(List.of(p1, p2));

            RegistroDiario r1 = new RegistroDiario();
            r1.setPaciente(p1);
            r1.setDataRegistro(LocalDate.now());
            r1.setNivelHumor(4); // 1 a 5
            r1.setNivelAnsiedade(2); // 1 a 5
            
            registroRepository.save(r1);
            
            System.out.println("✅ Seeds carregados com sucesso!");
        }
    }
}