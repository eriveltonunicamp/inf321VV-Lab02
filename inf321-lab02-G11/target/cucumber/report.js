$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/ConsultaEntrega.feature");
formatter.feature({
  "line": 1,
  "name": "ConsultarStatus",
  "description": "Como usuario\r\nDesejo consultar o status do meu pedido\r\nAssim posso saber quando vou receber minha compra",
  "id": "consultarstatus",
  "keyword": "Feature"
});
formatter.before({
  "duration": 441229205,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "Consultar um pedido entregue",
  "description": "",
  "id": "consultarstatus;consultar-um-pedido-entregue",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "Codigo de rastreio valido:",
  "rows": [
    {
      "cells": [
        "cod",
        "CX184733765US"
      ],
      "line": 8
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "eu busco pelo produto",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "o resultado sera:",
  "rows": [
    {
      "cells": [
        "Tipo",
        "Status",
        "Descricao"
      ],
      "line": 11
    },
    {
      "cells": [
        "PACVAREJO",
        "Entregue",
        "Encomenda de Teste"
      ],
      "line": 12
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "ConsultaEntregaSteps.eu_possuo_um_cod_rastreio_valido(String,String\u003e)"
});
formatter.result({
  "duration": 77219832,
  "status": "passed"
});
formatter.match({
  "location": "ConsultaEntregaSteps.eu_informo_cod_produto()"
});
formatter.result({
  "duration": 87643195,
  "status": "passed"
});
formatter.match({
  "location": "ConsultaEntregaSteps.o_resultado_sera(String,String\u003e\u003e)"
});
formatter.result({
  "duration": 18848823,
  "status": "passed"
});
formatter.after({
  "duration": 100260043,
  "status": "passed"
});
formatter.before({
  "duration": 7001141,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Consultar um pedido inexistente",
  "description": "",
  "id": "consultarstatus;consultar-um-pedido-inexistente",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 15,
  "name": "Codigo de rastreio invalido:",
  "rows": [
    {
      "cells": [
        "cod",
        "000000000"
      ],
      "line": 16
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "eu busco pelo produto",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "o resultado retornara invalido: \"true\"",
  "keyword": "Then "
});
formatter.match({
  "location": "ConsultaEntregaSteps.eu_possuo_um_cod_rastreio_invalido(String,String\u003e)"
});
formatter.result({
  "duration": 319828,
  "status": "passed"
});
formatter.match({
  "location": "ConsultaEntregaSteps.eu_informo_cod_produto()"
});
formatter.result({
  "duration": 9871411,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "true",
      "offset": 33
    }
  ],
  "location": "ConsultaEntregaSteps.o_resultado_retornara(String)"
});
formatter.result({
  "duration": 732916,
  "status": "passed"
});
formatter.after({
  "duration": 202597,
  "status": "passed"
});
formatter.before({
  "duration": 3723340,
  "status": "passed"
});
formatter.scenario({
  "line": 20,
  "name": "Consultar um pedido acesso negado",
  "description": "",
  "id": "consultarstatus;consultar-um-pedido-acesso-negado",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 21,
  "name": "Codigo de rastreio valido sem autenticacao:",
  "rows": [
    {
      "cells": [
        "cod",
        "CX184733765US"
      ],
      "line": 22
    }
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 23,
  "name": "eu busco pelo produto",
  "keyword": "When "
});
formatter.step({
  "line": 24,
  "name": "um erro devera ser informado:",
  "keyword": "Then ",
  "doc_string": {
    "content_type": "",
    "line": 25,
    "value": "Acesso Negado"
  }
});
formatter.match({
  "location": "ConsultaEntregaSteps.eu_nao_possuo_autenticacao(String,String\u003e)"
});
formatter.result({
  "duration": 173363,
  "status": "passed"
});
formatter.match({
  "location": "ConsultaEntregaSteps.eu_informo_cod_produto()"
});
formatter.result({
  "duration": 2934878,
  "status": "passed"
});
formatter.match({
  "location": "ConsultaEntregaSteps.uma_erro_devera_ser_informado(String)"
});
formatter.result({
  "duration": 82150,
  "status": "passed"
});
formatter.after({
  "duration": 99430653,
  "status": "passed"
});
});