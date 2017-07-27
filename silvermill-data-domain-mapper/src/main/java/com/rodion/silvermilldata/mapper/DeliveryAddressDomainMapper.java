package com.rodion.silvermilldata.mapper;

import com.rodion.silvermilldata.domain.DeliveryAddress;
import com.rodion.silvermilldata.entity.DeliveryAddressEntity;

/**
 * @author Rodion
 */
public class DeliveryAddressDomainMapper {

    public static DeliveryAddress map(DeliveryAddressEntity entity){
        return new DeliveryAddress(entity.getDeliveryAddressId(),
                entity.getDeliveryAddressName(),
                entity.getStreet(),
                entity.getBuilding(),
                entity.getCity(),
                entity.getZipCode(),
                entity.getCountry(),
                entity.getPostBox());
    }

    public static DeliveryAddressEntity map(DeliveryAddress deliveryAddress){
        return new DeliveryAddressEntity(deliveryAddress.getDeliveryAddressId(),
                deliveryAddress.getDeliveryAddressName(),
                deliveryAddress.getStreet(),
                deliveryAddress.getBuilding(),
                deliveryAddress.getCity(),
                deliveryAddress.getZipCode(),
                deliveryAddress.getCountry(),
                deliveryAddress.getPostBox());
    }
}
