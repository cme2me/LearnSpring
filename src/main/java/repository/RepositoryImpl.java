package repository;

import entity.Cart;
import entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class RepositoryImpl implements ProductRepository {
    private final List<Product> products;
    private final Cart<Product> cart;

    public RepositoryImpl(List<Product> products, Cart<Product> cart) {
        this.products = products;
        this.cart = cart;
    }

    @Override
    public List<Product> findAll() {
        if (products.isEmpty()) {
            throw new NullPointerException("No products!");
        }
        System.out.println(products);
        return products;
    }

    @Override
    public Product findById(UUID id) {
        if (products.isEmpty()) {
            throw new NullPointerException("No products!");
        }
        return products.stream().filter(product -> product.getId().equals(id)).findAny().orElseThrow();
    }

    @Override
    public void saveAll(List<Product> products) {
        this.products.addAll(products);
    }

    @Override
    public void deleteById(UUID id) {
        products.removeIf(product -> product.getId().equals(id));
    }

    @Override
    public void saveToCart(UUID id) {
        cart.getProductList().add(products.stream()
                .filter(product -> product.getId().equals(id)).findAny().orElseThrow());
    }

    @Override
    public void deleteFromCartById(UUID id) {
        cart.getProductList().removeIf(product -> product.getId().equals(id));
    }
}
