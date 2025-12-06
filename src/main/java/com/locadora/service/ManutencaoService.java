package com.locadora.service;

import com.locadora.model.Manutencao;
import com.locadora.model.Veiculo;
import com.locadora.repository.ManutencaoRepository;
import com.locadora.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ManutencaoService {

    // Repositórios usados para acessar manutenções e veículos no banco
    private final ManutencaoRepository repo;
    private final VeiculoRepository veiculoRepo;

    public ManutencaoService(ManutencaoRepository repo, VeiculoRepository veiculoRepo) {
        this.repo = repo;
        this.veiculoRepo = veiculoRepo;
    }

    // Registra uma nova manutenção
    public Manutencao registrar(Manutencao m) {

        // Verifica se o veículo existe
        Veiculo v = veiculoRepo.findById(m.getVeiculoId())
                .orElseThrow(() -> new IllegalArgumentException("Veículo não encontrado"));

        // Marca o veículo como em manutenção
        v.setStatus(Veiculo.Status.MANUTENCAO);
        veiculoRepo.update(v);

        // Gera ID da manutenção
        m.setId(UUID.randomUUID());

        // Marca como pendente
        m.setStatus(Manutencao.Status.PENDENTE);

        // Salva a manutenção no banco
        return repo.save(m);
    }

    // Conclui uma manutenção
    public Manutencao concluir(UUID manutencaoId) {

        // Busca a manutenção pelo ID
        Manutencao m = repo.findAll().stream()
                .filter(x -> x.getId().equals(manutencaoId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Manutenção não encontrada"));

        // Atualiza status e data de término
        m.setStatus(Manutencao.Status.CONCLUIDA);
        m.setDataFim(java.time.LocalDateTime.now());
        repo.update(m);

        // Atualiza o veículo, deixando-o disponível novamente
        Veiculo v = veiculoRepo.findById(m.getVeiculoId()).orElseThrow();
        v.setStatus(Veiculo.Status.DISPONIVEL);
        veiculoRepo.update(v);

        return m;
    }

    // Retorna o histórico de manutenções de um veículo
    public List<Manutencao> historico(UUID veiculoId) {
        return repo.findByVeiculoId(veiculoId);
    }
}
