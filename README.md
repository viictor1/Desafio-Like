# Teste Técnico Like
<p>Projeto desenvolvido ao longo de 4 dias para o teste técnico da Like Sistemas</p>

## Desafio Proposto
- [x] Tela de cadastro de orçamentos 
- [x] Lista com os produtos cadastrados no orçamento atual
- [x] Salvar os orçamentos no bando de dados
  
## Extra
- [x] Tela separada para cadastrar os produtos do orçamento atual
- [x] Opção de remover produtos da lista antes de salvar no banco de dados 
- [x] Tela contendo os orçamentos salvos 
- [x] Testes automatizados no backend
- [x] Suporte à Docker 

## Como rodar a aplicação
1. Instale ou clone o repositório:
```console
$ git clone https://github.com/viictor1/desafio-tecnico-like.git
```
2. Navegue até a pasta /desafio-tecnico-like/backend e utilize o comando:
```console
$ docker-compose up -d
```
3. Navegue até a pasta /desafio-tecnico-like/frontend e abra o arquivo: <br>
`index.html` 
4. Para verificar se o projeto e o banco estão rodando corretamente:
```console
$ docker ps
```
5. Para acessar o banco de dados:
```console
$ docker exec -it db_like psql -U like likedb
```
6. Para ver a documentação do backend, acesse o seguinte link com o projeto rodando: <br>
`http://localhost:8080/swagger-ui/index.html#/`
7. As migrations criadas para o banco de dados estão localizadas no diretório: <br>
   `desafio-tecnico-like/backend/src/main/resources/db/migration/`
8. Os testes automatizados estão localizados no diretório: <br>
   `desafio-tecnico-like/backend/src/test/java/com/desafiolike/demo/`


## Tecnologias Utilizadas

- Java 17
- Spring Boot 3.2.2
- JPA and Hibernate
- Maven
- PostgreSQL
- Flyway
- JUnit
- Docker
- Mockito
- Swagger
- HTML, CSS e JavaScript
- BootStrap

## Cadastrar Orçamento
`POST http://localhost:8080/orcamento` <br>
`Request`
```jsx
{
{
  "nomeCliente": "Client Name",
  "data": "2024-02-26",
  "produtos": [
    {
      "nome": "Product 1",
      "valor": 10.0,
      "quantidade": 2
    },
    {
      "nome": "Product 2",
      "valor": 20.0,
      "quantidade": 1
    }
  ]
}
}
```

`Response`
```jsx
{
    {
    "id": 152,
    "nomeCliente": "Client Name",
    "data": "2024-02-26",
    "produtos": [
        {
            "nome": "Product 1",
            "valor": 10.0,
            "quantidade": 2,
            "orcamentoId": 152
        },
        {
            "nome": "Product 2",
            "valor": 20.0,
            "quantidade": 1,
            "orcamentoId": 152
        }
    ]
}
}
```

## Buscar Orçamentos
`GET http://localhost:8080/orcamento`

`Response`
```jsx
{
[
    {
        "id": 152,
        "nomeCliente": "Client Name",
        "data": "2024-02-22",
        "produtos": [
            {
                "nome": "Product 1",
                "valor": 10.0,
                "quantidade": 2,
                "orcamentoId": 152
            },
            {
                "nome": "Product 2",
                "valor": 20.0,
                "quantidade": 1,
                "orcamentoId": 152
            }
        ]
    },
    {
        "id": 153,
        "nomeCliente": "Client Name 2",
        "data": "2024-02-22",
        "produtos": [
            {
                "nome": "Product 3",
                "valor": 15.1,
                "quantidade": 1,
                "orcamentoId": 153
            },
            {
                "nome": "Product 4",
                "valor": 87.0,
                "quantidade": 5,
                "orcamentoId": 153
            }
        ]
    }
]
}
``` 
