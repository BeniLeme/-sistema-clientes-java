# Sistema de Cadastro de Clientes (Java)

Pequeno sistema de cadastro de clientes em Java, utilizando `ArrayList` e interação via console.

## Funcionalidades

- Cadastro de clientes (nome, e-mail e senha)
- Listagem de todos os clientes cadastrados
- Remoção de clientes pelo número (índice) na lista
- Menu simples no console

## Tecnologias utilizadas

- Java (JDK 17 ou superior recomendado)
- `ArrayList`
- Entrada de dados via `Scanner`

## Como executar o projeto

1. Certifique-se de ter o **JDK** instalado e configurado no `PATH`:

   ```bash
   javac -version
   java -version
   ```

2. Clone este repositório:

   ```bash
   git clone https://github.com/BeniLeme/-sistema-clientes-java.git
   cd -sistema-clientes-java
   ```

3. Compile o arquivo Java:

   ```bash
   javac SistemaClientes.java
   ```

4. Execute o sistema:

   ```bash
   java SistemaClientes
   ```

## Uso do sistema

Ao executar o programa, será exibido um menu no console:

1. **Cadastrar cliente** – solicita nome, e-mail e senha e adiciona à lista.
2. **Listar clientes** – mostra todos os clientes cadastrados.
3. **Remover cliente** – exibe a lista e permite remover pelo número.
4. **Sair** – encerra o programa.

> Observação: por segurança, a senha do cliente **não é exibida** na listagem, apenas armazenada na memória enquanto o programa está em execução.

