package br.com.fiap.gs_mental_health_madev.service;

import br.com.fiap.gs_mental_health_madev.dto.*;
import br.com.fiap.gs_mental_health_madev.model.Paciente;
import br.com.fiap.gs_mental_health_madev.repository.PacienteRepository;
import br.com.fiap.gs_mental_health_madev.exception.RecursoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    // LISTAR TODOS
    public List<PacienteResponseDTO> listarTodos() {
        List<Paciente> pacientes = repository.findAll();
        // Converte lista de Entidade para lista de DTO
        return pacientes.stream()
                .map(p -> new PacienteResponseDTO(p.getId(), p.getNome(), p.getEmail(), p.getDataNascimento()))
                .collect(Collectors.toList());
    }

    // BUSCAR POR ID
    public PacienteResponseDTO buscarPorId(Long id) {
        Paciente p = repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Paciente não encontrado com ID: " + id));
        
        return new PacienteResponseDTO(p.getId(), p.getNome(), p.getEmail(), p.getDataNascimento());
    }

    // CADASTRAR
    public PacienteResponseDTO cadastrar(PacienteRequestDTO dto) {
        Paciente p = new Paciente();
        p.setNome(dto.nome());
        p.setEmail(dto.email());
        p.setDataNascimento(dto.dataNascimento());

        Paciente salvo = repository.save(p);
        return new PacienteResponseDTO(salvo.getId(), salvo.getNome(), salvo.getEmail(), salvo.getDataNascimento());
    }

    // ATUALIZAR
    public PacienteResponseDTO atualizar(Long id, PacienteRequestDTO dto) {
        Paciente p = repository.findById(id)
            .orElseThrow(() -> new RecursoNaoEncontradoException("Paciente não encontrado com ID: " + id));

        p.setNome(dto.nome());
        p.setEmail(dto.email());
        p.setDataNascimento(dto.dataNascimento());

        Paciente salvo = repository.save(p);
        return new PacienteResponseDTO(salvo.getId(), salvo.getNome(), salvo.getEmail(), salvo.getDataNascimento());
    }

    // DELETAR
    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Paciente não encontrado para exclusão");
        }
        repository.deleteById(id);
    }
}