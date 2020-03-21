package br.com.inventory.web.application.domain;

import br.com.inventory.web.application.enums.ProductTypeEnum;
import lombok.*;

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
