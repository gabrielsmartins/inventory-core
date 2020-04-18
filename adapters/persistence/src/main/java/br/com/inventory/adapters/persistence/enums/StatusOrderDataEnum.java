package br.com.inventory.adapters.persistence.enums;

import br.com.inventory.application.enums.StatusOrderEnum;

public enum StatusOrderDataEnum {

    NEW(StatusOrderEnum.NEW, 1),
    RECEIVED(StatusOrderEnum.RECEIVED, 2),
    SENT(StatusOrderEnum.SENT, 3),
    RETURNED(StatusOrderEnum.RETURNED, 4),
    REJECTED(StatusOrderEnum.REJECTED, 5),
    FINISHED(StatusOrderEnum.FINISHED, 6);

    private StatusOrderEnum statusOrderEnum;
    private Integer code;

    StatusOrderDataEnum(StatusOrderEnum statusOrderEnum, Integer code){
        this.statusOrderEnum = statusOrderEnum;
        this.code = code;
    }

    public static StatusOrderDataEnum valueOf(Integer code) {
        for(StatusOrderDataEnum statusOrderDataEnum : StatusOrderDataEnum.values()){
            if(statusOrderDataEnum.getCode().equals(code)){
                return statusOrderDataEnum;
            }
        }
        return null;
    }

    public static StatusOrderDataEnum valueOf(StatusOrderEnum status) {
        for(StatusOrderDataEnum statusOrderDataEnum : StatusOrderDataEnum.values()){
            if(statusOrderDataEnum.getStatusOrderEnum() == status){
                return statusOrderDataEnum;
            }
        }
        return null;
    }

    public Integer getCode() {
        return code;
    }

    public StatusOrderEnum getStatusOrderEnum() {
        return statusOrderEnum;
    }
}
