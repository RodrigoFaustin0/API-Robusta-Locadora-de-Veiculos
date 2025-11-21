package com.locadora.repository;

import com.locadora.model.Cliente;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class ClienteRepository extends JsonRepositoryBase<Cliente> {
    
    //construtor
    public ClienteRepository() { 
        super(Cliente.class, "clientes.json"); 
    }

    // retorna todos os clientes do do json
    public List<Cliente> findAll() { 
        return readAll(); 
    }
    
    //Busca um cliente pelo CPF, faz leitura do JSON e filtra pelo CPF.
    public Optional<Cliente> findByCpf(String cpf) { 
        return readAll().stream()
        .filter(c -> c.getCpf().equals(cpf))
        .findFirst(); 
    }
    
    //Busca um cliente pelo ID 
    public Optional<Cliente> findById(UUID id) { 
        return readAll().stream()
        .filter(c -> c.getId().equals(id))
        .findFirst(); }
    
    // Salva um novo cliente no JSON 
    public Cliente save(Cliente cliente) {
        List<Cliente> all = readAll();
        all.add(cliente);
        writeAll(all);
        return cliente;
    }
    
    // Atualiza um cliente já existente
    public Cliente update(Cliente cliente) {
        List<Cliente> all = readAll().stream().map(c -> c.getId().equals(cliente.getId()) ? cliente : c).collect(Collectors.toList());
        writeAll(all);
        return cliente;
    }
}
