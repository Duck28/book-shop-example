package com.example.application.session;

import org.hibernate.SessionFactory;

public interface SessionUtil {

    SessionFactory getSessionFactory();
    void shutdown();
}
