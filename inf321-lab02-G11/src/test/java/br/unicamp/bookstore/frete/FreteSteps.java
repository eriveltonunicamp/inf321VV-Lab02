package br.unicamp.bookstore.frete;

import java.util.Map;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.github.tomakehurst.wiremock.WireMockServer;

import br.unicamp.bookstore.Configuracao;
import br.unicamp.bookstore.model.Endereco;
import br.unicamp.bookstore.service.BuscaEnderecoService;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;

public class FreteSteps {

	public WireMockServer wireMockServer;

	@Mock
	private Configuracao configuration;

	@InjectMocks
	private BuscaEnderecoService buscaEnderecoService;

	private String cepOrigem;
	private String cepDestino;

	private Throwable throwable;


	@Before
	public void setUp() {
		wireMockServer = new WireMockServer(9876);
		wireMockServer.start();
		MockitoAnnotations.initMocks(this);
		Mockito.when(configuration.getConsultaPrecoPrazoUrl()).thenReturn("http://localhost:9876/ws");
		cepOrigem = null;
		cepDestino = null;
		throwable = null;
	}

	@After
	public void teardown() {
		wireMockServer.stop();
	}
	
	@Dado("^as seguintes informaÃ§Ãµes do produto:$")
	public void asSeguintesInformaÃ§ÃµesDoProduto(Map<String, String> map) throws Throwable {
		
	}

	@Dado("^um produto com peso (\\d+) largura (\\d+) altura (\\d+) comprimento (\\d+)$")
	public void umProdutoComPesoLarguraAlturaComprimento(int peso, int largura, int altura, int comprimento) throws Throwable {
	}

	@Dado("^os seguintes ceps:$")
	public void osSeguintesCeps(Map<String,String> ceps) throws Throwable {
		cepOrigem = ceps.get("cep-origem");
		cepDestino = ceps.get("cep-destino");
	}

}
