package de.uniluebeck.itm.ep5.poll.repository;

import java.util.List;

public interface GenericRepository<T> {

	T findById(Integer id);

	T update(T object);

	T refresh(T object);

	void add(T object);

	void remove(T object);

	List<T> findAll();
}
