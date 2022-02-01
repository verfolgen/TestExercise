package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logic.ExaminationLogic;
import models.CheckList;
import random.RandomNumber;
import services.CheckListService;
import transformation.TransformationForm;
import trystorage.TryRepository;
import trystorage.TryRepositoryImpl;
import validation.ValidationData;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet("/game")
public class GameServlet extends HttpServlet {
private HashSet<Integer> list1;

    //ссылка на хранилище попыток
    private TryRepository tryRepository;

    //счетчик количества попыток
    private Integer count = 0;

    //для соединения с бд
    private  CheckListService service;

    //инициализация сервлета
    @Override
    public void init(){
        this.tryRepository = new TryRepositoryImpl();
        this.service = new CheckListService();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        try {
            list1 = RandomNumber.getRandomNumber();
            System.out.println(list1);

            //передача коллекции в jsp
            request.setAttribute("list1", list1);

            //обнуление попыток перед стартом
            count = 0;


            request.getServletContext().getRequestDispatcher("/maingame.jsp").forward(request, response);
        }catch (IOException | ServletException e) {
            e.printStackTrace();
        }
}

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {


        //считывание данных пользователя с формы
        String resultRequest =  request.getParameter("number");
         //валидация входных данных (чтобы были только числа и 4 числа) иначе перенаправляем без внесения
        try{
        if(ValidationData.validation(resultRequest) == false) {
            String error = "Вы ввели некорректное число";

            //вывод системного сообщения
            request.setAttribute("result", error);

            request.getServletContext().getRequestDispatcher("/maingame.jsp").
                    forward(request, response);

        } else {


            //для проверки
            int [] numArr = TransformationForm.transformationFormData(resultRequest);

            //коллекция для подачи на вход проверяющему методу
            ArrayList<Integer> list2 = new ArrayList<>();

            //заполнение коллекции числами
            for(int i = 0; i < numArr.length; i++) {
                list2.add(numArr[i]);
            }

            //выполнение логики проверки
            try {

                String result = ExaminationLogic.examineLogic(list1, list2);
                request.setAttribute("result", result);

                //записываем в коллекцию попыток
                tryRepository.save(resultRequest + " - "+ result);

                //получаем и передаем в jsp
                List<String> objectList = tryRepository.findAll();
                request.setAttribute("tries", objectList);

                //увеличение количества попыток
                count++;


                //условие победы в игре
                if((result.equals("4Б0К"))) {

                    //новый объект для сохранения количества попыток
                    CheckList checkList = new CheckList(count);
                    service.saveCheck(checkList);

                    String win = ("Поздравляю! " +
                            "Вы победили. Количество попыток: " + count);
                    request.setAttribute("result", win);
                    tryRepository.deleteTry(objectList);
                    doGet(request, response);
                }

                request.getServletContext().getRequestDispatcher("/maingame.jsp").
                        forward(request, response);
            } catch (IOException | ServletException e) {
                e.printStackTrace();
            }
        }
        }catch (IOException | ServletException e) {
            e.printStackTrace();
        }

    }
}
