package com.jetmoney.Servlet;

import com.jetmoney.Bean.CarBean;
import com.jetmoney.Bean.CarDriver;
import com.jetmoney.Bean.PlaceParkingBean;
import com.jetmoney.Entity.CarEntity;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;


@WebServlet(urlPatterns = "/")
public class CarServlet extends HttpServlet {
    List<CarEntity> listCars;
    public static final int pitStopMax = 10;
    public static int freePlaceOnParking;
    public static Date today;
    @EJB
    private CarBean carBean;
    @EJB
    private PlaceParkingBean placeParkingBean;


    public CarServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            Date date = new Date();
            int carInParking = placeParkingBean.getCarsInPitStop(date);
            //check free place in parking
            freePlaceOnParking = pitStopMax - carInParking;
            //start cars
            startCarDriver();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //start driving cars in backgroun thread
    private void startCarDriver(){
        Thread carDriverThread = new Thread(new CarDriver());
        carDriverThread.setDaemon(true);
        carDriverThread.start();
    }


}
