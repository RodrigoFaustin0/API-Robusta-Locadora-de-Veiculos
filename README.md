# Locadora API - Caminho A

## Requisitos
- Java 17+
- Maven

## Rodando localmente
1. Copie o projeto para sua máquina.
2. Certifique-se de ter os arquivos em `src/main/resources/data/*.json`.
3. Execute:
`mvn clean spring-boot:run`

4. A API ficará em `http://localhost:8080/api/v1/...`.
5. Swagger UI estará disponível em `http://localhost:8080/swagger-ui/index.html` (springdoc).

## Endpoints principais
- `/api/v1/clientes` (GET, POST, PUT)
- `/api/v1/veiculos` (GET, POST, PUT)
- `/api/v1/veiculos/disponiveis` (GET)
- `/api/v1/locacoes` (POST iniciar locação)
- `/api/v1/locacoes/{id}/devolucao` (POST devolver)
- `/api/v1/locacoes/ativas` (GET)
- `/api/v1/manutencoes` (POST registrar)
- `/api/v1/manutencoes/{id}/concluir` (PUT)

## Observações
- Persistência simples em JSON
- repositórios sincronizados para evitar corrupção.

