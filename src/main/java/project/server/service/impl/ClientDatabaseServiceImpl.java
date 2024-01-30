package project.server.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import project.server.service.ClientDatabaseService;
import project.server.utility.dataprovider.impl.ClientDAO;
import project.server.base.dto.ClientDto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.List;

@Service("clientDatabaseService")
public class ClientDatabaseServiceImpl implements ClientDatabaseService {

	private static final Logger LOGGER = LogManager.getLogger(ClientDatabaseServiceImpl.class);
	
	@Autowired
	@Qualifier("clientDAO")
    private ClientDAO clientDao;

	@Override
	public ClientDto findClientByEmail(String email) throws Exception {
		try {
			return clientDao.findByEmail(email);
		} catch (Exception e) {
			LOGGER.error("Ошибка при поиске клиента по email");
			throw e;
		}
	}

	@Override
	public void registerClient(ClientDto client) {
		try {
			clientDao.save(client);
		} catch (Exception e) {
			LOGGER.error("Ошибка при регистрации клиента");
			throw e;
		}
	}

	@Override
	public void updateClient(ClientDto client) {
		try {
			clientDao.update(client);
		} catch (Exception e) {
			LOGGER.error("Ошибка при изменении данных клиента");
			throw e;
		}
	}

	@Override
	public void deleteClient(ClientDto client) {
		try {
			clientDao.delete(client);
		} catch (Exception e) {
			LOGGER.error("Ошибка при удалении клиента");
			throw e;
		}
	}

	@Override
	public List<ClientDto> selectAllClients() {
		try {
			return clientDao.selectAllClients();
		} catch (Exception e) {
			LOGGER.error("Ошибка при получении списка клиентов");
			throw e;
		}
	}

    /*public void withClientInfoData(BigDecimal balance, Integer position) {
        data.setClientInfoData(
                new ClientInfoData(balance, position)
        );
    }*/

    /*@Override
    public String getStringData() {
        return String.format("'ФИО': %s %s %s, 'Данные': Баланс = %s, Позиция = %d",
                data.getFamilyName(), data.getFirstName(), data.getSecondName(),
                formatBalance(data.getClientInfoData().getBalance()), data.getClientInfoData().getPosition());
    }*/

    /*private String formatBalance(@NonNull BigDecimal balance) {
        NumberFormat formatter = NumberFormat.getInstance();
        formatter.setGroupingUsed(true);
        formatter.setMinimumFractionDigits(2);
        formatter.setRoundingMode(RoundingMode.FLOOR);
        return formatter.format(balance);
    }*/
}
