package ait.shop.service.interfaces;

import ait.shop.model.dto.ProductDTO;

import java.math.BigDecimal;
import java.util.List;



public interface ProductService {

    public ProductDTO saveProduct(ProductDTO productDTO);

    public ProductDTO getById(long id);

    public ProductDTO updateProduct(Long id, ProductDTO productDTO);

    public ProductDTO remove(Long id);

    public List<ProductDTO> getAll();

    ProductDTO removeByTitle(String title);

    ProductDTO restoreById(Long id);

    long getProductsCount();

    BigDecimal getTotalPrice();

    BigDecimal getAveragePrice();

}

/*
Удалить продукт из базы данных по его наименованию
Восстановить удалённый продукт в базе данных по его идентификатору
Вернуть общее количество продуктов в базе данных (активных)
Вернуть суммарную стоимость всех продуктов в базе данных (активных)
Вернуть среднюю стоимость продукта в базе данных (из активных)

 */