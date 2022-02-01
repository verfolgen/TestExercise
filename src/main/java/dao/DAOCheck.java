package dao;

import models.CheckList;
import models.User;

import java.util.List;

public interface DAOCheck<T>{
    //метод, выводящий все числа
    List <T> findALL();

    //метод, сохранящий число в коллекцию
    void save (CheckList check);

    //метод, выводящий среднее число
    Double average();

    //метод сохраняющий юзера
    void saveUser(User user);

    //метод отвечающий за регистрацию пользователя в бд
    boolean Registration (String name);

    //метод отвечающий за авторизацию пользователя в бд
    boolean Authorization (String name, String password);





}
