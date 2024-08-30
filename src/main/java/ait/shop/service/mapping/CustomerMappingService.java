package ait.shop.service.mapping;

import ait.shop.model.dto.CustomerDTO;
import ait.shop.model.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = CartMappingService.class)
public interface CustomerMappingService {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", constant = "true")
    Customer mapDtoToEntity(CustomerDTO dto);

    CustomerDTO mapEntityToDto(Customer entity);
}
