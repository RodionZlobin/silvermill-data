package com.rodion.silvermilldata.entity;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * @author Rodion
 */
public class OrderRawEntity extends IdEntity<String> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Override
    public String getId() {
        return id;
    }
}
