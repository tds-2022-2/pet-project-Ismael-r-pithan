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