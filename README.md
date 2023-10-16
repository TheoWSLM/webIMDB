<h1>Web IMDB</h1> 
<p>
<img src="http://img.shields.io/static/v1?label=STATUS&message=CONCLUIDO&color=GREEN&style=for-the-badge"/>
</p>
<p>Linguagem utilizada</p> 
:memo: Java

# :hammer: Funcionalidades da Aplicação


## Registro de Usuário
:heavy_check_mark: Os usuários podem se registrar na aplicação fornecendo um nome de usuário e senha.<br>
:heavy_check_mark: Senha e confirmação de senha são validadas para garantir que sejam iguais.
## Login
:heavy_check_mark: Os usuários podem fazer login com seu nome de usuário e senha.<br>
:heavy_check_mark: Um token de autenticação é gerado após um login bem-sucedido.
## Adicionar filmes à lista do usuário
:heavy_check_mark: Usuários autenticados podem adicionar filmes à sua lista pessoal de filmes.<br>
## Listar filmes escolhidos pelo usuário
:heavy_check_mark: Os usuários podem visualizar a lista de filmes que adicionaram à sua conta.<br>
## Excluir filmes da lista do usuário
:heavy_check_mark: Os usuários podem remover filmes de sua lista pessoal.
## Listar filmes para seleção
:heavy_check_mark: Uma seleção de melhores filmes do IMDB disponíveis para adicionar à sua conta!

## Como usar :arrow_forward:
<h3>Registro de Usuário</h3>
Método: POST<br>
URL: /user/register<br>
Corpo da Requisição:
<pre>
{
    "login": "seu_login",
    "passWord": "sua_senha",
    "passWordConfirmation": "sua_senha"
}
</pre>
<h3>Login de Usuário</h3>
Método: POST<br>
URL: /user/login<br>
Corpo da Requisição:
<pre>
{
    "login": "seu_login",
    "passWord": "sua_senha"
}
</pre>
<h3>Adicionar Filme ao Usuário</h3>
Método: PUT<br>
URL: /user/addFilme?idUser={ID_DO_USUÁRIO}&filmId={ID_DO_FILME}
<pre>
{
    "idUser": "seu_user",
    "idFilme": "id_filme"
}
</pre>
<h3>Listar Filmes do Usuário</h3>
Método: GET<br>
URL: /user/meusFilmes?idUser={ID_DO_USUÁRIO}
<pre>
{
    "idUser": "seu_user"
}
</pre>
<h3>Excluir Filme do Usuário</h3>
Método: DELETE<br>
URL: /user/excluirFilme?idUser={ID_DO_USUÁRIO}&idFilme={ID_DO_FILME}
<pre>
{
    "idUser": "seu_user",
    "idFilme": "id_filme"
}
</pre>
<h3>Listar Filmes</h3>
Método: GET<br>
URL: /filme/list
<pre>
{
    "idUser": "seu_user"
}
</pre>

# Configuração do Banco de Dados

Antes de executar a aplicação, é necessário configurar o banco de dados. Siga os passos abaixo para configurar o arquivo `application.properties` com as informações corretas do seu banco de dados.

1. Abra o arquivo `application.properties` localizado na raiz do seu projeto.

2. Edite as seguintes propriedades para refletir as configurações do seu banco de dados:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/seu_banco_de_dados
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
spring.mvc.pathmatch.matching-strategy=ant-path-matcher
```

Certifique-se de que *seu_banco_de_dados*, *seu_usuario* e *sua_senha* sejam substituídos pelas informações reais do seu banco de dados.

:heavy_check_mark: Salve as alterações no arquivo application.properties.

## Observações

Caso deseje utilizar um banco de dados diferente, ajuste a URL de conexão de acordo com o sistema de gerenciamento de banco de dados que você está usando.

O Swagger esta habilitado e configurado nessa aplicação para facilitar o seu uso, basta acessar por meio da url padrão http://localhost:8080/swagger-ui/index.html caso esteja rodando na porta 8080


## Desenvolvedor:
![Design sem nome (1)](https://github.com/TheoWSLM/webIMDB/assets/130668057/8effdd6f-8315-46c4-952c-9e639e50b4bb)<br><sub>THEO WEBER</sub>(https://github.com/TheoWSLM)  
