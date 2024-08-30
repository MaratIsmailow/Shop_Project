package ait.shop.service.mapping;

import ait.shop.model.dto.CartDTO;
import ait.shop.model.entity.Cart;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = CartMappingService.class)
public interface CartMappingService {

    Cart mapDtoToEntity(CartDTO dto);

    CartDTO mapEntityToDto(Cart entity);
}
