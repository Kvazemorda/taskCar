package com.jetmoney.Bean;

import com.jetmoney.Entity.CarEntity;
import com.jetmoney.Servlet.CarServlet;

import javax.ejb.EJB;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Car will be random drive into and out from pitstop;
 */
public class CarDriver implements Runnable {
    @EJB
    CarBean carBean;
    @EJB
    ParkingBean parkingBean;

    public CarDriver() {

    }

    public void carsStart(){
        //get all car in data base
        List<CarEntity> carEntities = carBean.getAllCars();
        while (true){
            for(CarEntity car: carEntities){
                // car go in parking if is a car is not paring now and in parking has free place
                if(!carBean.isCarInParking(car) && CarServlet.freePlaceOnParking > 0){
                    parkingBean.savePitStopIn(car, new Date());

                    CarServlet.freePlaceOnParking--;
                    System.out.println("Free place in parking is " + CarServlet.freePlaceOnParking);
                    // car start go out from parking
                }else if(CarServlet.freePlaceOnParking == 0 && carBean.isCarInParking(car)){
                    Date date = new Date();
                    Random random = new Random();
                    long timeRest = random.nextInt(9) * 10000;
                    date.setTime(date.getTime() + timeRest);
                    parkingBean.carGoOutFromPitStop(car, date);
                    CarServlet.freePlaceOnParking++;
                    System.out.println("Free place in parking is " + CarServlet.freePlaceOnParking);
                }
            }
            try {
                Thread.sleep(1000*10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void run() {
        carsStart();
    }
}
