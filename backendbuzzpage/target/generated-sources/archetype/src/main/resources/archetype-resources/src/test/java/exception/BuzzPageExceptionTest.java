#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.exception;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityExistsException;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import ${package}.entity.Pagina;

@ContextConfiguration({ "/test-applicationContext.xml" })
public class BuzzPageExceptionTest extends AbstractJUnit4SpringContextTests {
	private static final Logger LOGGER = Logger.getLogger(BuzzPageExceptionTest.class);

	@Autowired
	private BuzzPageException buzzPageException;

	private EntityExistsException causeEntityExists;
	private RuntimeException runtimeException;

	@Before
	public void setUp() {
		causeEntityExists = new EntityExistsException();
		runtimeException = new RuntimeException(causeEntityExists);
	}

	@Test
	public void testBuzzPageException() throws Exception {
		assertNotNull(buzzPageException);
		try {
			buzzPageException.generateException(causeEntityExists, LOGGER);
		} catch (BuzzPageException e) {
			Assert.assertEquals("100 - Entity exists", e.getMessage());
		}
	}

	@Test
	public void testEntityEncapsulatedException() {
		try {
			buzzPageException.generateException(runtimeException, LOGGER);
		} catch (BuzzPageException e) {
			Assert.assertEquals("100 - Entity exists", e.getMessage());
		}
	}

	@Test(expected = BuzzPageException.class)
	public void testBuzzPageGenericException() {
		try {
			Pagina pagina = new Pagina();
			pagina.getCep().length();
		} catch (NullPointerException e) {
			buzzPageException.generateException(e, LOGGER);
		}
	}
}
