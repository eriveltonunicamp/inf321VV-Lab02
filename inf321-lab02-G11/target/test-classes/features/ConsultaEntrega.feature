Feature: ConsultarStatus
  Como usuario
  Desejo consultar o status do meu pedido
  Assim posso saber quando vou receber minha compra
  
    Scenario: Consultar um pedido entregue
    Given Codigo de rastreio valido:
    | cod | CX184733765US|
    When eu busco pelo produto
    Then o resultado sera:
      | Tipo | Status  | Descricao |
      | PACVAREJO | Entregue | Encomenda de Teste |
      
    Scenario: Consultar um pedido inexistente
    Given Codigo de rastreio invalido:
    | cod | 000000000 |
    When eu busco pelo produto
    Then o resultado retornara invalido: "true"

    Scenario: Consultar um pedido acesso negado
    Given Codigo de rastreio valido sem autenticacao:
    | cod | CX184733765US|
    When eu busco pelo produto
    Then um erro devera ser informado:
        """
   		 Acesso Negado
    	"""