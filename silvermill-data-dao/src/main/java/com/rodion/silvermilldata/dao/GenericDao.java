package com.rodion.silvermilldata.dao;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.List;

/**
 * @author Rodion
 */
public interface GenericDao<T, ID extends Serializable> {

    <S extends T> S insert(S entity);

    <S extends T> List<S> save(Iterable<S> entites);

    List<T> findAll();

    List<T> findAll(Sort sort);

    <S extends T> List<S> findAll(Example<S> example);

    <S extends T> List<S> findAll(Example<S> example, Sort sort);

    <S extends T> List<S> insert(Iterable<S> entities);

}
