package com.jetmoney.Entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.security.Timestamp;


@Entity
@Table (name = "PitStopEntity")
public class PitStopEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column
    Timestamp dateIn;
    @Column
    Timestamp dateOut;
    @Column
    BigDecimal money;
    @ManyToOne
    CarEntity carEntity;

    public PitStopEntity() {
    }

    public PitStopEntity(Timestamp dateIn, CarEntity carEntity, BigDecimal money) {
        this.dateIn = dateIn;
        this.carEntity = carEntity;
        this.money = money;
    }

    public PitStopEntity(Timestamp dateIn, CarEntity carEntity) {
        this.dateIn = dateIn;
        this.carEntity = carEntity;
    }

    public Timestamp getDateIn() {
        return dateIn;
    }

    public void setDateIn(Timestamp dateIn) {
        this.dateIn = dateIn;
    }

    public Timestamp getDateOut() {
        return dateOut;
    }

    public void setDateOut(Timestamp dateOut) {
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

        PitStopEntity that = (PitStopEntity) o;

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
