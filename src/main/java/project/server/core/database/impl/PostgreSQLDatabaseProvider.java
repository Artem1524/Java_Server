package project.server.core.database.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import project.server.core.database.DatabaseProvider;
import project.server.utility.dataprovider.DataProvider;

@Component
public class PostgreSQLDatabaseProvider implements DatabaseProvider {

    private static final Logger LOGGER = LogManager.getLogger(PostgreSQLDatabaseProvider.class);

    @Override
    public void startConnection() {
        int count = Thread.currentThread().getStackTrace().length;
        LOGGER.warn(Thread.currentThread().getStackTrace()[1/*count-1*/].getMethodName());
        LOGGER.info("startConnection");
    }

    @Override
    public void saveClientData(DataProvider data) {
        LOGGER.info("saveClientData");
        LOGGER.error(data.getStringData());
    }

    @Override
    public void closeConnection() {
        LOGGER.info("closeConnection");
    }
}
