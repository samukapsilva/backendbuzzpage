#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao;

import java.util.List;

import org.joda.time.LocalDate;

import ${package}.entity.MetricaTexto;

/**
 * @author Fernando Pires
 * @see
 */
public interface MetricaTextoDao {

	MetricaTexto create(MetricaTexto t);

	void delete(Object id);

	MetricaTexto find(Object id);

	MetricaTexto update(MetricaTexto t);

	List<MetricaTexto> findAll();

	MetricaTexto findMetricaTextoByTextoEData(Long idTexto, LocalDate data);

}
