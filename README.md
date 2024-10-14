# Movies API

---

API para gerenciamento de filmes contando com todas as operações esperadas de um CRUD.


A motivação principal para a criação do projeto foi praticar o desenvolvimento de APIs utilizando Spring Boot e os seguintes conceitos foram utilizados:

- Conexão com banco de dados postgres;
- Migrations com flyway;
- Tratamento de exceções;
- Paginação.

Para o futuro pretendo implementar:

- Autenticação.

---

## Endpoints

Os endpoints da API são:

- ``/movies``

A API usa ids no formato UUID.

### Métodos:

``GET`` | ``POST`` | ``PUT`` | ``DELETE``

### QUERY Params:

- ``size={número}``: tamanho das páginas;
- ``page={número}``: qual página você quer solicitar;
- ``sort={atributo}``: por qual atributo do filme você quer ordenar, as ordenações são feitas em ordem crescente.

---