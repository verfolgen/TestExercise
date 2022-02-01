package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.CheckList;
import services.CheckListService;

import java.io.IOException;
import java.util.List;

@WebServlet("/table")
public class TableServlet extends HttpServlet {

    //для соединения с бд
    private CheckListService service;

    @Override
    public void init(){
        this.service = new CheckListService();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try{

            //создаем коллекцию
            List<CheckList> checks = service.findAllCheck();

            //задаем атрибут коллекции и перенаправляем дальше
            request.setAttribute("checksFromServer", checks);

            request.getServletContext().getRequestDispatcher("/table.jsp").forward(request, response);

        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }
}
