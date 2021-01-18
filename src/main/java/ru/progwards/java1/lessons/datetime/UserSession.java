package ru.progwards.java1.lessons.datetime;

import java.time.Instant;
import java.util.Random;

public class UserSession {
    private int sessionHandle;
    private String userName;
    private Instant lastAccess;//дата время

    public UserSession(String userName) {
        this.userName = userName;
        sessionHandle=new Random().nextInt(100);//сгенерировать sessionHanle случайное число
        lastAccess= Instant.now();//текущее время доступа.
    }

    @Override
    public String toString() {
        return "UserSession{" +
                "sessionHandle=" + sessionHandle +
                ", userName='" + userName + '\'' +
                ", lastAccess=" + lastAccess +
                '}';
    }

    public int getSessionHandle() {
        return sessionHandle;
    }

    public String getUserName() {
        return userName;
    }

    public Instant getLastAccess() {
        return lastAccess;
    }
    public void updateLastAccess() {//-  обновляет время доступа к сессии
        lastAccess = Instant.now();
    }

}
