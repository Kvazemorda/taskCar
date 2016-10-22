package com.jetmoney.Servlet;

import com.jetmoney.Bean.CarBean;
import com.jetmoney.Entity.CarEntity;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = "/cars")
public class CarServlet extends HttpServlet {
    List<CarEntity> listCars;

    @EJB
    private CarBean carBean;
    public CarServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            listCars = carBean.getAllCars();

        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
