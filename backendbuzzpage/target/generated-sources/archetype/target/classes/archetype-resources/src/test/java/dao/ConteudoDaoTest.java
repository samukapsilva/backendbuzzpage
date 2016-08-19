#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao;

import org.springframework.test.context.ContextConfiguration;

import ${package}.entity.Pagina;
import ${package}.entity.Texto;

@ContextConfiguration({ "/test-applicationContext.xml" })
public class ConteudoDaoTest {

	public static Texto create(ConteudoColaboradorDao dao, PaginaDao paginaDao) {
		Pagina paginaAgenciaDeCasamento = PaginaDaoTest.create(paginaDao, "agencia-de-casamento");

		Texto texto = new Texto();
		texto.setSlug("historia-de-amor-priscila-e-thiago-no-domingo-legal");
		texto.setFlagPublicado(true);
		texto.setPagina(paginaAgenciaDeCasamento);
		dao.create(texto);
		return texto;
	}

}
