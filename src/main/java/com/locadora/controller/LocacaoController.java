package com.locadora.controller;

import com.locadora.model.Locacao;
import com.locadora.service.LocacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/locacoes")
public class LocacaoController {

    // Serviço responsável pelas regras da locação
    private final LocacaoService service;

    public LocacaoController(LocacaoService service) {
        this.service = service;
    }

    // Inicia uma nova locação
    @PostMapping
    public ResponseEntity<Locacao> iniciar(@RequestBody Locacao l) {
        return ResponseEntity.status(201).body(service.iniciarLocacao(l));
    }

    // Finaliza a locação (devolução do veículo)
    @PostMapping("/{id}/devolucao")
    public ResponseEntity<Locacao> devolver(@PathVariable UUID id, @RequestBody Map<String, Object> body) {

        // Espera receber algo assim:
        // { "dataDevolucao": "2025-11-05T10:00:00", "kmFinal": 12150 }

        // Converte a data enviada no JSON para LocalDateTime
        LocalDateTime data = LocalDateTime.parse((String) body.get("dataDevolucao"));

        // Converte kmFinal para número
        long kmFinal = Long.parseLong(body.get("kmFinal").toString());

        // Executa a devolução
        return ResponseEntity.ok(service.devolver(id, data, kmFinal));
    }

    // Lista locações que ainda estão ativas
    @GetMapping("/ativas")
    public ResponseEntity<List<Locacao>> ativas() {
        return ResponseEntity.ok(service.listarAtivas());
    }
}
