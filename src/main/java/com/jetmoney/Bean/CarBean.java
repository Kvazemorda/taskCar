package com.jetmoney.Bean;

import com.jetmoney.Entity.CarEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CarBean {

    @PersistenceContext(unitName = "DataSourceEx")
    private EntityManager entityManager;

    public CarBean() {
    }

    public List<String> getAllCars(){
        return entityManager.createQuery("select car from CarEntity car").getResultList();
    }

    public void save(CarEntity car){
            entityManager.persist(car);
    }
}
