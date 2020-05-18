package org.huyong.my.spring.ioc;

/**
 * Created by yonghu on 2020/5/14.
 */
public class Car {
    private   int maxSpeed ;
    private  String brand ;
    private   double price ;

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
