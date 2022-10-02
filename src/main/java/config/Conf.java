package config;

import entity.Cart;
import entity.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Conf {

    @Bean
    public Product product() {
        return new Product();
    }

    @Bean
    @Scope(value = "prototype")
    public Cart<Product> cart() {
        return new Cart<>();
    }
}
