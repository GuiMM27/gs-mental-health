package br.com.fiap.gs_mental_health_madev.service;

import br.com.fiap.gs_mental_health_madev.dto.*;
import br.com.fiap.gs_mental_health_madev.model.Paciente;
import br.com.fiap.gs_mental_health_madev.model.RegistroDiario;
import br.com.fiap.gs_mental_health_madev.repository.PacienteRepository;
import br.com.fiap.gs_mental_health_madev.repository.RegistroDiarioRepository;
import br.com.fiap.gs_mental_health_madev.exception.RecursoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistroDiarioService {

    @Autowired
    private RegistroDiarioRepository registroRepository;

    @Autowired
    private PacienteRepository pacienteRepository; // Precisamos disso para buscar o paciente

    // LISTAR TODOS
    public List<RegistroDiarioResponseDTO> listarTodos() {
        return registroRepository.findAll().stream()
            .map(r -> new RegistroDiarioResponseDTO(
                r.getId(), 
                r.getDataRegistro(), 
                r.getNivelHumor(), 
                r.getNivelAnsiedade(),
                r.getPaciente().getNome() // Pega o nome do paciente associado
            ))
            .collect(Collectors.toList());
    }

    // BUSCAR POR ID
    public RegistroDiarioResponseDTO buscarPorId(Long id) {
        RegistroDiario r = registroRepository.findById(id)
            .orElseThrow(() -> new RecursoNaoEncontradoException("Registro não encontrado"));
        
        return new RegistroDiarioResponseDTO(r.getId(), r.getDataRegistro(), r.getNivelHumor(), r.getNivelAnsiedade(), r.getPaciente().getNome());
    }

    // CADASTRAR
    public RegistroDiarioResponseDTO cadastrar(RegistroDiarioRequestDTO dto) {
        // Valida se o paciente existe
        Paciente paciente = pacienteRepository.findById(dto.pacienteId())
            .orElseThrow(() -> new RecursoNaoEncontradoException("Paciente não encontrado com ID: " + dto.pacienteId()));

        RegistroDiario registro = new RegistroDiario();
        registro.setDataRegistro(dto.dataRegistro());
        registro.setNivelHumor(dto.nivelHumor());
        registro.setNivelAnsiedade(dto.nivelAnsiedade());
        registro.setPaciente(paciente); // Vincula o paciente

        RegistroDiario salvo = registroRepository.save(registro);
        return new RegistroDiarioResponseDTO(salvo.getId(), salvo.getDataRegistro(), salvo.getNivelHumor(), salvo.getNivelAnsiedade(), paciente.getNome());
    }

    // DELETAR
    public void deletar(Long id) {
        if (!registroRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Registro não encontrado");
        }
        registroRepository.deleteById(id);
    }
}