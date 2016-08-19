#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.transaction.annotation.Transactional;

import ${package}.entity.Pagina;
import ${package}.exception.BuzzPageException;

@ContextConfiguration({ "/test-applicationContext.xml" })
public class PaginaDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
	private static final String SLUG_ACADEMIA = "academia";

	@Autowired
	private PaginaDao paginaDao;

	private Pagina paginaAcademia;

	public static Pagina create(PaginaDao paginaDao, String slug) {
		Pagina pagina = new Pagina();
		pagina.setSlug(slug);
		pagina.setFlagPublicado(true);
		return paginaDao.create(pagina);
	}

	@Before
	public void setUp() {
		paginaAcademia = PaginaDaoTest.create(paginaDao, SLUG_ACADEMIA);
	}

	@Test(expected = BuzzPageException.class)
	@Transactional
	public void testCreatePaginaComMesmoSlug() {
		Pagina paginaAcademiaRepetida = new Pagina();
		paginaAcademiaRepetida.setSlug(SLUG_ACADEMIA);
		paginaDao.create(paginaAcademiaRepetida);
	}

}
