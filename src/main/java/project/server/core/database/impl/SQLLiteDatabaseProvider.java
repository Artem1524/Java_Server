package project.server.core.database.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import project.server.core.database.DatabaseProvider;
import project.server.utility.dataprovider.DataProvider;

@Component
public class SQLLiteDatabaseProvider implements DatabaseProvider {

    public static final Logger LOGGER = LogManager.getLogger(SQLLiteDatabaseProvider.class);

    @Override
    public void startConnection() {
        LOGGER.info("startConnection");
    }

    @Override
    public void saveClientData(DataProvider data) {
        LOGGER.info("saveClientData");
    }

    @Override
    public void closeConnection() {
        LOGGER.info("closeConnection");
    }
}
