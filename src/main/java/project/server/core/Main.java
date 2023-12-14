package project.server.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import project.server.core.app.App;

// @Jetty
public class Main {

    public static final Logger LOGGER = LogManager.getLogger(Main.class);

    private static App mainApp;

    private static App anotherApp;

    public static void main(String[] args) {

        LOGGER.info("Запускаем приложение...");

        try {
            ApplicationContext context = new ClassPathXmlApplicationContext(
                    "/applicationContext.xml");

            mainApp = (App) context.getBean("mainApp");
            anotherApp = (App) context.getBean("anotherApp");

            mainApp.connectToDatabase();
            mainApp.loadProfileData();
            mainApp.saveDataToDatabase();
            mainApp.closeDatabaseConnection();

            anotherApp.connectToDatabase();
            anotherApp.loadProfileData();
            anotherApp.saveDataToDatabase();
            anotherApp.closeDatabaseConnection();
        } catch (Exception e) {
            LOGGER.error(e);
        }

        LOGGER.info("Приложение остановлено.");
    }
}
