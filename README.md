# 🏦 Sistema Bancário com Microsserviços

## 📖 Sobre o Projeto

Este projeto foi desenvolvido utilizando arquitetura de microsserviços com o objetivo de simular operações básicas de um sistema bancário.

A aplicação é composta por dois microsserviços independentes:

- **Customer Service**: responsável pelo gerenciamento de clientes.
- **Bank Account Service**: responsável pelo gerenciamento de contas bancárias.

Os serviços se comunicam através de requisições HTTP utilizando **Spring Cloud OpenFeign**, permitindo a validação e consulta de informações entre os microsserviços.

---

## 🏗️ Arquitetura

```text
┌───────────────────┐
│   Customer API    │
└─────────┬─────────┘
          │
          │ HTTP / OpenFeign
          │
┌─────────▼─────────┐
│ Bank Account API  │
└───────────────────┘
```

---

## 🚀 Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Cloud OpenFeign
- Hibernate
- PostgreSQL
- Maven
- Lombok

---

## 📂 Estrutura do Projeto

```text
bank-system
│
├── customer-service
│   ├── controller
│   ├── service
│   ├── repository
│   ├── entity
│   └── dto
│
├── bank-account-service
│   ├── controller
│   ├── service
│   ├── repository
│   ├── clients
│   ├── entity
│   └── dto
│
└── README.md
```

---

## ⚙️ Funcionalidades

### 👤 Customer Service

- Criar cliente
- Buscar cliente por ID
- Listar clientes
- Atualizar cliente
- Remover cliente

### 💳 Bank Account Service

- Criar conta bancária
- Buscar conta por ID
- Listar contas
- Atualizar conta
- Remover conta
- Associar conta a um cliente existente
- Validar cliente antes da criação da conta

---

## 🔗 Comunicação Entre Serviços

O microsserviço de contas bancárias utiliza OpenFeign para consultar informações dos clientes.

Exemplo:

```java
@FeignClient(
    name = "customers",
    url = "${clients.customers.url}"
)
public interface CustomerClient {

    @GetMapping("/{id}")
    ResponseEntity<CustomerResponse> getCustomer(
        @PathVariable Long id
    );
}
```

Antes de criar uma conta, o sistema realiza uma consulta ao microsserviço de clientes para validar a existência do cliente informado.

---

## 🗄️ Modelo de Dados

### Customer

```text
Customer
├── id
├── name
├── email
└── cpf
```

### Bank Account

```text
BankAccount
├── id
├── agency
├── accountNumber
├── balance
└── customerId
```

---

## ▶️ Como Executar

### 1. Clonar o Repositório

```bash
git clone https://github.com/seu-usuario/bank-system.git
```

### 2. Configurar o PostgreSQL

Criar os bancos de dados:

```sql
CREATE DATABASE customers_db;
CREATE DATABASE accounts_db;
```

### 3. Configurar as Credenciais

No arquivo `application.yml` de cada microsserviço:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/customers_db
    username: postgres
    password: postgres
```

---

### 4. Executar os Microsserviços

Primeiro execute o Customer Service:

```bash
cd customer-service
mvn spring-boot:run
```

Depois execute o Bank Account Service:

```bash
cd bank-account-service
mvn spring-boot:run
```

---

## 📌 Endpoints

### Customer Service

| Método | Endpoint |
|----------|----------|
| POST | /customers |
| GET | /customers |
| GET | /customers/{id} |
| PUT | /customers/{id} |
| DELETE | /customers/{id} |

### Bank Account Service

| Método | Endpoint |
|----------|----------|
| POST | /accounts |
| GET | /accounts |
| GET | /accounts/{id} |
| PUT | /accounts/{id} |
| DELETE | /accounts/{id} |

---

## 🎯 Objetivos de Aprendizado

Este projeto foi desenvolvido para praticar:

- Arquitetura de Microsserviços
- Comunicação entre serviços com OpenFeign
- Desenvolvimento de APIs REST
- Persistência de dados com JPA/Hibernate
- Integração com PostgreSQL
- Tratamento de exceções
- Organização em camadas
- Boas práticas de desenvolvimento backend

---

## 👨‍💻 Autor

**Rafael Nascimento Andrade**

Graduado em Ciência da Computação e desenvolvedor Back-end com foco em Java e ecossistema Spring.
