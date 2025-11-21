package com.locadora.model;

import java.time.LocalDate;
import java.util.UUID;

public class Cliente {
    private UUID id;
    private String nome;
    private String cpf;
    private String telefone;
    private String cnh;
    private LocalDate dataCadastro;

    // Construtor
    public Cliente() {
        this.id = UUID.randomUUID();
        this.dataCadastro = LocalDate.now();
    }
    // getters e setters
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
    
    public String getCpf() { 
        return cpf; 
    }
    
    public void setCpf(String cpf) { 
        this.cpf = cpf; 
    }
    
    public String getTelefone() { 
        return telefone; 
    }
    
    public void setTelefone(String telefone) { 
        this.telefone = telefone; 
    }
    
    public String getCnh() { 
        return cnh; 
    }
    
    public void setCnh(String cnh) { 
        this.cnh = cnh; 
    }
    
    public LocalDate getDataCadastro() { 
        return dataCadastro; 
    }
    
    public void setDataCadastro(LocalDate dataCadastro) { 
        this.dataCadastro = dataCadastro; 
    }
}
