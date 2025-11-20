package br.com.fiap.gs_mental_health_madev.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data; // Se estiver usando Lombok
import java.time.LocalDate;

@Data // Faz os Getters e Setters automáticos (se não tiver Lombok, apague e crie na mão)
@Entity
@Table(name = "TB_PACIENTE")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório") // Validação pedida no PDF
    private String nome;

    @Email(message = "O e-mail deve ser válido") // Validação de formato
    private String email;

    @Past(message = "A data de nascimento deve ser no passado") // Validação de data
    private LocalDate dataNascimento;
}