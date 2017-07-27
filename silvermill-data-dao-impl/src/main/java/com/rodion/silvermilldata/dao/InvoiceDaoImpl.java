package com.rodion.silvermilldata.dao;

import com.rodion.silvermilldata.entity.InvoiceEntity;
import org.springframework.data.mongodb.core.MongoOperations;

/**
 * @author Rodion
 */
public class InvoiceDaoImpl extends AbstractDao<InvoiceEntity, String> implements InvoiceDao {
    public InvoiceDaoImpl(MongoOperations mongoOperations) throws ClassNotFoundException {
        super(mongoOperations);
    }
}
