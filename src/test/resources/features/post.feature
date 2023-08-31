#language:pt
@TestsAll
Funcionalidade: Cadastro de um novo usuário

  @criarNovoUsuario
  Cenario: Criação de Usuário
    Dado que tenho um payload
    Quando realizar uma request POST na path /users
    Entao deve retornar o status code 201
    E deve retornar o contrato "post.json"