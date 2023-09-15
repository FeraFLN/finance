package com.ferafln.finance.service.generic.process;

public abstract class CrudProcessService<T> implements InsertService<T> {

    private Object preInsertResult;
    private Object postInsertResult;

    @Override
    public T insert(InsertProcess process) {
        this.preInsertResult = process.preInsertAction();
        T result =  InsertService.super.insert(process);
        this.postInsertResult = process.postInsertAction();
        return result;
    }

    public <R> R getPreInsertResult() {
        return (R) preInsertResult;
    }

    public <R> R getPostInsertResult() {
        return (R) postInsertResult;
    }
}
