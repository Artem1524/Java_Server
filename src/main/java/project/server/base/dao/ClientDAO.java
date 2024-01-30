package project.server.utility.dataprovider.impl;

import project.server.utility.dataprovider.DataProvider;
import project.server.base.dto.ClientDto;

import java.util.List;

public interface ClientDAO {
	
    ClientDto findByEmail(String email);
	void save(ClientDto client);
	void update(ClientDto client);
	void delete(ClientDto client);
	List<ClientDto> selectAllClients();
}
