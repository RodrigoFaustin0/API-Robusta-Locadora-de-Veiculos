package com.locadora.service;

import com.locadora.model.Veiculo;
import com.locadora.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Serviço responsável pela lógica de negócios relacionada à entidade Veiculo
 */
@Service
public class VeiculoService {

    // Repositório responsável por executar operações de persistência de veículos.
    private final VeiculoRepository repo;

    // Construtor que injeta o repositório de veículos.
    public VeiculoService(VeiculoRepository repo) {
        this.repo = repo;
    }

    // Retorna todos os veículos cadastrados no sistema, independentemente de estarem disponíveis.
    public List<Veiculo> listar() {
        return repo.findAll();
    }

    // Retorna apenas os veículos que estão disponíveis para locação.
    public List<Veiculo> listarDisponiveis() {
        return repo.findDisponiveis();
    }

    // Busca um veículo pelo seu identificador único (UUID).
    public Optional<Veiculo> buscarPorId(UUID id) {
        return repo.findById(id);
    }

    /**
     * Cria um novo veículo no banco de dados.
     *
     * Regras:
     * - Gera automaticamente um UUID para o veículo.
     */
    public Veiculo criar(Veiculo v) {
        v.setId(UUID.randomUUID());
        return repo.save(v);
    }

    //Atualiza os dados de um veículo existente.
    public Veiculo atualizar(UUID id, Veiculo v) {
        v.setId(id);
        return repo.update(v);
    }
}
