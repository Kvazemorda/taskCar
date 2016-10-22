package com.jetmoney.Entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table (name = "PitStopEntity")
public class ParkingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column
    Date dateIn;
    @Column
    Date dateOut;
    @Column
    BigDecimal money;
    @ManyToOne
    CarEntity carEntity;

    public ParkingEntity() {
    }

    public ParkingEntity(Date dateIn, CarEntity carEntity, BigDecimal money) {
        this.dateIn = dateIn;
        this.carEntity = carEntity;
        this.money = money;
    }

    public ParkingEntity(Date dateIn, CarEntity carEntity) {
        this.dateIn = dateIn;
        this.carEntity = carEntity;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }

    public CarEntity getCarEntity() {
        return carEntity;
    }

    public void setCarEntity(CarEntity carEntity) {
        this.carEntity = carEntity;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParkingEntity that = (ParkingEntity) o;

        if (dateIn != null ? !dateIn.equals(that.dateIn) : that.dateIn != null) return false;
        if (dateOut != null ? !dateOut.equals(that.dateOut) : that.dateOut != null) return false;
        return carEntity != null ? carEntity.equals(that.carEntity) : that.carEntity == null;

    }

    @Override
    public int hashCode() {
        int result = dateIn != null ? dateIn.hashCode() : 0;
        result = 31 * result + (dateOut != null ? dateOut.hashCode() : 0);
        result = 31 * result + (carEntity != null ? carEntity.hashCode() : 0);
        return result;
    }
}
