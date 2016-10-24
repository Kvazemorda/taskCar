package com.jetmoney.Servlet;

import com.jetmoney.Bean.PlaceParkingBean;
import com.jetmoney.Entity.ParkingEntity;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = "/listCar")
public class CarServlet extends HttpServlet {
    @EJB
    private PlaceParkingBean parkingBean;

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



        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
