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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarEntity carEntity = (CarEntity) o;

        if (number != null ? !number.equals(carEntity.number) : carEntity.number != null) return false;
        if (brandName != null ? !brandName.equals(carEntity.brandName) : carEntity.brandName != null) return false;
        return parkingEntitySet != null ? parkingEntitySet.equals(carEntity.parkingEntitySet) : carEntity.parkingEntitySet == null;

    }

    @Override
    public int hashCode() {
        int result = number != null ? number.hashCode() : 0;
        result = 31 * result + (brandName != null ? brandName.hashCode() : 0);
        result = 31 * result + (parkingEntitySet != null ? parkingEntitySet.hashCode() : 0);
        return result;
    }
}
