package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;
import services.CheckListService;

import java.io.IOException;

//сервлет для обработки регистрации
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
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

            if(service.isExistRegistration(name) == true) {
                User user = new User(name, password);
                service.saveUser(user);

                request.getServletContext().
                        getRequestDispatcher("/password.jsp").
                        forward(request, response);
            }
            else {
                request.getServletContext().
                        getRequestDispatcher("/registration.jsp").
                        forward(request, response);
            }


        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }
}
