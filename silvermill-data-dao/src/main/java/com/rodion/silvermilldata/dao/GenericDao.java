package com.rodion.silvermilldata.dao;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Query;

import java.io.Serializable;
import java.util.List;

/**
 * @author Rodion
 */
public interface GenericDao<T, ID extends Serializable> {

    <S extends T> S insert(S entity);

    <S extends T> S upsert(S entity);

    boolean isExists(String queryParameter, Class<T> entityClass);

    List<T> findAll();

}
