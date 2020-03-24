package br.com.inventory.application.service;

import br.com.inventory.application.domain.Product;
import br.com.inventory.application.ports.in.SearchProductUseCase;
import br.com.inventory.application.ports.out.SearchProductPort;
import br.com.inventory.common.annotations.UseCase;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@UseCase
@RequiredArgsConstructor
public class SearchProductService implements SearchProductUseCase {

    private final SearchProductPort searchProductPort;

    @Override
    public Optional<Product> findById(Long id) {
        return searchProductPort.findById(id);
    }
}
