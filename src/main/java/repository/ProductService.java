package repository;

import entity.Product;
import org.springframework.stereotype.Service;
import service.ProductRepository;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product findProductById(UUID id) {
        return repository.findById(id);
    }

    public List<Product> findAllProducts() {
        return repository.findAll();
    }

    public List<Product> putInCartById(UUID id) {

    }
}
