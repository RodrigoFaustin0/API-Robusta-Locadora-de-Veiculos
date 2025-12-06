package com.locadora.service;

import com.locadora.model.Cliente;
import com.locadora.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Serviço responsável pela lógica de negócios relacionada à entidade Cliente.
 * 
 * Esta classe atua como intermediária entre o controller e o repository,
 * garantindo validações e regras antes de acessar o banco de dados.
 */
@Service
public class ClienteService {

    //Repositório para acesso à persistência de dados de clientes.
    private final ClienteRepository repo;

    // Construtor que injeta a dependência do repositório.
    public ClienteService(ClienteRepository repo) {
        this.repo = repo;
    }

    //Lista todos os clientes cadastrados no sistema.
    public List<Cliente> listar() {
        return repo.findAll();
    }

    // Busca um cliente pelo CPF.
     
    public Optional<Cliente> buscarPorCpf(String cpf) {
        return repo.findByCpf(cpf);
    }

    /**
     * Cria um novo cliente após validar se o CPF já está cadastrado.
     *
     * Regras:
     * - Não permite cadastrar dois clientes com o mesmo CPF.
     * - Gera automaticamente um UUID como identificador.
     */
    public Cliente criar(Cliente c) {
        // Verifica se já existe cliente com o mesmo CPF
        repo.findByCpf(c.getCpf()).ifPresent(x -> {
            throw new IllegalArgumentException("CPF já cadastrado");
        });

        // Atribui um ID único ao cliente
        c.setId(UUID.randomUUID());

        return repo.save(c);
    }

    /**
     * Atualiza os dados de um cliente existente.
     *
     * Regras:
     * - O ID informado na URL é atribuído ao objeto recebido.
     */
    public Cliente atualizar(UUID id, Cliente c) {
        c.setId(id);
        return repo.update(c);
    }
}
