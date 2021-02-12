<h1>SKR Empreendimento</h1> 

## Descrição do projeto 

<p align="justify">
  API Rest utilizando Spring Boot com Jersey 
</p>

## Funcionalidades

:heavy_check_mark: Listar empreendimentos paginados com filtros por categoria ou Tipo.

:heavy_check_mark: Listar filtros

## Pré-requisitos

:warning: Java 8

:warning: Maven

Adicionar nas variáveis do sistema.

## Como rodar a aplicação :arrow_forward:

No terminal, clone o projeto: 

```
git clone https://github.com/tjvacari/apiskrempreendimento.git
```

Na raiz do projeto executar:

```
./mvnw spring-boot:run
```

## Casos de Uso

Request exemplo:
http://localhost:8080/skr/empreendimento/empreendimento?page=0&max=1&idsCategoria=1&idsTipo=1

page = página selecionada (iniciando em 0)

max = número máximo de registros por página

idsCategoria = Lista de ids decategorias para aplicar o filtro por categoria

idsTipo = Lista de ids tipo para aplicar o filtro por tipo

## JSON :floppy_disk:

### Empreendimento: 

|id|descricao|nome|urlImagem|
| -------- |-------- |-------- |-------- |
|5||55 : Beacon é um ..|55 : BEACON|https://skr.com.br/public/uploads/9cfe133c7cb0a7d442ce7857bf8050e6.jpg|

Request exemplo:
http://localhost:8080/skr/empreendimento/filtro

## JSON :floppy_disk:

### Filtros: 

|id|descricao|tipo|
| -------- | -------- |-------- |
|1|Lançamentos|categoria|
|1|Residencial|tipo|
|2|Entregues|categoria|
|2|Comercial|tipo|

Os ids podem se repetir, pois temos a separação por tipo: "categoria" ou "tipo"

## Configurando ambiente
Importar projeto no Eclipse ou VSCode como um projeto maven

## Iniciando/Configurando banco de dados

Na pasta resources temos "application.properties" onde se encontra a configuração para acesso ao banco.

Criando banco de dados:

Método 1:
Criar nova base no banco PostgreSql com o nome "empreendimento"
Restaurar o backup no banco

Método 2:
Criar nova base no banco PostgreSql com o nome "empreendimento"
Iniciar o a API Rest (neste momento as tabelas e colunas serão criadas no banco)
Executar o script com os inserts