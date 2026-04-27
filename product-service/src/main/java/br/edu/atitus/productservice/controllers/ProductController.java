package br.edu.atitus.productservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import br.edu.atitus.productservice.dtos.ProductDTO;
import br.edu.atitus.productservice.entities.ProductEntity;
import br.edu.atitus.productservice.repositories.ProductRepository;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @Value("${server.port}")
    private String port;

    @GetMapping("/{idproduct}")
    public ProductDTO getProduct(
            @PathVariable Long idproduct,
            @RequestParam String targetCurrency) {

        ProductEntity product = repository.findById(idproduct).orElseThrow();

        return new ProductDTO(
                product.getId(),
                product.getDescription(),
                product.getBrand(),
                product.getModel(),
                product.getPrice(),
                product.getCurrency(),
                product.getStock(),
                "Product-service running on Port: " + port,
                null,
                targetCurrency
        );
    }
}