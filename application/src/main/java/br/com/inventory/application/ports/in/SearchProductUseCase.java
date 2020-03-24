package br.com.inventory.application.ports.in;

import br.com.inventory.application.domain.Product;

import java.util.Optional;

public interface SearchProductUseCase {
    Optional<Product> findById(Long id);
}
