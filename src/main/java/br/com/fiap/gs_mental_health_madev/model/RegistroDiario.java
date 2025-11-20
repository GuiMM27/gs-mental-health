package br.com.fiap.gs_mental_health_madev.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "TB_REGISTRO_DIARIO")
public class RegistroDiario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "A data do registro é obrigatória")
    private LocalDate dataRegistro;

    @Min(value = 1, message = "O humor deve ser no mínimo 1") // Validação min/max pedida
    @Max(value = 5, message = "O humor deve ser no máximo 5")
    private int nivelHumor;

    @Min(value = 1, message = "A ansiedade deve ser no mínimo 1")
    @Max(value = 5, message = "A ansiedade deve ser no máximo 5")
    private int nivelAnsiedade;

    @ManyToOne // Muitos registros para um paciente
    @JoinColumn(name = "paciente_id") // Nome da coluna no banco
    private Paciente paciente;
}