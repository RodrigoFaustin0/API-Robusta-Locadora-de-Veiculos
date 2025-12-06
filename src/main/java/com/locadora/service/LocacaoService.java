package com.locadora.service;

import com.locadora.model.Locacao;
import com.locadora.model.Veiculo;
import com.locadora.repository.LocacaoRepository;
import com.locadora.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.List;
import java.util.UUID;

@Service
public class LocacaoService {

    // Repositórios usados para acessar locações e veículos no banco
    private final LocacaoRepository locRepo;
    private final VeiculoRepository veiculoRepo;

    public LocacaoService(LocacaoRepository locRepo, VeiculoRepository veiculoRepo) {
        this.locRepo = locRepo;
        this.veiculoRepo = veiculoRepo;
    }

    // Inicia uma nova locação
    public Locacao iniciarLocacao(Locacao l) {

        // Verifica se o veículo existe
        Veiculo v = veiculoRepo.findById(l.getVeiculoId())
                .orElseThrow(() -> new IllegalArgumentException("Veículo não encontrado"));

        // Verifica se o veículo está disponível
        if (v.getStatus() != Veiculo.Status.DISPONIVEL)
            throw new IllegalStateException("Veículo não disponível");

        // Gera um ID para a locação
        l.setId(UUID.randomUUID());
        l.setStatus(Locacao.Status.ATIVA);

        // Salva a locação
        Locacao saved = locRepo.save(l);

        // Marca o veículo como locado
        v.setStatus(Veiculo.Status.LOCADO);
        veiculoRepo.update(v);

        return saved;
    }

    // Finaliza a locação (devolução)
    public Locacao devolver(UUID locacaoId, java.time.LocalDateTime dataDevolucao, long kmFinal) {

        // Busca a locação
        Locacao l = locRepo.findById(locacaoId)
                .orElseThrow(() -> new IllegalArgumentException("Locação não encontrada"));

        // Verifica se a locação está ativa
        if (l.getStatus() != Locacao.Status.ATIVA)
            throw new IllegalStateException("Locação não está ativa");

        // Atualiza dados da devolução
        l.setDataDevolucao(dataDevolucao);
        l.setKmFinal(kmFinal);

        // Calcula quantidade de dias
        long dias = Duration.between(l.getDataInicio(), dataDevolucao).toDays();
        if (dias == 0) dias = 1; // mínimo de 1 dia

        // Cálculo simples do valor
        BigDecimal valor = BigDecimal.valueOf(dias).multiply(BigDecimal.valueOf(100))
                .add(BigDecimal.valueOf(Math.max(0, kmFinal - l.getKmInicial()))
                        .multiply(BigDecimal.valueOf(0.5)));

        l.setValorTotal(valor);
        l.setStatus(Locacao.Status.FINALIZADA);

        // Atualiza a locação no banco
        locRepo.update(l);

        // Atualiza o veículo
        Veiculo v = veiculoRepo.findById(l.getVeiculoId()).orElseThrow();
        v.setQuilometragem(kmFinal);
        v.setStatus(Veiculo.Status.DISPONIVEL);
        veiculoRepo.update(v);

        return l;
    }

    // Lista locações que ainda estão ativas
    public List<Locacao> listarAtivas() {
        return locRepo.findAtivas();
    }
}
