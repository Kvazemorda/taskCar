package com.jetmoney.Entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table (name = "CarsEntity")
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (nullable = false, unique = true)
    private String number;

    @Column (nullable = false)
    private String brandName;

    @OneToMany
    private Set<ParkingEntity> parkingEntitySet;

    public CarEntity() {
    }

    public CarEntity(String number, String brandName) {
        this.number = number;
        this.brandName = brandName;
    }
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public String toString() {
        return "CarsEntity{" +
                "number='" + number + '\'' +
                ", brandName='" + brandName + '\'' +
                '}';
    }
}
