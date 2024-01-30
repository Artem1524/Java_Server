package project.server.core.app.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.Nullable;
import org.springframework.util.CollectionUtils;
import project.server.core.app.App;
import project.server.core.database.DatabaseProvider;
import project.server.service.ClientDatabaseService;
import project.server.base.dto.ClientDto;

import java.util.List;

public class MainApp implements App {

    private static final Logger LOGGER = LogManager.getLogger(MainApp.class);

    @Autowired
    @Qualifier("mainAppDatabase")
    private DatabaseProvider database;

    @Autowired
    @Qualifier("clientDatabaseService")
    private ClientDatabaseService databaseService;

    @Override
    public void connectToDatabase() {
        database.startConnection();
    }

    @Override
    public void run() {
        List<ClientDto> clients = selectClients();
        String clientNamesString = makeClientNamesString(clients);
        LOGGER.info(clientNamesString);

        if (!CollectionUtils.isEmpty(clients)) {
            int clientIndex = clients.size() - 1;
            databaseService.deleteClient(clients.get(clientIndex));
        }

        ClientDto client = makeClient();
        registerNewClient(client);

        updateClientPasswordHash(client);

        ClientDto selectedClient = selectClientByEmail("selected@email.ru");
    }

    /*@Override
    public void saveDataToDatabase(DataProvider data) {
        database.saveClientData(data);
    }*/



    @Override
    public void closeDatabaseConnection() {
        database.closeConnection();
    }

    /*@Override
    public void loadProfileData() {
        data = new ClientDataProvider()
                .withFirstName("Витя")
                .withFamilyName("Иванов")
                .withSecondName("Иванович")
                .withClientInfoData(new BigDecimal(1230), 100);
    }*/

    @Override
    public void close() throws Exception {
        database.closeConnection();
    }

    private List<ClientDto> selectClients() {
        return databaseService.selectAllClients();
    }

    private String makeClientNamesString(List<ClientDto> clients) {
        StringBuilder namesStringBuilder = new StringBuilder();

        if (clients.size() > 0) {
            appendClientFIOToStringBuilder(namesStringBuilder, clients.get(0));
        }
        for (int i = 1; i < clients.size(); i++) {
            namesStringBuilder.append(" ");
            appendClientFIOToStringBuilder(namesStringBuilder, clients.get(i));
        }

        return namesStringBuilder.toString();
    }

    private void appendClientFIOToStringBuilder(StringBuilder builder, ClientDto client) {
        builder.append(client.getFamilyName());
        builder.append(":");
        builder.append(client.getFirstName());
        builder.append(":");
        builder.append(client.getSecondName());
    }

    private ClientDto makeClient() {
        return new ClientDto("123@email.ru", 1,
                "Vasya", "Ivanovich", "Ivanov");
    }

    private void registerNewClient(ClientDto newClient) {
        databaseService.registerClient(newClient);
    }

    private void updateClientPasswordHash(ClientDto client) {
        int id = client.getId();
        client.setPasswordHash(id);
        databaseService.updateClient(client);
    }

    private @Nullable ClientDto selectClientByEmail(String email) {
        try {
            return databaseService.findClientByEmail(email);
        } catch (Exception e) {
            LOGGER.error("Ошибка поиска клиента по email");
            return null;
        }
    }
}
