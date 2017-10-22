package br.unicamp.bookstore.entrega;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;

import java.util.List;
import java.util.Map;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.github.tomakehurst.wiremock.WireMockServer;

import br.unicamp.bookstore.Configuracao;
import br.unicamp.bookstore.model.Endereco;
import br.unicamp.bookstore.model.StatusEncomenda;
import br.unicamp.bookstore.service.ConsultaEntregaService;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class ConsultaEntregaSteps {

	public WireMockServer wireMockServer;

	@Mock
	private Configuracao configuration;

	@InjectMocks
	private ConsultaEntregaService consultaEntregaService;

	private StatusEncomenda encomenda;

	private String cod;

	private Throwable throwable;


	@Before
	public void setUp() {
		wireMockServer = new WireMockServer(9876);
		wireMockServer.start();
		MockitoAnnotations.initMocks(this);
		Mockito.when(configuration.getStatusEntregaUrl()).thenReturn("http://localhost:9876/ws");
		cod = null;
		throwable = null;
	}

	@After
	public void teardown() {
		wireMockServer.stop();
	}
	
	//Código de rastreio valido

	@Given("^Codigo de rastreio valido:$")
	public void eu_possuo_um_cod_rastreio_valido(Map<String, String> map) throws Throwable {
		cod = map.get("cod");
		wireMockServer.stubFor(get(urlMatching("/ws/"+ cod + ".*")).willReturn(aResponse().withStatus(200)
				.withHeader("Content-Type", "text/xml").withBodyFile("resultado-pesquisa-Encomenda.xml")));
	}
	
	@When("^eu busco pelo produto$")
	public void eu_informo_cod_produto() throws Throwable {
		throwable = catchThrowable(() -> this.encomenda = consultaEntregaService.buscar(cod));
	}
	
	@Then("^o resultado sera:$")
	public void o_resultado_sera(List<Map<String,String>> resultado)
			throws Throwable {
		assertThat(this.encomenda.getTipo()).isEqualTo(resultado.get(0).get("Tipo"));
		assertThat(this.encomenda.getStatus()).isEqualTo(resultado.get(0).get("Status"));
		assertThat(this.encomenda.getDescricao()).isEqualTo(resultado.get(0).get("Descricao"));
		assertThat(throwable).isNull();
	}
	
	//Código de rastreio Invalido
		@Given("^Codigo de rastreio invalido:$")
		public void eu_possuo_um_cod_rastreio_invalido(Map<String, String> map) throws Throwable {
			cod = map.get("cod");
			wireMockServer.stubFor(get(urlMatching("/ws/"+ cod + ".*")).willReturn(aResponse().withStatus(200)
					.withHeader("Content-Type", "text/xml").withBodyFile("resultado-pesquisa-Encomenda_Invalido.xml")));
		}
		
		@Then("^o resultado retornara invalido: \"([^\"]*)\"$")
		public void o_resultado_retornara(String invalido)
				throws Throwable {
			assertThat(this.encomenda.getInvalido()).isEqualTo(invalido);
			assertThat(throwable).isNull();
		}
		
		//Sem autenticacao
		@Given("^Codigo de rastreio valido sem autenticacao:$")
		public void eu_nao_possuo_autenticacao(Map<String, String> map) throws Throwable {
			cod = map.get("cod");
			wireMockServer.stubFor(get(urlMatching("/ws/" + cod + ".*"))
					.willReturn(aResponse().withStatus(403).withHeader("Content-Type", "text/xml")
							.withBodyFile("resultado-pesquisa-Encomenda_AcessoNegado.xml")));
		}

		@Then("^um erro devera ser informado:$")
		public void uma_erro_devera_ser_informado(String message) throws Throwable {
			assertThat(throwable).hasMessage(message);
		}


		 
}
