package br.unicamp.bookstore.service;

import br.unicamp.bookstore.Configuracao;
import br.unicamp.bookstore.model.StatusEncomenda;

public class ConsultaEntregaService {
	
	  private Configuracao configuracao;

	  public StatusEncomenda buscar(String cod) throws Exception {
	    String url = String.format("%s/%s/xml", configuracao.getStatusEntregaUrl(), cod);
	    return new RemoteService().getAndParseXml(url, StatusEncomenda.class);
	  }

}
