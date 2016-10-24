package com.jetmoney.Servlet;

import com.jetmoney.Bean.CarBean;
import com.jetmoney.Bean.PlaceParkingBean;
import com.jetmoney.Entity.CarEntity;
import com.jetmoney.Entity.ParkingEntity;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;


@WebServlet(urlPatterns = "/listCar")
public class CarServlet extends HttpServlet {
    public static final int pitStopMax = 10;
    public static int freePlaceOnParking;
    @EJB
    private PlaceParkingBean parkingBean;
    @EJB
    private CarBean carBean;

    public CarServlet() {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            // Получаем список пользователей
            List<ParkingEntity> carsList = parkingBean.getCarsInPitStop();

            // добавляем полученный список в request,
            // который отправится на jsp
            req.setAttribute("cars", carsList);

            //check free place in parking
            int carInParking = parkingBean.getCarsInPitStop().size();
            freePlaceOnParking = pitStopMax - carInParking;

            req.setAttribute("freePlace", freePlaceOnParking);

            // отправляем request на jsp
            req.getRequestDispatcher("/listCar.jsp").forward(req, resp);


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            resp.setContentType("text/html");
            req.setCharacterEncoding("UTF-8");

            String number = req.getParameter("number");
            String brandName = req.getParameter("brandName");
            CarEntity newCar = new CarEntity(number, brandName);
            // check car in the parking
            if(!carBean.isCarInParking(number)){
                carBean.save(newCar);
                parkingBean.savePitStopIn(newCar, new Date());
            }
          resp.sendRedirect("listCar");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static int getFreePlaceOnParking() {
        return freePlaceOnParking;
    }
}
