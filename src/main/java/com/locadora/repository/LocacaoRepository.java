package com.locadora.repository;

import com.locadora.model.Locacao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class LocacaoRepository extends JsonRepositoryBase<Locacao> {
    public LocacaoRepository() { 
        super(Locacao.class, "locacoes.json"); 
    }

    public List<Locacao> findAll() { 
        return readAll(); 
    }
    public Optional<Locacao> findById(UUID id) { 
        return readAll().stream().filter(l -> l.getId().equals(id)).findFirst(); 
    }
    public List<Locacao> findAtivas() { 
        return readAll().stream().filter(l -> l.getStatus()==Locacao.Status.ATIVA).collect(Collectors.toList()); 
    }
    public Locacao save(Locacao l) { 
        List<Locacao> all = readAll(); all.add(l); writeAll(all); return l; 
    }
    public Locacao update(Locacao l) { 
        List<Locacao> all = readAll().stream().map(x -> x.getId().equals(l.getId()) ? l : x).collect(Collectors.toList()); writeAll(all); return l; 
    }
}
