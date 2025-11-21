package com.locadora.model;

import java.math.BigDecimal;
import java.util.UUID;

public class CategoriaVeiculo {
    private UUID id;
    private String nome;
    private BigDecimal diaria;
    private BigDecimal valorPorKm;

    //construtor
    public CategoriaVeiculo() { 
        this.id = UUID.randomUUID(); 
    }
        
    // getters/setters
    public UUID getId() { 
        return id; 
    }
    
    public void setId(UUID id) { 
        this.id = id; 
    }
    
    public String getNome() { 
        return nome; 
    }
    
    public void setNome(String nome) { 
        this.nome = nome; 
    }
    
    public BigDecimal getDiaria() { 
        return diaria; 
    }
    
    public void setDiaria(BigDecimal diaria) { 
        this.diaria = diaria; 
    }
    
    public BigDecimal getValorPorKm() { 
        return valorPorKm; 
    }
    
    public void setValorPorKm(BigDecimal valorPorKm) { 
        this.valorPorKm = valorPorKm; 
    }
}
