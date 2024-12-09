package ua.edu.ucu.apps.task2;

public class Авторизація {
    public boolean авторизувати(БазаДаних базаДаних) {
        System.out.println("Authenticating: " + базаДаних.отриматиДаніКористувача());
        return true;
    }
}

