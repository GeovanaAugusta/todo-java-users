# User Microservice

Este projeto é um microserviço para gerenciamento de usuários, desenvolvido com Spring Boot. Ele permite criar, listar, atualizar e excluir usuários, além de definir preferências de notificação (EMAIL, SMS, ou AMBOS).

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.3.4**
- **JPA/Hibernate**
- **MySQL**
- **Maven**

## Funcionalidades

* Criação de usuários com nome, telefone e email.
* Definição de preferências de notificação (Email, SMS ou Ambos).
* Atualização de informações de usuários.
* Exclusão de usuários.
* Listagem de todos os usuários ou obtenção de um usuário específico por ID.

## Pré-requisitos

Antes de iniciar o projeto, certifique-se de ter as seguintes ferramentas instaladas:

- **Java 17+**
- **Maven 3.6+**
- **MySQL**

## Configuração do Projeto

1. **Clone o repositório:**

   ```bash
   git clone https://github.com/seu-repositorio/tarefas-microservice.git
   cd tarefas-microservice
   ```
2. **Configuração do application.properties:**

No diretório src/main/resources, configure o arquivo application.properties com as credenciais do banco de dados MySQL:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/usuarios_db
spring.datasource.username=seu-usuario
spring.datasource.password=sua-senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

3. **Build do Projeto:**

Para compilar o projeto, rode o seguinte comando Maven:

```bash
mvn clean install
```

4. **Executando o Projeto:**

Para rodar o microserviço, use o seguinte comando:

```bash
    mvn spring-boot:run
```

5. **Endpoints da API**

**Listar todos os usuários**

* **URL:** `/api/users`
* **Método:** `GET`
* **Descrição:** Retorna uma lista de todos os usuários.

**Buscar usuário por ID**

* **URL:** `/api/users/{id}`
* **Método:** `GET`
* **Descrição:** Retorna os detalhes de um usuário específico por ID.

**Criar um novo usuário**

* **URL:** `/api/users`
* **Método:** `POST`
* **Descrição:** Cria um novo usuário.
* **Corpo do Pedido:**

1. **Testes**

   Para rodar os testes unitários:

```bash
mvn test
```
