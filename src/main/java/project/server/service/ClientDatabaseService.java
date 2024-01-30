package project.server.service;

import project.server.base.dto.ClientDto;

import java.util.List;

public interface ClientDatabaseService {
    ClientDto findClientByEmail(String email) throws Exception;
    void registerClient(ClientDto client);
    void updateClient(ClientDto client);
    void deleteClient(ClientDto client);
    List<ClientDto> selectAllClients();
}
