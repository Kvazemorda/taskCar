package com.jetmoney.Bean;

import com.jetmoney.Entity.CarEntity;
import com.jetmoney.Entity.ParkingEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.security.Timestamp;

@Stateless
public class ParkingBean {
    @PersistenceContext(unitName = "DataSourceEx")
    private EntityManager entityManager;

    /**
     * Car go into pitstop
     * @param carEntity car
     * @param in date go in pitStop
     */
    public void savePitStopIn(CarEntity carEntity, Timestamp in){
        ParkingEntity parkingEntity = new ParkingEntity(in, carEntity);
        entityManager.persist(parkingEntity);
    }

    /**
     * Car go out from pitStop and account money
     * @param carEntity some car
     * @param out time out
     */
    public void carGoOutFromPitStop(CarEntity carEntity, Timestamp out){
        String ql = "select distinct pitStop from ParkingEntity pitStop " +
                "where pitStop.carEntity = :car " +
                "and dateOut is null";
        Query query = entityManager.createQuery(ql);
        query.setParameter("car", carEntity);
        ParkingEntity parkingEntity = (ParkingEntity) query.getSingleResult();
        parkingEntity.setDateOut(out);
        parkingEntity.setMoney(getCostParking(parkingEntity.getDateIn(), out));
        entityManager.refresh(parkingEntity);
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
