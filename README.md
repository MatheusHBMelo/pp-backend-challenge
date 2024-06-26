# Desafio Técnico - Java | Picpay Simplificado
<div align="center"><img alt="lastcommit" src="https://img.shields.io/github/last-commit/matheushbmelo/pp-backend-challenge?color=blue&label=Ultimo commit"/></div><br>

**Objetivo:** Desenvolver uma API RESTFUL para gerenciar a criação de carteiras e transferência de valores.

## Funcionalidades:

### Carteira
1.  Criar Carteira

### Transferência
1.  Fazer transferência.

## Regras de Negócio:

-   Cada carteira contém ID único, nome, cpf/Cpnj, email, senha e tipo da carteira;
-   Os tipos de carteiras disponiveis são usuário e lojista;
-   CPF/CNPJ e e-mail são únicos no sistema;
-   Cada tranferência contém um ID único, usuario que envia, usuario que recebe e o valor da transferência.
-   Usuários podem enviar dinheiro (efetuar transferência) para lojistas e entre usuários;
-   Lojistas só recebem transferências, não enviam dinheiro para ninguém;
-   As transferências são transações validadas por: Saldo, tipo de carteira e autorização externa;
-   O sistema consume dois serviços externos para autorização e notificação de transferência;
-   O sistema fornece feedback apropriado em caso de erros;
-   Banco de dados Mysql no Docker;
-   Validação de exceções com ProblemDetail.

## Diferenciais (Em desenvolvimento):

-   Adicionar autenticação básica para proteger a API (por exemplo, autenticação de token simples).
-   Documentar a API usando o Swagger ou outra ferramenta de documentação.
-   Escrever testes unitários para as principais funcionalidades.

## O que foi considerado no código:

-   Estrutura e organização do projeto.
-   Uso adequado do Spring Boot para criar a API REST.
-   Manipulação correta de erros e validação de entrada.
-   Implementação das histórias de usuário.
-   Uso de boas práticas de programação em Java.
-   Qualidade do código e legibilidade.
-   Uso de convenções de nomenclatura.

## Padrão organizacional:

Para a implementação desse desafio foi escolhido o padrão de camadas. 

O Padrão de camadas é uma escolha sólida para a construção de APIs REST, pois ajuda a manter a separação de responsabilidades e a organização do código.

***

# Datalhes do projeto

## Pré requisitos:

-   Sistema operacional (Windows, Linux ou  Mac);

-   IDE com suporte a Java e Spring Boot (IntelliJ, Eclipse, NetBeans, VScode);

-   Conta no GitHub;

## Diagrama UML:

<div align="center"><img src="https://github.com/MatheusHBMelo/pp-backend-challenge/blob/main/img/class-diagram.jpeg?raw=true" alt="Diagram class"></div>

## Estrutura de commits:

Existe um padrão para a forma de escrita dos commits, com proposito de criar **mensagens mais legíveis** e que não afetem o histórico do projeto.


* Ser sucinto, é melhor sobrar do que faltar.
* Escrever um título e uma mensagem explicando o que foi desenvolvido.
* Idioma padronizado: **Inglês**.

### Tags utilizadas:

* `Initial`: O primeiro commit do projeto, geralmente com a estrutura básica e as dependências iniciais;
* `Feat`: Uma nova funcionalidade desenvolvida;
* `Fix`: Correção de bugs e erros;
* `Style`: Mudanças que não alteram o significado do código (white-space, ponto-e-virgula, correções de texto);
* `Refactor`: Refatoração do código que não corrige ou adiciona nada, apenas legibilidade e otimização;
* `Build`:  Alterações nas dependências, tarefas de manutenção e limpeza de código;
* `test`: Adição ou modificação de testes;
* `Docs`: Alterações na documentação do projeto;

### Formato da mensagem do commit:

````
[Tag]: Título Relevante do Commit
````
## Instruções gerais:

### Criando o banco de dados no docker e iniciando

```bash
docker compose up
```

### Endpoint de carteira

A implementação deve seguir o contrato abaixo.

```http request
POST /wallets
Content-Type: application/json

{
  "name": "nome de teste",
  "cpfCnpj": "00000000",
  "email": "teste@Email.com",
  "password": "test123",
  "walletType: 1 ou 2 || "user" ou "merchant"
}
```

### Endpoint de transferência

A implementação deve seguir o contrato abaixo.

```http request
POST /transfer
Content-Type: application/json

{
  "payerId": 4,
  "payeeId": 15,
  "value": 100.0,
}
```

## Tecnologias:

-   `Java - 17.0.9 2023-10-17 LTS`
-   `Spring - 3.2.0`
-   `Docker`
-   `Mysql`
-   `Postman`
-   `Git`

## Dependências:

-   `Spring Web`
-   `Spring Boot DevTools`
-   `Spring Data JPA`
-   `Mysql Database`
-   `Open Feign`
-   `Spring Validation Hibernate`