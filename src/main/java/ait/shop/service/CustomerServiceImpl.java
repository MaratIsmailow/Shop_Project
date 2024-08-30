package ait.shop.service;

import ait.shop.exceptions.ThirdTestException;
import ait.shop.model.entity.Customer;
import ait.shop.service.interfaces.CustomerService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {


    // TODO реализовать

    @Override
    public Customer save(Customer customer) {
        return null;
    }

    @Override
    public List<Customer> getAllActiveCustomers() {
        return List.of();
    }

    @Override
    public Customer getById(long id) {
        if (id == 5) {
            throw new ThirdTestException("Customer controller exception");
        }
        return null;
    }

    @Override
    public Customer update(Customer customer) {
        return null;
    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public void deleteByName(String name) {

    }

    @Override
    public void restoreById(long id) {

    }

    @Override
    public long getActiveCustomerCount() {
        return 0;
    }

    @Override
    public BigDecimal getTotalCostOfCustomersProducts(long customerId) {
        return null;
    }

    @Override
    public BigDecimal getAverageCostOfCustomersProducts(long customerId) {
        return null;
    }

    @Override
    public void addProductToCustomersCart(long customerId, long productId) {

    }

    @Override
    public void removeProductFromCustomersCart(long customerId, long productId) {

    }

    @Override
    public void clearCustomersCart(long customerId) {

    }
}
