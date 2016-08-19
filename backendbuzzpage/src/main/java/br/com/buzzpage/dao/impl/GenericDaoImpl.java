package br.com.buzzpage.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.buzzpage.dao.GenericDao;
import br.com.buzzpage.exception.BuzzPageException;

public abstract class GenericDaoImpl<T> implements GenericDao<T> {

	private static final Logger LOGGER = Logger.getLogger(GenericDaoImpl.class);

	@PersistenceContext(unitName = "buzzpageRestPersistence")
	private EntityManager entityManager;

	@Autowired
	private BuzzPageException buzzPageException;

	protected String entity;

	private Class<T> type;

	public GenericDaoImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
	}

	public T create(final T t) {
		try {
			this.entityManager.persist(t);
		} catch (RuntimeException e) {
			buzzPageException.generateException(e, LOGGER);
		}
		return t;
	}

	public void delete(final Object id) {
		this.entityManager.remove(this.entityManager.getReference(type, id));
	}

	public T find(final Object id) {
		return (T) this.entityManager.find(type, id);
	}

	public T update(final T t) {
		return this.entityManager.merge(t);
	}

	public List<T> findAll() {
		Query query = this.entityManager.createQuery("select x from " + getEntityName() + " x");
		return (List<T>) query.getResultList();
	}

	public String getEntityName() {
		if (entity == null) {
			Entity entityAnn = (Entity) type.getAnnotation(Entity.class);

			if (entityAnn != null && !entityAnn.name().equals("")) {
				entity = entityAnn.name();
			} else {
				entity = type.getSimpleName();
			}
		}

		return entity;
	}
}