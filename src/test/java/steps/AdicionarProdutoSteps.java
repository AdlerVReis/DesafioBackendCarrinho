package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AdicionarProdutoSteps {

    private Response response;
    private int produtoId;
    private int quantidade;

    @Given("o produto com ID {int} e quantidade {int}")
    public void o_produto_com_id_e_quantidade(int id, int qtde) {
        this.produtoId = id;
        this.quantidade = qtde;
    }

    @When("eu envio uma requisição POST para {string}")
    public void eu_envio_uma_requisicao_post_para(String endpoint) {
        response = given()
                .contentType("application/json")
                .body("{\"produtoId\": " + produtoId + ", \"quantidade\": " + quantidade + "}")
                .when()
                .post(endpoint);
    }

    @Then("a resposta deve conter status {int}")
    public void a_resposta_deve_conter_status(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("a resposta deve conter o produto com ID {int}, nome {string}, quantidade {int}, precoUnitario {double} e preco_total {double}")
    public void a_resposta_deve_conter_o_produto(int id, String nome, int qtde, double precoUnitario, double precoTotal) {
        response.then().body("produto.produtoId", equalTo(id))
                .body("produto.nome", equalTo(nome))
                .body("produto.quantidade", equalTo(qtde))
                .body("produto.precoUnitario", equalTo(precoUnitario))
                .body("produto.preco_total", equalTo(precoTotal));
    }
}
