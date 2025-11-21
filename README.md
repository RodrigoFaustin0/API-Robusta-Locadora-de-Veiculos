# API Robusta - Locadora de Veiculos (Foco no BackEnd)

UNIVERSIDADE FEDERAL DO RIO GRANDE DO NORTE  
Disciplina(s): Linguagem de Programação II  
Professor: João Anísio Marinho da Nobrega  
Aluno: Rodrigo Faustino de Sousa  
Tema: API de Locadora de Veículos


## 1. O problema
Muitas locadoras de veículos de pequeno e médio porte ainda utilizam planilhas ou
registros manuais para controlar clientes, frota, contratos e manutenções. Isso gera
falhas operacionais, como duplicidade de reservas, dificuldade em rastrear histórico de
locações e falta de controle sobre disponibilidade e custos de manutenção. A ausência
de um sistema compromete a eficiência e a confiabilidade do processo de locação e
gestão da frota.

## 2. Público-Alvo
O sistema é voltado para locadoras de veículos de pequeno e médio porte que desejam
informatizar seus processos internos sem depender de sistemas comerciais caros. O
público inclui: gerentes de locadora, funcionários de atendimento, mecânicos e clientes.

## 3. O Escopo (Features Principais)
A API será RESTful, com endpoints bem definidos e arquitetura em três camadas:
Controle, Serviço e Repositório. As principais funcionalidades são descritas em formato
de User Stories:

* Como funcionário, quero cadastrar novos clientes, informando nome, CPF e contato.
* Como funcionário, quero cadastrar veículos com modelo, categoria, placa e quilometragem.
* Como gerente, quero visualizar todos os veículos disponíveis.
* Como cliente, quero reservar um veículo para um período específico.
* Como gerente, quero consultar o histórico de locações e calcular o faturamento.
* Como técnico, quero registrar manutenções com data e custo.
* Como gerente, quero gerar relatórios com total de veículos, reservas ativas e status de manutenção.

## 4. A decisão do Projeto
A proposta é desenvolver uma API de Locadora de Veículos que servirá como o núcleo de backend para todo o sistema da empresa. A API centralizará operações de clientes, veículos, reservas e manutenções. A ideia representa um bom desafio de portfólio, pois envolve múltiplas entidades, lógica de negócio (disponibilidade, períodos de reserva,
cálculos automáticos) e é escalável para futuras integrações.

## 5. A Stack de Tecnologia Proposta
Abaixo estão as tecnologias e componentes principais que serão utilizados:

 COMPONENTE | TECNOLOGIA
----|----
Framework | Spring Boot 3+
Linguagem | Java 17+
Documentação |Springdoc (Swagger UI)
Persistência de Dados | Arquivo JSON local

## Conclusão 
A API de Locadora de Veículos oferece uma solução backend moderna e escalável para
um problema real de gestão de frotas. Com arquitetura organizada, separação de
camadas e documentação via Swagger, o projeto servirá para futuras integrações com
bancos de dados e interfaces gráficas.