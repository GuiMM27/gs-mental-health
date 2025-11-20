package br.com.fiap.gs_mental_health_madev.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public record PacienteRequestDTO(
    @NotBlank(message = "O nome é obrigatório")
    String nome,

    @Email(message = "Email inválido")
    String email,

    @Past(message = "Data de nascimento inválida")
    LocalDate dataNascimento
) {}