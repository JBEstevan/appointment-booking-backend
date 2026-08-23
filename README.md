# appointment-booking-backend

API RESTful para gerenciamento e agendamento de serviços, desenvolvida em **Java 21** utilizando **Spring Boot** e banco de dados em memória **H2**.

---

## 📌 Sobre o Projeto

O **Appointment Booking Backend** é um sistema backend projetado para gerenciar agendamentos de serviços. A aplicação permite realizar o cadastro de novos agendamentos, consultar agendamentos filtrados por data, atualizar informações existentes e remover agendamentos.

---

## 🛠️ Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3**
  - Spring Web (REST Controllers, Jackson)
  - Spring Data JPA (Hibernate ORM)
- **H2 Database** (Banco de dados relacional em memória)
- **Lombok** (Produtividade e redução de código boilerplate)
- **Apache Maven** (Gerenciador de dependências e build)

---

## 📁 Estrutura do Projeto

A arquitetura segue uma estrutura em camadas limpa e bem definida:

```
src/main/java/com/java/appointment_booking/
├── AppointmentBookingApplication.java
├── controller/
│   └── AgendamentoController.java
├── infrastructure/
│   ├── entity/
│   │   └── AgendamentoEntity.java
│   └── repository/
│       └── AgendamentoRepository.java
└── service/
    └── AgendamentoService.java
```

---

## 🚀 Como Executar o Projeto

### Pré-requisitos
- **Java JDK 21** instalado
- **Apache Maven** (ou utilizar o wrapper `./mvnw` incluso no projeto)
- IDE de sua preferência (Eclipse, IntelliJ IDEA, VS Code) ou Terminal

### Passo a Passo

1. **Clonar o repositório:**
   ```bash
   git clone https://github.com/JBEstevan/appointment-booking-backend.git
   cd appointment-booking-backend
   ```

2. **Compilar e executar a aplicação:**
   - **Via Terminal (PowerShell / Command Prompt):**
     ```cmd
     .\mvnw.cmd spring-boot:run
     ```
   - **Via Terminal (Bash / Linux / macOS):**
     ```bash
     ./mvnw spring-boot:run
     ```
   - **Via IDE (Eclipse / IntelliJ):**
     Execute a classe principal `AppointmentBookingApplication.java` como **Java Application**.

3. **Verificar a execução:**
   A aplicação estará rodando na porta **8080**:
   ```
   http://localhost:8080
   ```

---

## 🗄️ Acesso ao Banco de Dados (H2 Console)

O projeto está configurado com o banco de dados H2 em memória. Você pode acessar o painel visual do banco durante a execução da aplicação:

- **URL:** `http://localhost:8080/h2-console`
- **JDBC URL:** `jdbc:h2:mem:agendamentos-db`
- **User Name:** `jbe`
- **Password:** *(deixe em branco)*

---

## 📖 Documentação da API (Endpoints)

### 1. Criar Agendamento
- **Rota:** `POST /agendamentos`
- **Headers:** `Content-Type: application/json`
- **Body (JSON):**
  ```json
  {
    "servico": "Corte de Cabelo",
    "profissional": "Carlos Silva",
    "dataHoraAgendamento": "2026-08-23T15:00:00",
    "cliente": "Maria Oliveira",
    "telefoneCliente": "11999998888"
  }
  ```
- **Resposta Sucesso:** `201 Created` ou `202 Accepted`

### 2. Buscar Agendamentos por Data
- **Rota:** `GET /agendamentos`
- **Query Params:**
  - `data`: Data no formato `YYYY-MM-DD` (ex: `2026-08-23`)
- **Exemplo:** `GET /agendamentos?data=2026-08-23`
- **Resposta Sucesso:** `200 OK` (retorna uma lista de agendamentos do dia).

### 3. Alterar Agendamento
- **Rota:** `PUT /agendamentos`
- **Query Params:**
  - `cliente`: Nome do cliente
  - `dataHoraAgendamento`: Data/hora original no formato ISO `YYYY-MM-DDTHH:mm:ss`
- **Exemplo:** `PUT /agendamentos?cliente=Maria Oliveira&dataHoraAgendamento=2026-08-23T15:00:00`
- **Body (JSON):** Dados atualizados do agendamento
- **Resposta Sucesso:** `200 OK` ou `202 Accepted`

### 4. Deletar Agendamento
- **Rota:** `DELETE /agendamentos`
- **Query Params:**
  - `cliente`: Nome do cliente
  - `dataHoraAgendamento`: Data e hora do agendamento
- **Exemplo:** `DELETE /agendamentos?cliente=Maria Oliveira&dataHoraAgendamento=2026-08-23T15:00:00`
- **Resposta Sucesso:** `204 No Content`

---

## 📄 Licença

Este projeto está sob a licença [MIT](LICENSE).