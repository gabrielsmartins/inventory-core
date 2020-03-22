package br.com.inventory.adapters.persistence.enums;


import br.com.inventory.application.enums.ProductTypeEnum;

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

    public Integer getCode() {
        return code;
    }


    public ProductTypeEnum getProductTypeEnum() {
        return productTypeEnum;
    }


}
