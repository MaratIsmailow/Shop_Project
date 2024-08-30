package ait.shop.repository;

import ait.shop.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByActiveTrue();
//    List<Product> findAllByActive(boolean active);
}
