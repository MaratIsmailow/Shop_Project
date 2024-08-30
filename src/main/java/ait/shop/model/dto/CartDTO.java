package ait.shop.model.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;
import java.util.Objects;

//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class CartDTO {

    private Long id;

    @JsonBackReference
    private CustomerDTO customer;

    List<ProductDTO> products;


    @Override
    public String toString() {
        return String.format("CartDTO: id: %d, products: %s, customer: %s",
                id, products == null ? "null" : products, customer);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartDTO cartDto = (CartDTO) o;
        return Objects.equals(id, cartDto.id) && Objects.equals(customer, cartDto.customer)
                && Objects.equals(products, cartDto.products);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(customer);
        result = 31 * result + Objects.hashCode(products);
        return result;
    }
}
