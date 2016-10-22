package com.jetmoney.Bean;

import com.jetmoney.Entity.CarEntity;
import com.jetmoney.Entity.PitStopEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.security.Timestamp;

@Stateless
public class PitStopBean {
    @PersistenceContext(unitName = "Datasourceex")
    private EntityManager entityManager;

    /**
     * Car go into pitstop
     * @param carEntity car
     * @param in date go in pitStop
     */
    public void savePitStopIn(CarEntity carEntity, Timestamp in){
        PitStopEntity pitStopEntity = new PitStopEntity(in, carEntity);
        entityManager.persist(pitStopEntity);
    }

    /**
     * Car go out from pitStop and account money
     * @param carEntity some car
     * @param out time out
     */
    public void carGoOutFromPitStop(CarEntity carEntity, Timestamp out){
        String ql = "select distinct pitStop from PitStopEntity pitStop " +
                "where pitStop.carEntity = :car " +
                "and dateOut is null";
        Query query = entityManager.createQuery(ql);
        query.setParameter("car", carEntity);
        PitStopEntity pitStopEntity = (PitStopEntity) query.getSingleResult();
        pitStopEntity.setDateOut(out);
        pitStopEntity.setMoney(getCostParking(pitStopEntity.getDateIn(), out));
        entityManager.refresh(pitStopEntity);
    }

    /**
     *
     * @param in timestamp into pitstop
     * @param out timestamp out pitstop
     * @return cost by parking
     */
    private BigDecimal getCostParking(Timestamp in, Timestamp out){

        return new BigDecimal(Math.floor ((out.getTimestamp().getTime() - in.getTimestamp().getTime())/(1000*60))*100);
    }
}
