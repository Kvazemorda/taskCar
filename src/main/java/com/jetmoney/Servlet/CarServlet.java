package com.jetmoney.Servlet;

import com.jetmoney.Bean.CarBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(urlPatterns = "/cars")
public class CarServlet extends HttpServlet {

    @EJB
    private CarBean carBean;
    public CarServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try{
            PrintWriter out = resp.getWriter();
            out.println("prinln " + carBean.getAllCars());

        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
