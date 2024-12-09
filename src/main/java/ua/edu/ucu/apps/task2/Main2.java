package ua.edu.ucu.apps.task2;

public class Main2 {
    public static void main(String[] args) {
        Database db = new Database();
        Auth auth = new Auth();
        if(auth.auth(db)){
            ReportBuilder br = new ReportBuilder(db);
        }
    }
    
}
