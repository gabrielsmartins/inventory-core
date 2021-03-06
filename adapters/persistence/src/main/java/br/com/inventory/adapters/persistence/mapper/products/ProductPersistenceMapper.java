package br.com.inventory.adapters.persistence.mapper.products;


import br.com.inventory.adapters.persistence.entity.ProductEntity;
import br.com.inventory.adapters.persistence.enums.ProductTypeDataEnum;
import br.com.inventory.application.domain.products.Product;
import br.com.inventory.application.enums.ProductTypeEnum;
import org.springframework.stereotype.Component;

@Component
public class ProductPersistenceMapper {

    public Product mapToDomain(ProductEntity productEntity){
        Product product = new Product(productEntity.getId());
        product.setAmount(productEntity.getAmount());
        product.setDescription(productEntity.getDescription());
        product.setType(ProductTypeEnum.valueOf(productEntity.getType().name()));
        return product;
    }

    public ProductEntity mapToEntity(Product product){
        ProductEntity productEntity = new ProductEntity();
        productEntity.setAmount(product.getAmount());
        productEntity.setDescription(product.getDescription());
        productEntity.setType(ProductTypeDataEnum.valueOf(product.getType()));
        return productEntity;
    }
}
