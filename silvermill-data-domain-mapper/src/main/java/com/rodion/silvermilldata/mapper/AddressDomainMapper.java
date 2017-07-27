package com.rodion.silvermilldata.mapper;

import com.rodion.silvermilldata.domain.Address;
import com.rodion.silvermilldata.entity.AddressEntity;

/**
 * @author Rodion
 */
public class AddressDomainMapper {
    public static Address map(AddressEntity entity){
        return new Address(entity.getAddressId(),
                            entity.getAddressName(),
                            entity.getStreet(),
                            entity.getBuilding(),
                            entity.getCity(),
                            entity.getZipCode(),
                            entity.getCountry(),
                            entity.getPostBox());
    }

    public static AddressEntity map(Address address){

        return new AddressEntity(address.getAddressId(),
                                    address.getAddressName(),
                                    address.getStreet(),
                                    address.getBuilding(),
                                    address.getCity(),
                                    address.getZipCode(),
                                    address.getCountry(),
                                    address.getPostBox());
    }
}
