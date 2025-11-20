package br.com.fiap.gs_mental_health_madev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.gs_mental_health_madev.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    // Só isso! O Spring já faz o resto.
}