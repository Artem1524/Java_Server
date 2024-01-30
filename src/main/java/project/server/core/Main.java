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

    // private static App anotherApp;

    public static void main(String[] args) {

        LOGGER.info("Запускаем приложение...");

        try {
            ApplicationContext context = new ClassPathXmlApplicationContext(
                    "/src/main/webapp/WEB-INF/config/applicationContext.xml");

            mainApp = (App) context.getBean("mainApp");

            mainApp.run();
        } catch (Exception e) {
            LOGGER.error(e);
        }

        LOGGER.info("Приложение остановлено.");
    }
}
