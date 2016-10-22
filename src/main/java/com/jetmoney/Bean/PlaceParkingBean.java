package com.jetmoney.Bean;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;

@Singleton
public class PlaceParkingBean {
    public static int carsInPitStop;
    @PersistenceContext(unitName = "DataSourceEx")
    private static EntityManager entityManager;

    public PlaceParkingBean() {
    }

    /**
     * Get count car it pitStop
     * @param today how many cars in pitStop currently
     * @return int cars in pit stop
     */
    public static int getCarsInPitStop(Date today){
        String hql = "select carOnPitStop from ParkingEntity carOnPitStop " +
                "where carOnPitStop.dateIn <= :timeNow " +
                "and carOnPitStop.dateOut > :timeNow";

        Query query = entityManager.createQuery(hql);
        query.setParameter("timeNow", today);

        return carsInPitStop = query.getResultList().size();
    }

}
