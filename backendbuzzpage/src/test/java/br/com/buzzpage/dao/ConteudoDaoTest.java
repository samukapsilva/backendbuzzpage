package br.com.buzzpage.dao;

import org.springframework.test.context.ContextConfiguration;

import br.com.buzzpage.entity.Pagina;
import br.com.buzzpage.entity.Texto;

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
