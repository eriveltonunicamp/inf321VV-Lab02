# language: pt
Funcionalidade: Calcula Preco Frete e Prazo de Entrega
  Como um usuário do sistema Bookstore
  Desejo calcular o preco do frete e o prazo de entrega
  Para poder fazer um pedido de compra

  Contexto: Pré condições
    Dado os seguintes ceps:
      | cep-origem  | 13186700 |
      | cep-destino | 13083970 |

  Cenario: Informar dados do produto valido para os correios
    Dado Peso e Dimensões do produto:
      | Peso | Altura | Largura | Comprimento |
      |   20 |     20 |      15 |          15 |
      |   10 |     10 |       5 |           5 |
      |    5 |     15 |       5 |           5 |
    E um tipo de entrega "PAC"
    E um endereço com CEP "13186700"
    Quando eu informo o CEP para o calculo do frete e prazo de entrega
    Então o resultado deve ser o preco e prazo
      | Preço | 45 |
      | Prazo | 15 |
    E armazena essa informação no banco de dados

  Cenario: Informar dados do CEP inválido
    Dado Peso e Dimensões do produto:
      | Peso | Altura | Largura | Comprimento |
      |   20 |     20 |      15 |          15 |
      |   10 |     10 |       5 |           5 |
      |    5 |     15 |       5 |           5 |
    E um tipo de entrega "SEDEX"
    E um endereço com CEP "13186701"
    Quando eu informo o CEP para o calculo do frete e prazo de entrega
    Então o retorno deve conter um valor de CEP invalido igual a "true"

  Cenario: Informar dados com na API do correio
    Dado Peso e Dimensões do produto:
      | Peso | Altura | Largura | Comprimento |
      |   20 |     20 |      15 |          15 |
      |   10 |     10 |       5 |           5 |
      |    5 |     15 |       5 |           5 |
    E um tipo de entrega "SEDEX 10"
    E um endereço com CEP "13186700"
    Quando eu pesquiso o preço do frete para o endereço e peso e dimensões do produto e o tipo de entrega
    Então o retorno deve conter dado errado igual a "true"
