package com.jetmoney.Bean;

import com.jetmoney.Entity.CarEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class CarBean {
    @PersistenceContext(unitName = "DataSourceEx")
    private EntityManager entityManager;

    public CarBean() {
    }

    public List<CarEntity> getAllCars(){
        return entityManager.createQuery("select car from CarEntity car").getResultList();
    }

    /**
     * get all cars who now in parking
     * @return list cars
     */
    public List<CarEntity> getCarsInParking(){
        String hql = "select carEntity from ParkingEntity carEntity " +
                "where carEntity.dateOut is null";

        Query query = entityManager.createQuery(hql);
        return query.getResultList();
    }

    public boolean isCarInParking(CarEntity carEntity){
        String hql = "select count(*) from ParkingEntity parking " +
                "where parking.carEntity = :car " +
                "and parking.dateOut is null";

        Query query = entityManager.createQuery(hql);
        query.setParameter("car", carEntity);
        if(query.getResultList().size() > 1){
            System.out.println("Attention same cars in parking is " + query.getResultList().size());
        }
        boolean car = ((int)query.getSingleResult() == 1) ? true : false;
        return  car;
    }

    public void save(CarEntity car){
            entityManager.persist(car);
    }

}
