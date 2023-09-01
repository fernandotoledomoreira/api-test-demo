package api.test.demo.steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import api.test.demo.clients.Clients;

public class Steps {

    Clients clients = new Clients();

    enum Method {
        POST, PATCH, GET
    }

    @Dado("que tenho um payload")
    public void queTenhoUmpPayload() {
        // Step carrega o payload da classe clients
        clients.setPayload();
    }

    @Quando("realizar uma request {} na path {word}")
    public void realiarRequestNaPath(Method typeRequest, String path) {
        // Step realiza um switch de acordo com o typeRequest e consome requisição da clients
        switch (typeRequest) {
            case POST:
                clients.postRequest(String.valueOf(typeRequest), path);
                break;
            case PATCH:
                clients.patchRequest(String.valueOf(typeRequest), path);
                break;
            case GET:
                clients.getRequest(String.valueOf(typeRequest), path);
                break;
        }
    }

    @Entao("deve retornar o status code {int}")
    public void deveRetornarStatusCode(int statusCode) {
        // Step carrega o método para validar status code da classe clients
        clients.validateStatusCode(statusCode);
    }

    @E("deve retornar o contrato {string}")
    public void deveRetornarOContratoEsperado(String schema) {
        // Step carrega o método para validar json schema da classe clients
        clients.validateSchemaApi(schema);
    }
}


