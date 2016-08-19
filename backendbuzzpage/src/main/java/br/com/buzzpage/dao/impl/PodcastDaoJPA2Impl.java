package br.com.buzzpage.dao.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import br.com.buzzpage.dao.PodcastDao;
import br.com.buzzpage.entity.Podcast;

public class PodcastDaoJPA2Impl extends GenericDaoImpl<Podcast> implements PodcastDao {

	@PersistenceContext(unitName = "buzzpageRestPersistence")
	private EntityManager entityManager;

	// @PersistenceContext(unitName="demoRestPersistenceLegacy")
	// private EntityManager entityManagerLegacy;

	public List<Podcast> getPodcasts() {

		// String qlString = "SELECT p FROM Podcast p";
		// TypedQuery<Podcast> query = entityManager.createQuery(qlString,
		// Podcast.class);
		//
		// return query.getResultList();
		return findAll();
	}

	public List<Podcast> getRecentPodcasts(int numberOfDaysToLookBack) {

		Calendar calendar = new GregorianCalendar();
		calendar.setTimeZone(TimeZone.getTimeZone("UTC+1"));// Munich time
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, -numberOfDaysToLookBack);// substract the
																// number of
																// days to look
																// back
		Date dateToLookBackAfter = calendar.getTime();

		String qlString = "SELECT p FROM Podcast p where p.insertionDate > :dateToLookBackAfter";
		TypedQuery<Podcast> query = entityManager.createQuery(qlString, Podcast.class);
		query.setParameter("dateToLookBackAfter", dateToLookBackAfter, TemporalType.DATE);

		return query.getResultList();
	}

	public Podcast getPodcastById(Long id) {

		try {
			String qlString = "SELECT p FROM Podcast p WHERE p.id = ?1";
			TypedQuery<Podcast> query = entityManager.createQuery(qlString, Podcast.class);
			query.setParameter(1, id);

			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public Long deletePodcastById(Long id) {

		Podcast podcast = entityManager.find(Podcast.class, id);
		entityManager.remove(podcast);

		return 1L;
	}

	public Long createPodcast(Podcast podcast) {
		podcast.setLinkOnPodcastpedia("url");
		podcast.setInsertionDate(new Date());
		entityManager.persist(podcast);
		entityManager.flush();// force insert to receive the id of the podcast

		return podcast.getId();
	}

	public int updatePodcast(Podcast podcast) {

		entityManager.merge(podcast);

		return 1;
	}

	public void deletePodcasts() {
		Query query = entityManager.createNativeQuery("TRUNCATE TABLE podcasts");
		query.executeUpdate();
	}

	public List<Podcast> getLegacyPodcasts() {
		return findAll();
	}

	public Podcast getLegacyPodcastById(Long id) {
		try {
			String qlString = "SELECT p FROM Podcast p WHERE p.id = ?1";
			TypedQuery<Podcast> query = entityManager.createQuery(qlString, Podcast.class);
			query.setParameter(1, id);

			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
