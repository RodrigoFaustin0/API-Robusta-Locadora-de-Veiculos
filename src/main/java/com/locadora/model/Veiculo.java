package com.locadora.model;

import java.util.UUID;

public class Veiculo {
    public enum Status { DISPONIVEL, LOCADO, MANUTENCAO }

    private UUID id;
    private String placa;
    private String modelo;
    private String fabricante;
    private int ano;
    private UUID categoriaId;
    private Status status;
    private long quilometragem;

    // construtor
    public Veiculo() {
        this.id = UUID.randomUUID();
        this.status = Status.DISPONIVEL;
    }
    
    // getters/setters
    public UUID getId() { 
        return id; 
    }
    
    public void setId(UUID id) { 
        this.id = id; 
    }
    
    public String getPlaca() { 
        return placa; 
    }
    
    public void setPlaca(String placa) { this.placa = placa; }
    
    public String getModelo() { 
        return modelo; 
    }
    
    public void setModelo(String modelo) { 
        this.modelo = modelo; 
    }
    
    public String getFabricante() { 
        return fabricante; 
    }
    
    public void setFabricante(String fabricante) { 
        this.fabricante = fabricante; 
    }
    
    public int getAno() { 
        return ano; 
    }
    
    public void setAno(int ano) { 
        this.ano = ano; 
    }
    
    public UUID getCategoriaId() { 
        return categoriaId; 
    }
    
    public void setCategoriaId(UUID categoriaId) { 
        this.categoriaId = categoriaId; 
    }
    
    public Status getStatus() { 
        return status; 
    }
    
    public void setStatus(Status status) { 
        this.status = status; 
    }
    
    public long getQuilometragem() { 
        return quilometragem; 
    }
    
    public void setQuilometragem(long quilometragem) { 
        this.quilometragem = quilometragem; 
    }
}
