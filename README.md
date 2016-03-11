# Aplicação para Teste-do-mercado

A implementação desse pequeno teste foi desenvolvida utilizando o Java e Node.JS, assim a arquitetura ficou dividida em duas camadas front end e back end, sendo uma API RESTful construída em Java e a outra o servidor web feito em Node.JS utilizando o framework Express.

Essa arquitetura em um cenário real já é o começo para quem deseja implementar SOA, pois dessa forma podemos fazer um escalonamento horizontal tanto da API RESTful quanto do servidor web de forma independente e transparente, o maior gargalo se dar pelo banco de dados Mysql que será necessário utilizar outras técnicas para poder fazer um escalonamento, a principio o mais fácil seria um escalonamento vertical ou em situações mais criticas uma replicação de dados em cluster.

Uma boa solução para implementação dessa arquitetura é utilizar a Amazon Web Services, que provê um série de ferramentas para execução e autmomatização de processos.

### Estrutura dos diretórios git
mercadoria-ws-rest é referente a API RESTful:
* JPA implementação Hibernate
* CDI
* JAX-RS implementação Resteasy
* JAX-B
 
servidor-web é referente ao servidor web responsável por fornecer as paginas:
* Express
* AngularJS
* Template engine Jade
* Stylus

### ***Por que não Node.JS em tudo?***
Hoje o Node.JS já está sendo utilizado em produção por diversas empresas, mas o Java ainda é muito forte para soluções com regras de negócios delicadas, não que o Node não dá conta. Por isso resolvi utilizar os dois um pela história e outro por ser muito produtivo, além disso disponibilizar conteúdo estático e API com o Express é muito fácil e rápido, assim fiquei com o Node e Express para fazer o front pela agilidade e facilidade.

### Organização em modulo



**URL acesso aplicação** http://teste.joaquimsn.com

**URL acesso API** http://rest.joaquimsn.com:8080/teste-do-mercado/api/mercadorias
