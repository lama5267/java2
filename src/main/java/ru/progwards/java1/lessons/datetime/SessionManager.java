package ru.progwards.java1.lessons.datetime;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class SessionManager {
    private int sessionValid;
    private HashMap<Integer, UserSession> sessions = new HashMap<>();

    public SessionManager(int sessionValid) {
        this.sessionValid = sessionValid;
    }

    public void add(UserSession userSession) {//добавляет новую сессию пользователя
        sessions.put(userSession.getSessionHandle(), userSession);
    }

    public UserSession find(String userName) {// - проверяет наличие существующей сессии по userName
        for (Map.Entry map : sessions.entrySet()) {
            if (((UserSession) (map.getValue())).getUserName().equals(userName)) {
                if (((((UserSession) map).getLastAccess()).plusSeconds(sessionValid)).isAfter(Instant.now())) {
                    return null;
                }
                ((UserSession) map).updateLastAccess();
                return (UserSession) map;
            }
        }
        return null;
    }
    public UserSession get(int sessionHandle) {// - проверяет наличие существующей сессии по хендлу.
if (sessions.containsKey(sessionHandle)){
    if ((((sessions.get(sessionHandle)).getLastAccess()).plusSeconds(sessionValid)).isBefore(Instant.now())) {
        return null;
    }
    (sessions.get(sessionHandle)).updateLastAccess();
    return sessions.get(sessionHandle);
    }
        return null;
    }
    public void delete(int sessionHandle) {// - удаляет указанную сессию пользователя
sessions.remove(sessionHandle);
    }
    public void deleteExpired(){// - удаляет все сессии с истекшим сроком годности.
        for (Object x:sessions.keySet().toArray()){
            if ((((sessions.get(x)).getLastAccess()).plusSeconds(sessionValid)).isBefore(Instant.now())) {
                sessions.remove(x);
            }
            }
    }
    public static void main(String[] args) {
        SessionManager test = new SessionManager(6);
        /*
        Протестировать следующим образом:
        Создать сессию по userName, для этого
                - сделать find,
                - убедиться что вернется null
                - создать новую сессию
        - добавить используя add
        */

        System.out.println(test.find("userName"));
        UserSession tt = new UserSession("userName");
        System.out.println(tt.toString());
        test.add(tt);
        /*
        Вызвать несколько раз get
        */

        System.out.println(test.get(tt.getSessionHandle()));
        System.out.println(test.get(tt.getSessionHandle()));
        System.out.println(test.get(tt.getSessionHandle()));

        /*
        Подождать (Thread.sleep) время, большее, чем время валидности
        */
        try {
            Thread.sleep(7_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*
        Проверить что сессии нет через метод get
        */
        System.out.println(test.get(tt.getSessionHandle()));
        /*
        Создать еще одну сессию
        */
        System.out.println(test.find("userName1"));
        UserSession tt1 = new UserSession("userName1");
        System.out.println(tt1.toString());
        test.add(tt1);
        /*
        Подождать половину времени валидности сессии
        */
        try {
            Thread.sleep(3_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*
        Создать еще одну сессию
        */
        System.out.println(test.find("userName2"));
        UserSession tt2 = new UserSession("userName2");
        System.out.println(tt2.toString());
        test.add(tt2);
        /*
        Подождать еще раз половину времени валидности сессии
        */
        try {
            Thread.sleep(3_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*
        Вызвать deleteExpired()
        */
        test.deleteExpired();
        /*
        Убедиться, что одна сессия удалена, вторая нет
        */
        System.out.println(test.get(tt1.getSessionHandle()));
        System.out.println(test.get(tt2.getSessionHandle()));
        /*
        Удалить оставшуюся через метод delete
        */
        test.delete(tt2.getSessionHandle());
        /*
        Убедиться что удаление прошло
        */
        System.out.println(test.get(tt2.getSessionHandle()));
        for (StatisticInfo u : Profiler.getStatisticInfo()) {
            System.out.println(u.toString());

        }


    }
}