#language:pt
@TestsAll
Funcionalidade: Editar um usuário

  @editarUsuario
  Cenario: Editar um usuario cadastrado
    Dado que tenho um payload
    E realizar uma request POST na path /users
    Quando realizar uma request PATCH na path /users/{id}
    Entao deve retornar o status code 200
    E deve retornar o contrato "patch.json"