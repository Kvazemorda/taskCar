package com.jetmoney.Bean;

import com.jetmoney.Entity.CarEntity;
import com.jetmoney.Entity.ParkingEntity;
import com.jetmoney.Servlet.CarServlet;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
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
     * Car go into pitstop
     * @param carEntity car
     * @param in date go in pitStop
     */
    public void savePitStopIn(CarEntity carEntity, Date in){
        if(CarServlet.freePlaceOnParking > 0) {
            ParkingEntity parkingEntity = new ParkingEntity(in, carEntity);
            entityManager.persist(parkingEntity);
        }
    }

    /**
     * Car go out from pitStop and account money
     * @param id id pitStop
     * @param out time out
     */
    public void carGoOutFromPitStop(long id, Date out){
        String ql = "select distinct pitStop from ParkingEntity pitStop " +
                "where pitStop.id = :id " +
                "and dateOut is null";
        Query query = entityManager.createQuery(ql);
        query.setParameter("id", id);
        ParkingEntity parkingEntity = (ParkingEntity) query.getSingleResult();
        parkingEntity.setDateOut(out);
        parkingEntity.setMoney(getCostParking(parkingEntity.getDateIn(), out));
        entityManager.merge(parkingEntity);
    }

    /**
     *
     * @param in timestamp into pitstop
     * @param out timestamp out pitstop
     * @return cost by parking
     */
    private BigDecimal getCostParking(Date in, Date out){
        double time = out.getTime() - in.getTime();
        double hour = 3600000.0;
        double hours = Math.ceil(time/hour) * 100;
        return new BigDecimal(hours);
    }
}
