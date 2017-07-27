package com.rodion.silvermilldata.mapper;

import com.rodion.silvermilldata.domain.DeliveryAddress;
import com.rodion.silvermilldata.entity.DeliveryAddressEntity;

/**
 * @author Rodion
 */
public class DeliveryAddressDomainMapper {

    public static DeliveryAddress map(DeliveryAddressEntity entity){
        return new DeliveryAddress(entity.getDeliveryAddressEntityId());
    }

    public static DeliveryAddressEntity map(DeliveryAddress deliveryAddress){
        return new DeliveryAddressEntity(deliveryAddress.getDeliveryAddressId());
    }
}
