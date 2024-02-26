# Teste Técnico Like
<p>Projeto desenvolvido ao longo de 4 dias para o teste técnico da Like Sistemas</p>

## Desafio Proposto
- Tela de cadastro de orçamentos <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><path d="M12 0c-6.627 0-12 5.373-12 12s5.373 12 12 12 12-5.373 12-12-5.373-12-12-12zm-1 17l-5-5.299 1.399-1.43 3.574 3.736 6.572-7.007 1.455 1.403-8 8.597z"/></svg>
- Lista com os produtos cadastrados no orçamento atual <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><path d="M12 0c-6.627 0-12 5.373-12 12s5.373 12 12 12 12-5.373 12-12-5.373-12-12-12zm-1 17l-5-5.299 1.399-1.43 3.574 3.736 6.572-7.007 1.455 1.403-8 8.597z"/></svg>
- Salvar os orçamentos no bando de dados <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><path d="M12 0c-6.627 0-12 5.373-12 12s5.373 12 12 12 12-5.373 12-12-5.373-12-12-12zm-1 17l-5-5.299 1.399-1.43 3.574 3.736 6.572-7.007 1.455 1.403-8 8.597z"/></svg>

## Extra
- Tela separada para cadastro de produtos no orçamento atual <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><path d="M12 0c-6.627 0-12 5.373-12 12s5.373 12 12 12 12-5.373 12-12-5.373-12-12-12zm-1 17l-5-5.299 1.399-1.43 3.574 3.736 6.572-7.007 1.455 1.403-8 8.597z"/></svg>
- Opção de remover produtos antes de salvar no banco de dados <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><path d="M12 0c-6.627 0-12 5.373-12 12s5.373 12 12 12 12-5.373 12-12-5.373-12-12-12zm-1 17l-5-5.299 1.399-1.43 3.574 3.736 6.572-7.007 1.455 1.403-8 8.597z"/></svg>
- Tela contendo os orçamentos salvos <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><path d="M12 0c-6.627 0-12 5.373-12 12s5.373 12 12 12 12-5.373 12-12-5.373-12-12-12zm-1 17l-5-5.299 1.399-1.43 3.574 3.736 6.572-7.007 1.455 1.403-8 8.597z"/></svg>
- Testes automatizados no backend<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><path d="M12 0c-6.627 0-12 5.373-12 12s5.373 12 12 12 12-5.373 12-12-5.373-12-12-12zm-1 17l-5-5.299 1.399-1.43 3.574 3.736 6.572-7.007 1.455 1.403-8 8.597z"/></svg>
- Suporte à Docker <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"><path d="M12 0c-6.627 0-12 5.373-12 12s5.373 12 12 12 12-5.373 12-12-5.373-12-12-12zm-1 17l-5-5.299 1.399-1.43 3.574 3.736 6.572-7.007 1.455 1.403-8 8.597z"/></svg>

## Como rodar a aplicação
1. Navegue até a pasta /backend e utilize o comando:
```console
$ docker-compose up -d
```
2. Navegue até a pasta /frontend e abra o arquivo:
'index.html'
3. Para verificar se o projeto e o banco estão rodando corretamente:
```console
$ docker ps
```
4. Para acessar o banco de dados:
```console
$ docker exec -it db_like psql -U like likedb
```
5. Para ver a documentação do backend, acesse o seguinte link com o projeto rodando:
'http://localhost:8080/swagger-ui/index.html#/'


## Tecnologias Utilizadaas

- Java 17
- Spring Boot 3.2.2
- JPA and Hibernate
- Maven
- PostgreSQL
- Flyway
- JUnit
- Docker
- Mockito
- HTML, CSS e JavaScript
- BootStrap
- Swagger

## Cadastrar Orçamento
'POST http://localhost:8080/orcamento'
'Request'
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

'Response'
´´´jsx
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

## Buscar Orçamentos
'GET http://localhost:8080/orcamento'

'Response'
´´´jsx
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