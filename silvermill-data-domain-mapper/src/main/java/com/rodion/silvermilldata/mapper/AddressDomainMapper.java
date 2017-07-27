package com.rodion.silvermilldata.mapper;

import com.rodion.silvermilldata.domain.Address;
import com.rodion.silvermilldata.entity.AddressEntity;

/**
 * @author Rodion
 */
public class AddressDomainMapper {
    public static Address map(AddressEntity addressEntity){
        return new Address(addressEntity.getAddressEntityId());
    }

    public static AddressEntity map(Address address){
        return new AddressEntity(address.getAddressId());
    }
}
