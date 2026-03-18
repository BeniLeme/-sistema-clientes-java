# API REST de Tarefas (Spring Boot)

API simples para gerenciar tarefas, usando Spring Boot + Spring Data JPA + H2 (em memória).

## Modelo (Entidade)

`Tarefa`:

- `id` (Long)
- `titulo` (String)
- `concluido` (Boolean)

## Como rodar (Windows / PowerShell)

> Você não precisa instalar o Maven: o projeto já possui **Maven Wrapper**.

```powershell
cd "c:\Users\Windows\OneDrive\Área de Trabalho\sistema-clientes-java\tarefas-api"
.\mvnw.cmd spring-boot:run
```

Quando aparecer algo como **Started `TarefasApiApplication`**, a API estará disponível em:

- `http://localhost:8080`

## Endpoints

- `GET /tarefas`
- `POST /tarefas`
- `PUT /tarefas/{id}`
- `DELETE /tarefas/{id}`

## Exemplos de teste no PowerShell (Invoke-RestMethod)

### 1) Listar tarefas (GET)

```powershell
Invoke-RestMethod -Method Get -Uri "http://localhost:8080/tarefas"
```

### 2) Criar tarefa (POST)

```powershell
Invoke-RestMethod -Method Post `
  -Uri "http://localhost:8080/tarefas" `
  -ContentType "application/json" `
  -Body '{"titulo":"Minha primeira tarefa","concluido":false}'
```

### 3) Atualizar tarefa (PUT)

Exemplo para `id = 1`:

```powershell
Invoke-RestMethod -Method Put `
  -Uri "http://localhost:8080/tarefas/1" `
  -ContentType "application/json" `
  -Body '{"titulo":"Tarefa atualizada","concluido":true}'
```

### 4) Remover tarefa (DELETE)

Exemplo para `id = 1`:

```powershell
Invoke-RestMethod -Method Delete -Uri "http://localhost:8080/tarefas/1"
```

## Banco H2 (opcional)

O projeto usa H2 em memória (os dados somem quando reinicia).

- Console H2: `http://localhost:8080/h2-console`

