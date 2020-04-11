package br.com.inventory.application.ports.out.products;

import br.com.inventory.application.domain.products.Product;

import java.util.Optional;

public interface SearchProductPort {
    Optional<Product> findById(Long id);
}
