package com.locadora.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Manutencao {
    public enum Status { PENDENTE, CONCLUIDA }

    private UUID id;
    private UUID veiculoId;
    private String descricao;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private BigDecimal custo;
    private Status status;

    // construtor
    public Manutencao() {
        this.id = UUID.randomUUID();
        this.status = Status.PENDENTE;
        this.dataInicio = LocalDateTime.now();
    }
    // getters/setters
    public UUID getId() { 
        return id; 
    }
    
    public void setId(UUID id) { 
        this.id = id; 
    }
    
    public UUID getVeiculoId() { 
        return veiculoId; 
    }
    
    public void setVeiculoId(UUID veiculoId) { 
        this.veiculoId = veiculoId; 
    }
    
    public String getDescricao() { 
        return descricao; 
    }
    
    public void setDescricao(String descricao) { 
        this.descricao = descricao; 
    }
    
    public LocalDateTime getDataInicio() { 
        return dataInicio; 
    }
    
    public void setDataInicio(LocalDateTime dataInicio) { 
        this.dataInicio = dataInicio; 
    }
    
    public LocalDateTime getDataFim() { 
        return dataFim; 
    }
    
    public void setDataFim(LocalDateTime dataFim) { 
        this.dataFim = dataFim; 
    }
    
    public BigDecimal getCusto() { 
        return custo; 
    }
    
    public void setCusto(BigDecimal custo) { 
        this.custo = custo; 
    }
    
    public Status getStatus() { 
        return status; 
    }
    
    public void setStatus(Status status) { 
        this.status = status; 
    }
}
