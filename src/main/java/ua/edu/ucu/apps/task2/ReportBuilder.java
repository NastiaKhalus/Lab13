package ua.edu.ucu.apps.task2;

public class ReportBuilder {
    public ReportBuilder(Database db) {
        System.out.println("Building report using: " + db.getStatisticsData());
    }
}
