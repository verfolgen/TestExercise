package utils;

//класс получения sessionFactory, реализован как синглтон т.к тяжеловесный

import models.CheckList;
import models.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import jakarta.persistence.criteria.*;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {}

    public static SessionFactory getSessionFactory () {
        if(sessionFactory == null) {
            try{
                Configuration config  = new Configuration().configure().
                        addAnnotatedClass(CheckList.class).addAnnotatedClass(User.class);

                StandardServiceRegistryBuilder builder =
                        new StandardServiceRegistryBuilder().
                                applySettings(config.getProperties());

                sessionFactory = config.buildSessionFactory(builder.build());
            } catch (HibernateException e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
