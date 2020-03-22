package br.com.inventory.application.service;

import br.com.inventory.application.domain.Product;
import br.com.inventory.application.ports.in.CreateProductUseCase;
import br.com.inventory.application.ports.out.SaveProductPort;
import br.com.inventory.common.annotations.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class CreateProductService implements CreateProductUseCase {

    private final SaveProductPort saveProductPort;

    @Override
    public Product create(Product product) {
        return saveProductPort.save(product);
    }
}
