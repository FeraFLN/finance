package com.ferafln.finance.service.generic.process;

public abstract class InsertProcess<E> {

    public <T> T preInsertAction(){
        return null;
    }

    public <T> T postInsertAction(){
        return null;
    }

    public abstract boolean validate();

    public abstract E getEntity();

}
