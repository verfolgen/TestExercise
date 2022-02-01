package services;

import dao.CheckListDAOImpl;
import dao.DAOCheck;
import models.CheckList;
import models.User;

import java.util.List;

public class  CheckListService {
    private final DAOCheck checkDAO = new CheckListDAOImpl();

    public CheckListService() {

    }

    //возврат всех попыток
    public List<CheckList> findAllCheck() {
        return checkDAO.findALL();
    }

    //сохранение попытки в коллекцию
    public void saveCheck(CheckList checkList) {
        checkDAO.save(checkList);
    }

    //сохранение пользователя в бд
    public void saveUser(User user) {
         checkDAO.saveUser(user);}

    //вычисление среднего числа
    public Double getAverage() {
        return checkDAO.average();
    }

    //проверка наличия элемента для ргистрации
    public boolean isExistRegistration(String name) {
        return checkDAO.Registration(name);
    }

    //проверка для авторизации
    public boolean isAuthorization (String name, String password) {
        return checkDAO.Authorization(name, password);
    }
}
