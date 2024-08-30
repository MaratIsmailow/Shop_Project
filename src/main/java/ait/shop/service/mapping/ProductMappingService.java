package ait.shop.service.mapping;

import ait.shop.model.dto.ProductDTO;
import ait.shop.model.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMappingService {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "active", constant = "true")
  public Product mapDtoToEntity(ProductDTO dto);

  public ProductDTO mapEntityToDto(Product entity);


//    public Product mapDtoToEntity(ProductDTO dto){
//        Product entity = new Product();
//        entity.setTitle(dto.getTitle());
//        entity.setPrice(dto.getPrice());
//        return entity;
//    }
//
//    public ProductDTO mapEntityToDto(Product entity){
//        ProductDTO dto = new ProductDTO();
//        dto.setId(entity.getId());
//        dto.setPrice(entity.getPrice());
//        dto.setTitle(entity.getTitle());
//        return dto;
//    }
}
