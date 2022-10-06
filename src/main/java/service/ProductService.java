package service;

import entity.Product;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import repository.RepositoryImpl;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    private final RepositoryImpl repository;

    public ProductService(RepositoryImpl repository) {
        this.repository = repository;
    }


    public Product findProductById(UUID id) {
        return repository.findById(id);
    }

    public List<Product> findAllProducts() {
        return repository.findAll();
    }

    public void saveAllProducts(List<Product> products) {
        repository.saveAll(products);
        System.out.println("Продукты сохранены");
    }

    public void saveProductToCart(UUID id) {
        repository.saveToCart(id);
        System.out.println("Продукт " + id + " сохранен в корзину");
    }

    public void deleteProductsFromCart(UUID id) {
        repository.deleteFromCartById(id);
        System.out.println("Продукт " + id + " удален ищ корзины");
    }

    public void deleteProductById(UUID id) {
        repository.deleteById(id);
        System.out.println("Продукт " + id + "удален");
    }
}
