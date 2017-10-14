package com.rodion.silvermilldata.mapper;

import com.rodion.silvermilldata.domain.DeliveryAddress;
import com.rodion.silvermilldata.entity.DeliveryAddressEntity;

/**
 * @author Rodion
 */
public final class DeliveryAddressDomainMapper {

    private DeliveryAddressDomainMapper(){}

    public static DeliveryAddress map(DeliveryAddressEntity entity){
        return entity == null ? null :
                new DeliveryAddress(entity.getAddressId(),
                                        entity.getAddressName(),
                                        entity.getStreet(),
                                        entity.getBuilding(),
                                        entity.getCity(),
                                        entity.getZipCode(),
                                        entity.getCountry(),
                                        entity.getPostBox());
    }

    public static DeliveryAddressEntity map(DeliveryAddress deliveryAddress){
        return deliveryAddress == null ? null :
                new DeliveryAddressEntity(deliveryAddress.getAddressId(),
                            deliveryAddress.getAddressName(),
                            deliveryAddress.getStreet(),
                            deliveryAddress.getBuilding(),
                            deliveryAddress.getCity(),
                            deliveryAddress.getZipCode(),
                            deliveryAddress.getCountry(),
                            deliveryAddress.getPostBox());
    }
}
