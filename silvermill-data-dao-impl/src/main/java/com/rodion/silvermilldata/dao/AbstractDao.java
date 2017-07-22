package com.rodion.silvermilldata.dao;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * @author Rodion
 */
public abstract class AbstractDao<T, ID extends Serializable> implements GenericDao<T, ID> {

    private static final String ID = "id";
    //private static final String TYPE = "type";
    protected Class<T> persistentClass;
    protected MongoOperations mongoOperations;

    @SuppressWarnings("unchecked")
    public AbstractDao(MongoOperations mongoOperations) throws ClassNotFoundException {
        this.mongoOperations = (MongoOperations) Objects.requireNonNull(mongoOperations, "mongoOperations");

        try {
            Type type = ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            String className = type.getTypeName();
            this.persistentClass = (Class<T>) Class.forName(className);
            //this.persistentClass = Class.forName(type.getTypeName().split("<")[0]);
        } catch (ClassNotFoundException var3) {
            throw new RuntimeException(var3);
        }


        /*

        (Class.forName( t.getTypeName() ).newInstance())
        */
    }

    public <S extends T> S insert(S entity) {
        mongoOperations.insert(entity);
        return entity;
    }

    public <S extends T> List<S> save(Iterable<S> entities) {
        mongoOperations.save(entities);
        return (List<S>) entities;
    }

    public <S extends T> List<S> insert(Iterable<S> entities) {
        mongoOperations.insertAll((Collection<S>) entities);
        return (List<S>) entities;
    }

    public List<T> findAll() {
        return mongoOperations.findAll(persistentClass);
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll(Sort sort) {
        return mongoOperations.findAll((Class<T>) sort.getClass());
    }

    public <S extends T> List<S> findAll(Example<S> example) {
        return mongoOperations.findAll(example.getProbeType());
    }

    public <S extends T> List<S> findAll(Example<S> example, Sort sort) {
        return mongoOperations.findAll(example.getProbeType(), sort.toString());
    }

}
