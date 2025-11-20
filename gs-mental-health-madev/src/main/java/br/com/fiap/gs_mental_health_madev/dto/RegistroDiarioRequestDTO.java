package br.com.fiap.gs_mental_health_madev.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public record RegistroDiarioRequestDTO(
    @NotNull LocalDate dataRegistro,
    @Min(1) @Max(5) int nivelHumor,
    @Min(1) @Max(5) int nivelAnsiedade,
    @NotNull Long pacienteId // Recebemos apenas o ID para vincular
) {}