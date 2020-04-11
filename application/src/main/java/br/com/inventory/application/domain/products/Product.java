package br.com.inventory.application.domain.products;


import br.com.inventory.application.enums.ProductTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;



@ToString
public class Product {

    @Getter
    private Long id;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private ProductTypeEnum type;

    @Getter
    @Setter
    private BigDecimal amount;

    public Product(Long id){
        this.id = id;
    }

    public Product(){

    }

}
