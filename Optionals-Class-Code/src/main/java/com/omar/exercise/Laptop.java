package com.omar.exercise;

import java.util.Optional;

public class Laptop {

    private Optional<String> serialNumber;
    private Optional<Boolean> touchScreenEnabled;
    private Optional<Boolean> gamingReady;
    private Optional<Integer> price;

    public Laptop(String serialNumber, Boolean touchScreenEnabled, Boolean gamingReady, Integer price) {
        this.serialNumber = Optional.ofNullable(serialNumber);
        this.touchScreenEnabled = Optional.ofNullable(touchScreenEnabled);
        this.gamingReady = Optional.ofNullable(gamingReady);
        this.price = Optional.ofNullable(price);
    }

    public Optional<String> getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Optional<String> serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Optional<Boolean> getTouchScreenEnabled() {
        return touchScreenEnabled;
    }

    public void setTouchScreenEnabled(Optional<Boolean> touchScreenEnabled) {
        this.touchScreenEnabled = touchScreenEnabled;
    }

    public Optional<Boolean> getGamingReady() {
        return gamingReady;
    }

    public void setGamingReady(Optional<Boolean> gamingReady) {
        this.gamingReady = gamingReady;
    }

    public Optional<Integer> getPrice() {
        return price;
    }

    public void setPrice(Optional<Integer> price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "serialNumber=" + serialNumber +
                ", touchScreenEnabled=" + touchScreenEnabled +
                ", gamingReady=" + gamingReady +
                ", price=" + price +
                '}';
    }
}
