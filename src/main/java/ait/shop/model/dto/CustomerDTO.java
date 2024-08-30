package ait.shop.model.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;

//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class CustomerDTO {

    private Long id;
    private String name;
    private boolean active;
    @JsonManagedReference
    private CartDTO cart;


    @Override
    public String toString() {
        return String.format("CustomerDTO: id - %d, name - %s, active - %s, cart_id: %d",
                id, name,  active ? "yes" : "no", cart.getId() );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public CartDTO getCart() {
        return cart;
    }

    public void setCart(CartDTO cart) {
        this.cart = cart;
    }
}
