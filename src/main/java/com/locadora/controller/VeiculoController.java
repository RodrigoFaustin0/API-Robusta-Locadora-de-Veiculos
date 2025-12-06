package com.locadora.controller;

import com.locadora.model.Veiculo;
import com.locadora.service.VeiculoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/veiculos")
public class VeiculoController {

    // Serviço que contém a lógica de veículos
    private final VeiculoService service;

    public VeiculoController(VeiculoService service) {
        this.service = service;
    }

    // Retorna todos os veículos cadastrados
    @GetMapping
    public ResponseEntity<List<Veiculo>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    // Retorna somente os veículos disponíveis para locação
    @GetMapping("/disponiveis")
    public ResponseEntity<List<Veiculo>> disponiveis() {
        return ResponseEntity.ok(service.listarDisponiveis());
    }

    // Busca um veículo pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> porId(@PathVariable UUID id) {

        // Se encontrar, retorna 200; se não, retorna 404
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Cadastra um novo veículo
    @PostMapping
    public ResponseEntity<Veiculo> criar(@RequestBody Veiculo v) {

        // Retorna 201 (Created) após salvar
        return ResponseEntity.status(201).body(service.criar(v));
    }

    // Atualiza um veículo existente pelo ID
    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> atualizar(@PathVariable UUID id, @RequestBody Veiculo v) {
        return ResponseEntity.ok(service.atualizar(id, v));
    }
}
