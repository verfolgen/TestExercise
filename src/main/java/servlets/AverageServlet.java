package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.CheckList;
import random.RandomNumber;
import services.CheckListService;
import trystorage.TryRepositoryImpl;

import java.io.IOException;

@WebServlet("/average")
public class AverageServlet extends HttpServlet {
    //для соединения с бд
    private CheckListService service;

    @Override
    public void init(){
        this.service = new CheckListService();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        try {
            Double average = service.getAverage();
            System.out.println(average);
            //передача коллекции в jsp
            request.setAttribute("average", average);

            request.getServletContext().getRequestDispatcher("/average.jsp").forward(request, response);
        }catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

}
