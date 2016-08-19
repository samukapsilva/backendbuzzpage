package br.com.buzzpage.dao;

import java.util.List;

import org.joda.time.LocalDate;

import br.com.buzzpage.entity.MetricaTexto;

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
