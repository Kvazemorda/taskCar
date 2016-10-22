package com.jetmoney.Bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;


@Stateless
public class PlaceParkingBean {
    @PersistenceContext(unitName = "DataSourceEx")
    private EntityManager entityManager;

    public PlaceParkingBean() {
    }

    /**
     * Get count car it pitStop
     * @param today how many cars in pitStop currently
     * @return int cars in pit stop
     */
    public int getCarsInPitStop(Date today){
        String hql = "select count(*) from ParkingEntity carOnPitStop " +
                "where carOnPitStop.dateIn <= :timeNow " +
                "and (carOnPitStop.dateOut > :timeNow " +
                "or carOnPitStop.dateOut is null)";

        Query query = entityManager.createQuery(hql);
        query.setParameter("timeNow", today);
        System.out.println("car on place " + query.getResultList());
        int carOnPlace =  Integer.parseInt(query.getSingleResult().toString());

        return  carOnPlace;
    }

}
