package service;

import entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository {
    List<Product> findAll();
    Product findById(UUID id);

    List<Product> saveAll();

    List<Product> deleteById();
}
