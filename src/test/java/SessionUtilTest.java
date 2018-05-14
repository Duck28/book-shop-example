import com.example.application.session.SessionUtil;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

public class SessionUtilTest implements SessionUtil {

    private static SessionUtilTest instance = new SessionUtilTest();
    private SessionFactory sessionFactory;

    public static SessionUtilTest getInstance() {
        return instance;
    }

    public SessionUtilTest() {
        Configuration config = new Configuration();
        config.configure("hibernate-test.cfg.xml");
        sessionFactory = config.buildSessionFactory();
    }

    public Session getSession() {
        return getInstance().sessionFactory.openSession();
    }
}
