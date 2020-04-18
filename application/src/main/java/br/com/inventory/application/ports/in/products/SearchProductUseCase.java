package br.com.inventory.application.ports.in.products;

import br.com.inventory.application.domain.products.Product;

import java.util.Optional;

public interface SearchProductUseCase {
    Optional<Product> findById(Long id);
}
