package com.ferafln.finance.service.generic.process;

import com.ferafln.finance.service.generic.BaseService;
import com.ferafln.finance.service.generic.process.InsertProcess;

public interface InsertService<T> extends BaseService {
    default T insert(InsertProcess process){
        if(!process.validate()) return null;
        Object entity = process.getEntity();
        return (T) this.getRepository().save(entity);
    }
}
