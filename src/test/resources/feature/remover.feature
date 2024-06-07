Feature: Remover produto do carrinho
  Scenario: Remover um produto válido do carrinho
    Given o produto com ID 1 está no carrinho
    When eu envio uma requisição DELETE para "/carrinho/remover" com ID 1
    Then a resposta deve conter status 200
    And a resposta deve indicar que o produto foi removido
