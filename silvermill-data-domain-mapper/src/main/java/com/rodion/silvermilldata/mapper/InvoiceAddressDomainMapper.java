package com.rodion.silvermilldata.mapper;

import com.rodion.silvermilldata.domain.InvoiceAddress;
import com.rodion.silvermilldata.entity.InvoiceAddressEntity;

/**
 * @author Rodion
 */
public final class InvoiceAddressDomainMapper {

    private InvoiceAddressDomainMapper(){}

    public static InvoiceAddress map(InvoiceAddressEntity entity){
        return entity == null ? null :
                new InvoiceAddress(entity.getAddressId(),
                            entity.getAddressName(),
                            entity.getStreet(),
                            entity.getBuilding(),
                            entity.getCity(),
                            entity.getZipCode(),
                            entity.getCountry(),
                            entity.getPostBox());
    }

    public static InvoiceAddressEntity map(InvoiceAddress address){

        return address == null ? null :
                new InvoiceAddressEntity(address.getAddressId(),
                                    address.getAddressName(),
                                    address.getStreet(),
                                    address.getBuilding(),
                                    address.getCity(),
                                    address.getZipCode(),
                                    address.getCountry(),
                                    address.getPostBox());
    }
}
