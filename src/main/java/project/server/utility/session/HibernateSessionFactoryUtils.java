package project.server.utility.session;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import project.server.base.dto.ClientDto;

public class HibernateSessionFactoryUtils {

    private static final Logger LOGGER = LogManager.getLogger(HibernateSessionFactoryUtils.class);
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtils() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();

                configuration.addAnnotatedClass(ClientDto.class);
                StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties());

                sessionFactory = configuration.buildSessionFactory(registryBuilder.build());
            } catch (Exception e) {
                LOGGER.error(e);
            }
        }
        return sessionFactory;
    }
}
