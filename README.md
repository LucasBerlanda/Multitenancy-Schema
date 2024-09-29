# Multitenancy Schema

## Resumo

O **Multitenancy Schema** é um projeto em Java que implementa um sistema multi-clientes, separando os dados de cada cliente em schemas distintos. O objetivo é oferecer uma estrutura escalável e segura para gerenciar dados em ambientes de multitenancy.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação utilizada.
- **Spring Framework**: Para injeção de dependência e gerenciamento de componentes.
- **Hibernate**: Para mapeamento objeto-relacional e gerenciamento de transações.
- **Flyway**: Para versionamento e migração de esquemas de banco de dados.

## Como Funciona

O projeto utiliza uma abordagem de `ThreadLocal` para armazenar o contexto do cliente atual. Isso permite que diferentes esquemas sejam utilizados com base no Header `empresa_id` das requisições.

### ThreadLocal no Contexto do Projeto

A classe `TenantContext` utiliza `ThreadLocal<String> currentTenant` para garantir que cada requisição HTTP mantenha seu próprio identificador de cliente, isolando os dados entre requisições simultâneas. Veja como funciona:

1. **Captura do Cliente**: O `TenantInterceptor` intercepta a requisição e, ao encontrar o Header( `empresa_id`), define o cliente atual:
   ```java
   TenantContext.setCurrentTenant(empresaId);

2. **Acesso ao Cliente**: Durante o processamento, qualquer parte do código que precise do cliente pode obter o valor com:
   ```java
   String currentTenant = TenantContext.getCurrentTenant();

3. **Limpeza após a Requisição**: Garante que a referência ao cliente atual seja removida, evitando vazamentos de memória. Após a requisição ser processada, chamamos:
   ```java
   String currentTenant = TenantContext.getCurrentTenant();

### FlywayComponent

A classe `FlywayComponent` gerencia as migrações de esquema, garantindo que cada cliente tenha seu próprio ambiente de dados.

### TenantConnectionProvider

Classe responsável por fornecer conexões ao banco de dados, considerando o cliente atual. Ela implementa a interface `MultiTenantConnectionProvider` do Hibernate. 
  
  - **`getConnection(Object tenantIdentifier)`**: Recebe o identificador do cliente (nome do schema) e altera o contexto do banco de dados para o schema correspondente, permitindo que todas as operações na conexão se refiram ao cliente correto:
    ```java
    connection.createStatement().execute("USE `%s`".formatted(tenantIdentifier));
    ```

  - **`releaseConnection(Object tenantIdentifier, Connection connection)`**: Libera a conexão e redefine para o schema padrão, garantindo a integridade das conexões reutilizadas.











