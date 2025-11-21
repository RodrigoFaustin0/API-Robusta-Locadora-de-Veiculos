package com.locadora.repository;

import com.locadora.model.Veiculo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository 
public class VeiculoRepository extends JsonRepositoryBase<Veiculo> {

    /* 
        - Construtor: informa à classe base que o tipo é Veiculo
        e que os dados devem ser salvos no arquivo "veiculos.json" 
     */
    public VeiculoRepository() { 
        super(Veiculo.class, "veiculos.json"); 
    }

    // Retorna todos os veículos armazenados no JSON
    public List<Veiculo> findAll() { 
        return readAll(); 
    }

    // Retorna apenas os veículos que estão com status DISPONIVEL
    public List<Veiculo> findDisponiveis() { 
        return readAll().stream()
                .filter(v -> v.getStatus() == Veiculo.Status.DISPONIVEL)
                .collect(Collectors.toList());
    }

    // Busca um veículo pelo seu ID
    public Optional<Veiculo> findById(UUID id) { 
        return readAll().stream()
                .filter(v -> v.getId().equals(id))
                .findFirst(); 
    }

    // Salva um novo veículo gravando no JSON
    public Veiculo save(Veiculo v) { 
        List<Veiculo> all = readAll(); 
        all.add(v);                    
        writeAll(all);                 
        return v;                      
    }

    // Atualiza um veículo já existente
    public Veiculo update(Veiculo v) { 
        
        // Percorre a lista, se o ID for igual, substitui pelo veículo atualizado
        List<Veiculo> all = readAll().stream()
                .map(x -> x.getId().equals(v.getId()) ? v : x)
                .collect(Collectors.toList());

        writeAll(all); 
        return v;      
    }
}
