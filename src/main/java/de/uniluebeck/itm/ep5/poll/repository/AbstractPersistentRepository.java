package de.uniluebeck.itm.ep5.poll.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractPersistentRepository<T> implements
		GenericRepository<T> {

	protected Class<T> persistentClass;
	protected EntityManager entityManager;

	public AbstractPersistentRepository(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	public void add(T t) {
		entityManager.persist(t);
	}

	public void update(T t) {
		entityManager.merge(t);
	}

	public void remove(T t) {
		entityManager.remove(t);
	}

	public T findById(Integer id) {
		T result = null;
		result = entityManager.find(this.persistentClass, id);
		return result;
	}

	public List<T> findAll() {
		List<T> result = new ArrayList<T>();
		result = entityManager.createQuery("from " + persistentClass.getName())
				.getResultList();
		return result;
	}

	/**
	 * Used by Spring to inject the configured EntityManager.
	 * @param entityManager
	 */
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
