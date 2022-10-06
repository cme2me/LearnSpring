package controller;

import config.Conf;
import entity.Cart;
import entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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


    @GetMapping("/api/find")
    public String findAll(Model model, @RequestParam UUID id) {
        model.addAttribute("itemFront", service.findAllProducts());
        return "index.html";
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") UUID id) {
        service.deleteProductById(id);
    }

    public void deleteFromCartById(UUID id) {
        service.deleteProductsFromCart(id);
    }

    @GetMapping("/findBy/{id}")
    public void saveProductToCart(@PathVariable("id") UUID id) {
        service.saveProductToCart(id);
    }

    public Product findById(UUID id) {
        return service.findProductById(id);
    }
}
