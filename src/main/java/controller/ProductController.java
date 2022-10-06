package controller;

import config.Conf;
import entity.Cart;
import entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    public void init() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Conf.class);
        Product product1 = context.getBean(Product.class);
        product1.setId(UUID.randomUUID());
        product1.setName("product 1");
        product1.setPrice(15);

        Product product2 = context.getBean(Product.class);
        product2.setId(UUID.randomUUID());
        product2.setPrice(12);
        product2.setName("product 2");

        Product product3 = context.getBean(Product.class);
        product3.setId(UUID.randomUUID());
        product3.setPrice(20);
        product3.setName("product 3");
        // устал писать))
        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        Cart cart = context.getBean("cart", Cart.class);
    }

    public void findAll() {
        System.out.println(service.findAllProducts());
    }

    public void deleteById(UUID id) {
        service.deleteProductById(id);
    }

    public void deleteFromCartById(UUID id) {
        service.deleteProductsFromCart(id);
    }

    public void saveProductToCart(UUID id) {
        service.saveProductToCart(id);
    }

    public Product findById(UUID id) {
        return service.findProductById(id);
    }
}
