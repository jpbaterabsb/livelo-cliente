# Livelo Cliente

## API

### Cadastrar cidade
- POST
- /v1/cidade

#### Payload

```
{
  "estado": "DF",
  "id": 1,
  "nome": "Sobradinho"
}
```

### Cadastrar cliente
- POST
- /v1/cliente

#### Payload

```
{
  "cidadeId": 0,
  "dataNascimento": "string",
  "id": 0,
  "idade": 0,
  "nomeCompleto": "string",
  "sexo": "MASCULINO"
}
```


### Consultar cidade pelo nome
- GET
- /v1/cidade?nome=${nome_da_cidade}

#### Payload

```
N/A
```


### Consultar cidade pelo estado
- GET
- /v1/cidade?estado=${sigla_do_estado}

#### Payload

```
N/A
```


### Consultar cliente pelo nome
- GET
- /v1/cliente?nome=${nome_completo_do_cliente}

#### Payload

```
N/A
```


### Consultar cliente pelo id
- GET
- /v1/cliente/id

#### Payload

```
N/A
```


### Remover o cliente
- DELETE
- /v1/cliente/id

#### Payload

```
N/A
```


### Alterar o nome do cliente
- PATCH
- /v1/cliente/id

#### Payload

```
{
"nomeCompleto" : "Joao"
}
```

## Swagger-UI
- /swagger-ui.html

## Getting started
- mvn clean install
- docker build -t client .
- docker run -p 8080:8080 -d client
