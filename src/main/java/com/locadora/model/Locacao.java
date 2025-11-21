package com.locadora.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Locacao {
    public enum Status { ATIVA, FINALIZADA, CANCELADA }

    private UUID id;
    private UUID clienteId;
    private UUID veiculoId;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFimPrevisto;
    private LocalDateTime dataDevolucao;
    private long kmInicial;
    private Long kmFinal;
    private BigDecimal valorTotal;
    private Status status;

    //construtor
    public Locacao() {
        this.id = UUID.randomUUID();
        this.status = Status.ATIVA;
    }
    // getters/setters
    public UUID getId() { 
        return id; 
    }
    
    public void setId(UUID id) { 
        this.id = id; 
    }
    
    public UUID getClienteId() { 
        return clienteId; 
    }
    
    public void setClienteId(UUID clienteId) { 
        this.clienteId = clienteId; 
    }
    
    public UUID getVeiculoId() { 
        return veiculoId; 
    }
    
    public void setVeiculoId(UUID veiculoId) { 
        this.veiculoId = veiculoId; 
    }
    
    public LocalDateTime getDataInicio() { 
        return dataInicio; 
    }
    
    public void setDataInicio(LocalDateTime dataInicio) { 
        this.dataInicio = dataInicio; 
    }
    
    public LocalDateTime getDataFimPrevisto() { 
        return dataFimPrevisto; 
    }
    
    public void setDataFimPrevisto(LocalDateTime dataFimPrevisto) { 
        this.dataFimPrevisto = dataFimPrevisto; 
    }
    
    public LocalDateTime getDataDevolucao() { 
        return dataDevolucao; 
    }
    
    public void setDataDevolucao(LocalDateTime dataDevolucao) { 
        this.dataDevolucao = dataDevolucao; 
    }
    
    public long getKmInicial() { 
        return kmInicial; 
    }
    
    public void setKmInicial(long kmInicial) { 
        this.kmInicial = kmInicial; 
    }
    
    public Long getKmFinal() { 
        return kmFinal; 
    }
    
    public void setKmFinal(Long kmFinal) { 
        this.kmFinal = kmFinal; 
    }
    
    public BigDecimal getValorTotal() { 
        return valorTotal; 
    }
    
    public void setValorTotal(BigDecimal valorTotal) { 
        this.valorTotal = valorTotal; 
    }
    
    public Status getStatus() { 
        return status; 
    }
    
    public void setStatus(Status status) { 
        this.status = status; 
    }
}
