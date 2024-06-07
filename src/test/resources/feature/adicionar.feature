Feature: Adicionar Produto ao Carrinho

  Scenario: Adicionar um produto existente ao carrinho
    Given o produto com ID 1 e quantidade 2
    When eu envio uma requisição POST para "/carrinho/adicionar"
    Then a resposta deve conter status 201
    And a resposta deve conter o produto com ID 1, nome "Produto Teste", quantidade 2, precoUnitario 10.0 e preco_total 20.0
