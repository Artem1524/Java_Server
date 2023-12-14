package project.server.core.app.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import project.server.core.app.App;
import project.server.core.database.DatabaseProvider;
import project.server.utility.dataprovider.DataProvider;
import project.server.utility.dataprovider.impl.ClientDataProvider;

import java.math.BigDecimal;

public class MainApp implements App {

    private DataProvider data;

    @Autowired
    @Qualifier("mainAppDatabase")
    private DatabaseProvider database;

    @Override
    public void connectToDatabase() {
        database.startConnection();
    }

    @Override
    public void saveDataToDatabase() {
        database.saveClientData(data);
    }

    /*@Override
    public void saveDataToDatabase(DataProvider data) {
        database.saveClientData(data);
    }*/



    @Override
    public void closeDatabaseConnection() {
        database.closeConnection();
    }

    @Override
    public void loadProfileData() {
        data = new ClientDataProvider()
                .withFirstName("Витя")
                .withFamilyName("Иванов")
                .withSecondName("Иванович")
                .withClientInfoData(new BigDecimal(1230), 100);
    }

    @Override
    public void close() throws Exception {
        database.closeConnection();
    }
}
