#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;

import ${package}.dao.MetricaTextoDao;
import ${package}.entity.MetricaTexto;
import ${package}.exception.BuzzPageException;

public class MetricaTextoDaoJPA2Impl extends GenericDaoImpl<MetricaTexto> implements MetricaTextoDao {

	private static final Logger LOGGER = Logger.getLogger(MetricaTextoDaoJPA2Impl.class);

	private static final String QUERY_METRICA_TEXTO_POR_ID_TEXTO_E_DATA_METRICA = "FROM MetricaTexto metrica where metrica.texto.idTexto = :idTexto and metrica.dataMetrica = :dataMetrica";

	@PersistenceContext(unitName = "buzzpageRestPersistence")
	private EntityManager entityManager;

	@Autowired
	private BuzzPageException buzzPageException;

	@Override
	public MetricaTexto findMetricaTextoByTextoEData(Long idTexto, LocalDate data) {
		Query query = this.entityManager.createQuery(QUERY_METRICA_TEXTO_POR_ID_TEXTO_E_DATA_METRICA);
		query.setParameter("idTexto", idTexto);
		query.setParameter("dataMetrica", data.toDate());

		MetricaTexto metricaTexto = null;
		try {
			metricaTexto = (MetricaTexto) query.getSingleResult();
		} catch (NoResultException e) {
			metricaTexto = null;
		} catch (RuntimeException e) {
			buzzPageException.generateException(e, LOGGER);
		}
		return metricaTexto;
	}

}
