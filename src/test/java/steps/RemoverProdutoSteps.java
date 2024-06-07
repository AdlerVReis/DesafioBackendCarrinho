package steps;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.*;

public class RemoverProdutoSteps {
    private RequestSpecification request;
    private Response response;

    @Given("o produto com ID {int} está no carrinho")
    public void o_produto_com_id_esta_no_carrinho(Integer produtoId) {
        // Setup opcional para garantir que o produto está no carrinho antes de tentar remover.
    }

    @When("eu envio uma requisição DELETE para {string} com ID {int}")
    public void eu_envio_uma_requisicao_delete_para_com_id(String endpoint, Integer produtoId) {
        request = RestAssured.given()
                .header("Content-Type", "application/json")
                .body("{\"produtoId\": " + produtoId + "}");
        response = request.delete("http://localhost:3001" + endpoint);
    }

    @Then("a resposta deve conter status {int}")
    public void a_resposta_deve_conter_status(Integer statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("a resposta deve indicar que o produto foi removido")
    public void a_resposta_deve_indicar_que_o_produto_foi_removido() {
        response.then().body("mensagem", containsString("Produto removido com sucesso"));
    }
}
