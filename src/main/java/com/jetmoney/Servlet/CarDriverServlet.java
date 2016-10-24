package com.jetmoney.Servlet;

import com.jetmoney.Bean.CarBean;
import com.jetmoney.Bean.ParkingBean;
import com.jetmoney.Bean.PlaceParkingBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Car will be random drive into and out from pitstop;
 */
@WebServlet (urlPatterns = "/carIn")
public class CarDriverServlet extends HttpServlet {
    public static final int pitStopMax = 10;
    public static int freePlaceOnParking;
    public Date date;
    @EJB
    private PlaceParkingBean placeParkingBean;
    @EJB
    private CarBean carBean;
    @EJB
    private ParkingBean parkingBean;

    public CarDriverServlet() {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        String number = req.getParameter("number");
        resp.sendRedirect();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //int carInParking = placeParkingBean.getCarsInPitStop();
        //check free place in parking
        //freePlaceOnParking = pitStopMax - carInParking;


    }
/*
    public void carsStart(){
        //get all car in data base
        List<CarEntity> carEntities = carBean.getAllCars();
        System.out.println("Car in dataBase - " + carEntities.size());
        while (true){
            for(CarEntity car: carEntities){
                // car go in parking if is a car is not paring now and in parking has free place
                if(!carBean.isCarInParking(car) && CarServlet.freePlaceOnParking > 0){
                    parkingBean.savePitStopIn(car, new Date());
                    CarServlet.freePlaceOnParking--;
                    System.out.println("Free place in parking is " + CarServlet.freePlaceOnParking);
                }}
                // car start go out from parking
                for(CarEntity car: carEntities){
                if(CarServlet.freePlaceOnParking == 0 && carBean.isCarInParking(car)){
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

    }*/

}
