package com.jetmoney.Servlet;

import com.jetmoney.Bean.CarBean;
import com.jetmoney.Bean.PlaceParkingBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;


@WebServlet(urlPatterns = "/getOut")
public class CarGetOutServlet extends HttpServlet {
    @EJB
    private PlaceParkingBean parkingBean;
    @EJB
    private CarBean carBean;

    public CarGetOutServlet() {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            if(req.getParameter("id") != null && req.getParameter("id") != ""){
                long id = Long.parseLong(req.getParameter("id"));
                parkingBean.carGoOutFromPitStop(id, new Date());
                resp.sendRedirect("listCar");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
