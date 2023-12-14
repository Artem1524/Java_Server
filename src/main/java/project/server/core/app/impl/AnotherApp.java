package project.server.core.app.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import project.server.core.app.App;
import project.server.core.database.DatabaseProvider;
import project.server.utility.dataprovider.DataProvider;
import project.server.utility.dataprovider.impl.ServiceDataProvider;

import java.util.GregorianCalendar;

public class AnotherApp implements App {

    private DataProvider data;

    @Autowired
    @Qualifier("anotherAppDatabase")
    private DatabaseProvider database;

    @Override
    public void connectToDatabase() {
        database.startConnection();
    }

    @Override
    public void saveDataToDatabase() {
        database.saveClientData(data);
    }

    @Override
    public void closeDatabaseConnection() {
        database.closeConnection();
    }

    @Override
    public void loadProfileData() {
        data = new ServiceDataProvider()
                .withServiceName("Сберпрайм")
                .withStartDate(new GregorianCalendar(2023, 10, 1).getTime());
    }

    @Override
    public void close() throws Exception {
        database.closeConnection();
    }
}
