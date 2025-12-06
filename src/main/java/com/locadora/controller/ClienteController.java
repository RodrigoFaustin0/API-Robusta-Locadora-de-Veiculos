package com.locadora.controller;

import com.locadora.model.Cliente;
import com.locadora.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    // Serviço que contém a lógica de clientes
    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    // Lista todos os clientes
    @GetMapping
    public ResponseEntity<List<Cliente>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    // Busca um cliente pelo CPF
    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Cliente> porCpf(@PathVariable String cpf) {

        // Se encontrar, retorna 200 OK; se não, retorna 404 Not Found
        return service.buscarPorCpf(cpf)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Cria um novo cliente
    @PostMapping
    public ResponseEntity<Cliente> criar(@RequestBody Cliente c) {

        // Retorna status 201 (Created) ao criar
        return ResponseEntity.status(201).body(service.criar(c));
    }

    // Atualiza um cliente pelo ID
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable UUID id, @RequestBody Cliente c) {
        return ResponseEntity.ok(service.atualizar(id, c));
    }
}
