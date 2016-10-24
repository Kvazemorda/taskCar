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


@WebServlet(urlPatterns = "/getCar")
public class GetCarServlet extends HttpServlet {
    public static final int pitStopMax = 10;
    public static int freePlaceOnParking;
    @EJB
    private PlaceParkingBean parkingBean;
    @EJB
    private CarBean carBean;

    public GetCarServlet() {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{

            String number = req.getParameter("number");
            CarEntity carEntity = carBean.getCar(number);

            req.setAttribute("car", carEntity);

            // отправляем request на jsp
            req.getRequestDispatcher("/getCar.jsp").forward(req, resp);


        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
