package com.example.application.session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

@Component
public class SessionUtilImpl implements SessionUtil{

    private static SessionUtilImpl instance = new SessionUtilImpl();
    private SessionFactory sessionFactory;

    public static SessionUtilImpl getInstance() {
        return instance;
    }

    private SessionUtilImpl() {
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        sessionFactory = config.buildSessionFactory();
    }

    public Session getSession() {
        return getInstance().sessionFactory.openSession();
    }
}