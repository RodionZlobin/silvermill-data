package com.rodion.silvermilldata.domain;

import java.io.Serializable;

/**
 * @author Rodion
 */
public class OrderRaw extends ValueObject implements Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    protected Object[] getIdFields() {
        return new Object[0];
    }
}
