package br.com.fiap.gs_mental_health_madev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.gs_mental_health_madev.model.RegistroDiario;

public interface RegistroDiarioRepository extends JpaRepository<RegistroDiario, Long> {
}