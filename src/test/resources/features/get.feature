#language:pt
@TestsAll
Funcionalidade: Consulta de usuário existente

  @consultarUsuario
  Cenario: Consulta de usuário
    Dado que tenho um payload
    Quando realizar uma request GET na path /users/{id}
    Entao deve retornar o status code 200
    E deve retornar o contrato "get.json"