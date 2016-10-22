package com.jetmoney.Bean;

import com.jetmoney.Entity.CarEntity;
import com.jetmoney.Entity.ParkingEntity;
import com.jetmoney.Servlet.CarServlet;

import javax.ejb.EJB;
import java.util.List;

public class CarDriver {
    @EJB
    CarBean carBean;


    /**
     * Car will be random drive into and out from pitstop;
     */
    public CarDriver(List<CarEntity> cars) {
        List<CarEntity> carEntities = carBean.getAllCars();
        for(CarEntity car: carEntities){
            if(!carBean.isCarInParking(car) && CarServlet.freePlaceOnParking < 10){
                ParkingEntity parkingEntity = new ParkingEntity()
            }
        }

    }
}
