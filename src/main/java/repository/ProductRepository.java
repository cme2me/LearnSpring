package repository;

import entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository {
    List<Product> findAll();
    Product findById(UUID id);

    void saveAll(List<Product> products);

    void deleteById(UUID id);

    void saveToCart(UUID id);

    void deleteFromCartById(UUID id);
}
