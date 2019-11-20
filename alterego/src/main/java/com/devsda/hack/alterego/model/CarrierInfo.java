package com.devsda.hack.alterego.model;

public class CarrierInfo {

    private String carrierName;

    private String carrierId;

    public CarrierInfo(String carrierName, String carrierId) {
        this.carrierName = carrierName;
        this.carrierId = carrierId;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public String getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(String carrierId) {
        this.carrierId = carrierId;
    }
}
