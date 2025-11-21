package com.locadora.repository;

import com.locadora.model.Manutencao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository 
public class ManutencaoRepository extends JsonRepositoryBase<Manutencao> {

    /* 
        - Construtor: informa à classe base que o tipo gerenciado é Manutencao
        e que os dados devem ser armazenados no arquivo "manutencoes.json" 

    */
    public ManutencaoRepository() { 
        super(Manutencao.class, "manutencoes.json"); 
    }

    // Retorna todas as manutenções salvas no arquivo JSON
    public List<Manutencao> findAll() { 
        return readAll(); 
    }

    // Retorna todas as manutenções associadas a um veículo específico
    public List<Manutencao> findByVeiculoId(UUID veiculoId) { 
        return readAll().stream()
                .filter(m -> m.getVeiculoId().equals(veiculoId))
                .collect(Collectors.toList());
    }

    // Salva uma nova manutenção
    public Manutencao save(Manutencao m) { 
        List<Manutencao> all = readAll(); 
        all.add(m);                       
        writeAll(all);                    
        return m;                         
    }

    // Atualiza uma manutenção existente substituindo pelo novo objeto
    public Manutencao update(Manutencao m) { 
        List<Manutencao> all = readAll().stream()
                .map(x -> x.getId().equals(m.getId()) ? m : x) 
                .collect(Collectors.toList());

        writeAll(all); 
        return m;      
    }
}
