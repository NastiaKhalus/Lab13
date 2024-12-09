package ua.edu.ucu.apps.task2;

public class Auth {
    private final Авторизація авторизація = new Авторизація();

    public boolean auth(Database db) {
        return авторизація.авторизувати(db);
    }
}

