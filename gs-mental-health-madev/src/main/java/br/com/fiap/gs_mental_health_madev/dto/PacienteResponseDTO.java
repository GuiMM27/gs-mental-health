package br.com.fiap.gs_mental_health_madev.dto;

import java.time.LocalDate;

public record PacienteResponseDTO(
    Long id,
    String nome,
    String email,
    LocalDate dataNascimento
) {}