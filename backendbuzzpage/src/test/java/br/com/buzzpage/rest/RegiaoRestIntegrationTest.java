package br.com.buzzpage.rest;

import java.util.List;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import org.junit.Assert;
import org.junit.Test;

import br.com.buzzpage.entity.Regiao;

public class RegiaoRestIntegrationTest extends RestIntegrationTest {
	private static final String PATH_REGIAO_REGIOES_METHOD = "http://localhost:8081/backendjetty/api/regiao/regioes";

	@Test
	public void testGetRegioes() throws Exception {
		Response response = executeJsonGet(PATH_REGIAO_REGIOES_METHOD);
		List<Regiao> regioes = response.readEntity(new GenericType<List<Regiao>>() {

		});
		Assert.assertNotNull(regioes);
		Regiao regiao = regioes.get(0);
		Assert.assertEquals(Long.valueOf(1), regiao.getIdRegiao());
	}

}
