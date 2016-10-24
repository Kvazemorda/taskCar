package com.jetmoney.Bean;

import com.jetmoney.Entity.ParkingEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;


@Stateless
public class PlaceParkingBean {
    @PersistenceContext(unitName = "DataSourceEx")
    private EntityManager entityManager;

    public PlaceParkingBean() {
    }

    /**
     * Get list car in pitStop
     * @return int cars in pit stop
     */
    public List<ParkingEntity> getCarsInPitStop(){
        String hql = "select carOnPitStop from ParkingEntity carOnPitStop " +
                "where carOnPitStop.dateOut is null " +
                "and carOnPitStop.dateIn is not null";

        Query query = entityManager.createQuery(hql);
        List<ParkingEntity> carInPark =  query.getResultList();
        return  carInPark;
    }

    /**
     * get last date car out from parking
     * @return last date out
     */
    public Date getLastDate(){
        String hql = "select max(parking.dateOut) from ParkingEntity parking";

        Query query = entityManager.createQuery(hql);
        Date date = (Date) query.getSingleResult();
        if (date == null){
            return new Date();
        }else {
            return date;
        }
    }
}
