package com.locadora.controller;

import com.locadora.model.Manutencao;
import com.locadora.service.ManutencaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/manutencoes")
public class ManutencaoController {

    // Serviço que contém as regras de manutenção
    private final ManutencaoService service;

    public ManutencaoController(ManutencaoService service) {
        this.service = service;
    }

    // Registra uma nova manutenção
    @PostMapping
    public ResponseEntity<Manutencao> registrar(@RequestBody Manutencao m) {
        return ResponseEntity.status(201).body(service.registrar(m));
    }

    // Marca uma manutenção como concluída
    @PutMapping("/{id}/concluir")
    public ResponseEntity<Manutencao> concluir(@PathVariable UUID id) {
        return ResponseEntity.ok(service.concluir(id));
    }

    // Retorna o histórico de manutenções de um veículo
    @GetMapping("/veiculo/{veiculoId}")
    public ResponseEntity<List<Manutencao>> historico(@PathVariable UUID veiculoId) {
        return ResponseEntity.ok(service.historico(veiculoId));
    }
}
