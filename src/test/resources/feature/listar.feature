Feature: Listar produtos no carrinho
  Scenario: Obter a lista de produtos no carrinho
    Given o carrinho possui produtos
    When eu envio uma requisição GET para "/carrinho"
    Then a resposta deve conter status 200
    And a resposta deve conter a lista de produtos no carrinho
