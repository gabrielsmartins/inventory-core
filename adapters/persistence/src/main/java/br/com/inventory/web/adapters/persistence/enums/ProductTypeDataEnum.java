package br.com.inventory.web.adapters.persistence.enums;

import br.com.inventory.web.application.enums.ProductTypeEnum;

public enum ProductTypeDataEnum {

    AUTOMOTIVE(ProductTypeEnum.AUTOMOTIVE,1),
    SPORTS(ProductTypeEnum.SPORTS,2),
    ELECTRONICS(ProductTypeEnum.ELECTRONICS,3),
    BOOKS(ProductTypeEnum.BOOKS,4),
    COMPUTER(ProductTypeEnum.COMPUTER,5);

    private final ProductTypeEnum productTypeEnum;
    private final Integer code;


    ProductTypeDataEnum(ProductTypeEnum productTypeEnum, Integer code){
        this.productTypeEnum = productTypeEnum;
        this.code = code;
    }

    public static ProductTypeDataEnum valueOf(Integer code) {
        for(ProductTypeDataEnum productTypeDataEnum : ProductTypeDataEnum.values()){
            if(productTypeDataEnum.getCode().equals(code)){
                return productTypeDataEnum;
            }
        }
        return null;
    }

    public static ProductTypeDataEnum valueOf(ProductTypeEnum productTypeEnum){
        for(ProductTypeDataEnum productTypeDataEnum : ProductTypeDataEnum.values()){
            if(productTypeDataEnum.getProductTypeEnum() == productTypeEnum){
                return productTypeDataEnum;
            }
        }
        return null;
    }

    public static Integer getCode() {
        return getCode();
    }

    public ProductTypeEnum getProductTypeEnum() {
        return productTypeEnum;
    }


}
