# ROTAS

## SWAGGER

-   http://localhost:8080/api/
-   http://localhost:8080/api/swagger-ui/index.html
 

## Observações

- Fazer a configuração do banco no arquivo application.properties passando suas credenciais locais


```bash
 # clonar repositório
    git clone https://github.com/Ismael-r-pithan/api-coffe
```

# Tecnologias utilizadas
-   Spring Web
-   Spring Data Jpa
-   Spring Validation
-   Spring Doc OpenApi
-   Postgresql
-   Flyway
-   Lombok


# Chamadas Curl

-------------------------------------------------------------------------------------------------------------------------

Method POST:

curl -d "userId=1&title=meu curl tds&completed=true" https://jsonplaceholder.typicode.com/todos

-------------------------------------------------------------------------------------------------------------------------

Method GET:

curl https://jsonplaceholder.typicode.com/todos

-------------------------------------------------------------------------------------------------------------------------

Method PUT:

curl -X PUT -d "userId=1&title=agora sim trabalho curl feito&completed=true" https://jsonplaceholder.typicode.com/todos/1 

-------------------------------------------------------------------------------------------------------------------------

Method DELETE:

curl -X DELETE https://jsonplaceholder.typicode.com/todos/1

-------------------------------------------------------------------------------------------------------------------------

