package com.ferafln.finance.service.generic;

import java.util.List;

public abstract class CrudService<T ,I> implements BaseService {

    public T insert(T entity){
        return (T) getRepository().save(entity);
    }

    public List<T> findAll(){
        return getRepository().findAll();
    }

    public T findById(I id ){
        return (T) getRepository().findById(id);
    }

    public List<T> saveAll(Iterable<T> iterable ){
        return getRepository().saveAll(iterable);
    }
}
