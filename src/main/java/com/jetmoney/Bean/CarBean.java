package com.jetmoney.Bean;

import com.jetmoney.Entity.CarEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class CarBean {
    @PersistenceContext(unitName = "DataSourceEx")
    private EntityManager entityManager;

    public CarBean() {
    }

    public boolean isCarInParking(String number) {
        String hql = "select count(*) from ParkingEntity parking " +
                "where parking.carEntity.number = :number " +
                "and parking.dateOut is null";

        Query query = entityManager.createQuery(hql);
        query.setParameter("number", number);
        if (query.getResultList().size() > 1) {
            System.out.println("Attention same cars in parking is " + query.getResultList().size());
        }
        boolean car = ((long) query.getSingleResult() == 1) ? true : false;
        return car;
    }

    public void save(CarEntity car) {
        entityManager.persist(car);
    }

    public CarEntity getCar(String number) {
        String hql = "select parking.carEntity from ParkingEntity parking " +
                "where parking.carEntity.number = :number " +
                "and parking.dateOut is null";

        Query query = entityManager.createQuery(hql);
        query.setParameter("number", number);
        return (CarEntity) query.getSingleResult();
    }
}
