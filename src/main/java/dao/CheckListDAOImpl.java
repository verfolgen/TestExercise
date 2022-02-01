package dao;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.EntityManagerFactory;
import models.CheckList;
import models.User;
import org.hibernate.QueryTimeoutException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;
import jakarta.persistence.criteria.*;
import jakarta.persistence.NoResultException;

import java.util.List;

public class CheckListDAOImpl implements DAOCheck<CheckList> {
    //список попыток
    private List<CheckList> checkLists;

    private Double avgNumber;

    //указатель для регистрации
    private boolean isExists = false;

    //указатель для авторизации
    private boolean authorize = false;

    //выводим все попытки
    public List<CheckList> findALL() {
        //открываем сессию
        try (Session session = HibernateSessionFactoryUtil.
                getSessionFactory().
                openSession()) {

            CriteriaBuilder cb = session.getCriteriaBuilder();


            //получаем объект CriteriaQuery
            CriteriaQuery<CheckList> cq = cb.createQuery(CheckList.class);

            //получаем объект Root
            Root<CheckList> root = cq.from(CheckList.class);

            //select
            cq.select(root).orderBy(cb.asc
                    (root.get("trycount")));


            Transaction tx = session.beginTransaction();

            Query query = session.createQuery(cq);

            checkLists = query.getResultList();

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return checkLists;
    }


    //метод сохраняющий результат
    public void save(CheckList check) {
        try (
                Session session = HibernateSessionFactoryUtil.
                        getSessionFactory().openSession()) {

            Transaction tx = session.beginTransaction();

            session.save(check);


            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //метод для добавления пользователя
    public void saveUser(User user) {
        try (
                Session session = HibernateSessionFactoryUtil.
                        getSessionFactory().openSession()) {

            Transaction tx = session.beginTransaction();

            session.save(user);

            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //метод для вычисления среднего
    public Double average() {
        try (
                Session session = HibernateSessionFactoryUtil.
                        getSessionFactory().openSession()) {

            Transaction tx = session.beginTransaction();


            CriteriaBuilder cb = session.getCriteriaBuilder();

            CriteriaQuery<Double> cr = cb.createQuery(Double.class);

            Root<CheckList> root = cr.from(CheckList.class);

            cr.select(cb.avg(root.get("trycount")));

            avgNumber = (Double) Math.ceil(session.createQuery(cr).getSingleResult());

            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return avgNumber;
    }

    //метод проверяющий наличие логина в бд
    public boolean Registration(String name) {

        //открываем сессию

        try (Session session = HibernateSessionFactoryUtil.
                getSessionFactory().
                openSession()) {

            CriteriaBuilder cb = session.getCriteriaBuilder();


            //получаем объект CriteriaQuery
            CriteriaQuery<User> cq = cb.createQuery(User.class);

            //получаем объект Root
            Root<User> root = cq.from(User.class);

            //select

            cq.select(root).where(cb.equal(root.get("name"),
                    name));

            Query query = session.createQuery(cq);

            User user = (User) query.getSingleResult();
            if (user.getName().equals(name)) {
                isExists = false;
                System.out.println(isExists);
            }


        } catch (NoResultException e) {
            isExists = true;
            e.printStackTrace();
        }
        return isExists;
    }

    //метод проверяющий пароль и пропускающие в систему
    public boolean Authorization(String name, String password) {
        //открываем сессию

        try (Session session = HibernateSessionFactoryUtil.
                getSessionFactory().
                openSession()) {

            CriteriaBuilder cb = session.getCriteriaBuilder();


            //получаем объект CriteriaQuery
            CriteriaQuery<User> cq = cb.createQuery(User.class);

            //получаем объект Root
            Root<User> root = cq.from(User.class);

            //условие для сравнивания строк
            Predicate [] predicates = new Predicate[2];
            predicates[0] = cb.equal(root.get("name"),
                    name);
            predicates[1] = cb.equal(root.get("password"),
                    password);

            cq.select(root).where(predicates);

            Query query = session.createQuery(cq);

            User user = (User) query.getSingleResult();

            if(name.equals(user.getName()) & password.equals(user.getPassword())) {
                authorize = true;
            }


        } catch (NoResultException e) {
            authorize = false;
            e.printStackTrace();
        }
        return authorize;
    }
}
