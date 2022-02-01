package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;
import services.CheckListService;

import java.io.IOException;

//сервлет для обработки авторизации
@WebServlet("/authorization")
public class AuthorizationServlet extends HttpServlet {
    //для соединения с бд
    private CheckListService service;

    @Override
    public void init(){
        this.service = new CheckListService();
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) {
        try{
            //имя и пароль из формы
            String name = request.getParameter("name");
            String password = request.getParameter("password");

            //проверка авторизации
            if(service.isAuthorization(name, password) == true) {
                request.getServletContext().
                        getRequestDispatcher("/welcome.html").
                        forward(request, response);
            }

            else {
                request.getServletContext().
                        getRequestDispatcher("/authorization.jsp").
                        forward(request, response);
            }

        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }
}
