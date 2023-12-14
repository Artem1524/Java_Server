package project.server.core.database;

import project.server.utility.dataprovider.DataProvider;

public interface DatabaseProvider {
    void startConnection();
    void saveClientData(DataProvider data);
    void closeConnection();
}
