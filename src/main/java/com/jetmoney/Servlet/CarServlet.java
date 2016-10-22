package com.jetmoney.Servlet;

import com.jetmoney.Bean.CarBean;
import com.jetmoney.Bean.PlaceParkingBean;
import com.jetmoney.Entity.CarEntity;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;


@WebServlet(urlPatterns = "/")
public class CarServlet extends HttpServlet {
    List<CarEntity> listCars;
    public static final int pitStopMax = 10;
    public static int freePlaceOnParking;
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
            //check free place in parking
            Date date = new Date();
            int carInParking = placeParkingBean.getCarsInPitStop(date);
            freePlaceOnParking = pitStopMax - carInParking;

            PrintWriter writer = resp.getWriter();
            writer.println(freePlaceOnParking);

            listCars = carBean.getAllCars();
            System.out.println(listCars);
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
