package br.com.fiap.gs_mental_health_madev.dto;

import java.time.LocalDate;

public record RegistroDiarioResponseDTO(
    Long id,
    LocalDate dataRegistro,
    int nivelHumor,
    int nivelAnsiedade,
    String nomePaciente // Vamos devolver o nome do paciente para facilitar a leitura
) {}