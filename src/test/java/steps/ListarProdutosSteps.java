package steps;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

public class ListarProdutosSteps {
    private Response response;

    @Given("o carrinho possui produtos")
    public void o_carrinho_possui_produtos() {
        // Assumindo que o carrinho já possui produtos. Poderíamos adicionar aqui um setup se necessário.
    }

    @When("eu envio uma requisição GET para {string}")
    public void eu_envio_uma_requisicao_get_para(String endpoint) {
        response = RestAssured.get("http://localhost:3001" + endpoint);
    }

    @Then("a resposta deve conter status {int}")
    public void a_resposta_deve_conter_status(Integer statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("a resposta deve conter a lista de produtos no carrinho")
    public void a_resposta_deve_conter_a_lista_de_produtos_no_carrinho() {
        response.then().body("carrinho", not(empty()));
    }
}
