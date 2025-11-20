package br.com.fiap.gs_mental_health_madev.controller;

import br.com.fiap.gs_mental_health_madev.dto.RegistroDiarioRequestDTO;
import br.com.fiap.gs_mental_health_madev.dto.RegistroDiarioResponseDTO;
import br.com.fiap.gs_mental_health_madev.service.RegistroDiarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/registros")
public class RegistroDiarioController {

    @Autowired
    private RegistroDiarioService service;

    @GetMapping
    public ResponseEntity<List<RegistroDiarioResponseDTO>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistroDiarioResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<RegistroDiarioResponseDTO> cadastrar(@Valid @RequestBody RegistroDiarioRequestDTO dto) {
        RegistroDiarioResponseDTO salvo = service.cadastrar(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(salvo.id()).toUri();
        return ResponseEntity.created(uri).body(salvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}