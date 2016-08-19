package br.com.buzzpage.rest.service;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

import br.com.buzzpage.filters.CORSFilter;

/**
 * Registers the components to be used by the JAX-RS application
 * 
 * @author Alexandre Parreira
 * 
 */
public class BuzzPageApplication extends ResourceConfig {

	/**
	 * Register JAX-RS application components.
	 */
	public BuzzPageApplication() {
		register(RequestContextFilter.class);
		register(PodcastRestService.class);
		register(PaginaRestService.class);
		register(PodcastLegacyRestService.class);
		register(JacksonFeature.class);
		register(ConteudoRestService.class);
		register(CadastroPessoasRestService.class);
		register(AvaliacoesRestService.class);
		register(MensagemRestService.class);
		register(EmailRestService.class);
		register(PedidosRestService.class);
		register(VoucherRestService.class);
		register(AnuncioRestService.class);
		register(RegiaoRestService.class);
		register(ExtratoRestService.class);
		register(CORSFilter.class);
		register(AnuncianteRestService.class);
	}
}
