import ua.edu.ucu.apps.task2.БазаДаних;
import ua.edu.ucu.apps.task2.Авторизація;
import ua.edu.ucu.apps.task2.Database;
import ua.edu.ucu.apps.task2.Auth;
import ua.edu.ucu.apps.task2.ReportBuilder;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Task2Tests {

    @Test
    public void testБазаДаних() {
        БазаДаних базаДаних = new БазаДаних();

        assertEquals("User Data", базаДаних.отриматиДаніКористувача());
        assertEquals("Statistics Data", базаДаних.отриматиСтатистичніДані());
    }

    @Test
    public void testАвторизація() {
        БазаДаних базаДаних = new БазаДаних();
        Авторизація авторизація = new Авторизація();

        assertTrue(авторизація.авторизувати(базаДаних));
    }

    @Test
    public void testDatabase() {
        Database db = new Database();

        assertEquals("User Data", db.getUserData());
        assertEquals("Statistics Data", db.getStatisticsData());
    }

    @Test
    public void testAuth() {
        Database db = new Database();
        Auth auth = new Auth();

        assertTrue(auth.auth(db));
    }

    @Test
    public void testReportBuilder() {
        Database db = new Database();
        ReportBuilder reportBuilder = new ReportBuilder(db);

        assertNotNull(reportBuilder);
    }

    @Test
    public void testMain() {
        Database db = new Database();
        Auth auth = new Auth();

        if (auth.auth(db)) {
            ReportBuilder reportBuilder = new ReportBuilder(db);
            assertNotNull(reportBuilder);
        }
    }
}

