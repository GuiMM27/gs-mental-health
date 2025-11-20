# Global Solution 2025 - Plataforma de Monitoramento de Saúde Mental 🧠

## 📋 Resumo da Solução
API RESTful desenvolvida em Java com Spring Boot para monitoramento de bem-estar e saúde mental no ambiente de trabalho (ODS 3 e 8). A plataforma permite o cadastro de pacientes e o registro diário de humor e ansiedade, visando a prevenção de burnout.

## 👨‍💻 Integrantes do Grupo
* **Enzo Almeida** - RM: 556900
* **Guilherme Moreira** - RM: 557290
* **Gabriel Mello** - RM: 554421

## 🛠️ Tecnologias e Versões
* **Java:** 21 
* **Spring Boot:** 3.3.x
* **Banco de Dados:** H2 Database (Em memória)
* **Persistência:** Spring Data JPA
* **Validação:** Bean Validation (Jakarta Validation)

## 🚀 Como Executar o Projeto
1. **Clone o repositório:**
   ```bash
   git clone <SEU_LINK_DO_GITHUB>
Importe o projeto na sua IDE de preferência (VS Code, IntelliJ ou Eclipse).

Aguarde o Maven baixar todas as dependências.

Execute a classe principal: br.com.fiap.gs_mental_health_madev.GsMentalHealthMadevApplication

A API estará disponível em: http://localhost:8080

🗄️ Configuração do Banco de Dados (H2)
O banco de dados é configurado automaticamente em memória e recriado a cada execução.

Console H2: http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:mentalhealthdb

User: sa

Password: (deixe em branco)

📡 Endpoints e Exemplos de Uso
A API já inicia com dados carregados (Seeds) para teste imediato.

1️⃣ Pacientes
Listar todos os pacientes

GET /pacientes

Cadastrar novo paciente

POST /pacientes

Body (JSON):

JSON

{
  "nome": "Ana Souza",
  "email": "ana.souza@email.com",
  "dataNascimento": "1998-03-15"
}
Buscar por ID

GET /pacientes/{id}

2️⃣ Registros Diários
Listar todos os registros

GET /registros

Criar um registro diário

POST /registros

Body (JSON):

JSON

{
  "dataRegistro": "2025-11-21",
  "nivelHumor": 3,
  "nivelAnsiedade": 4,
  "pacienteId": 1
}
Nota: nivelHumor e nivelAnsiedade devem ser valores entre 1 e 5.

Deletar Registro

DELETE /registros/{id}

✅ Testes
Para testar a API, você pode utilizar ferramentas como Postman ou Insomnia, importando as requisições acima, ou via curl no terminal.

