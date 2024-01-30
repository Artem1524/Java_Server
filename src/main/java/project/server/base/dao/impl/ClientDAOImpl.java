package project.server.base.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;
import project.server.base.dto.ClientDto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.List;

import org.hibernate.Session;
import project.server.utility.session.HibernateSessionFactoryUtils;

@Service("clientDAO")
public class ClientDAOImpl implements project.server.utility.dataprovider.impl.ClientDAO {

	private static final Logger LOGGER = LogManager.getLogger(ClientDAOImpl.class);
    
	public ClientDto findByEmail(String email) {
		ClientDto client = null;

		try (Session session = HibernateSessionFactoryUtils.getSessionFactory().openSession()) {
			client = session.get(ClientDto.class, email);
		} catch (Exception e) {
			LOGGER.error("Ошибка при поиске клиента по email в базе", e);
			throw e;
		}

		if (client != null) {
			LOGGER.info("Client %s was selected by email!", client.getFirstName());
		}

		return client;
	}
	
	public void save(ClientDto client) {
		Session session = HibernateSessionFactoryUtils.getSessionFactory().openSession();
		
		Transaction tx = session.beginTransaction();
		try {
			session.save(client);

			LOGGER.info("Client %s was registered!", client.getFirstName());
			tx.commit();
		} catch (Exception e) {
			LOGGER.error("Ошибка при регистрации клиента в базе", e);
			tx.rollback();
		} finally {
			session.close();
		}
	}
	
	public void update(ClientDto client) {
		Session session = HibernateSessionFactoryUtils.getSessionFactory().openSession();
		
		Transaction tx = session.beginTransaction();

		try {
			session.update(client);

			LOGGER.info("Client %s was updated!", client.getFirstName());
			tx.commit();
		} catch (Exception e) {
			LOGGER.error("Ошибка при изменении данных клиента в базе", e);
			tx.rollback();
		} finally {
			session.close();
		}
	}
	
	public void delete(ClientDto client) {
		Session session = HibernateSessionFactoryUtils.getSessionFactory().openSession();
		
		Transaction tx = session.beginTransaction();
		try {
			session.delete(client);

			LOGGER.info("Client %s was deleted!", client.getFirstName());
			tx.commit();
		} catch (Exception e) {
			LOGGER.error("Ошибка при удалении клиента в базе", e);
			tx.rollback();
		} finally {
			session.close();
		}
	}
	
	public List<ClientDto> selectAllClients() {
		List<ClientDto> list = null;

		try (Session session = HibernateSessionFactoryUtils.getSessionFactory().openSession()) {
			Query query = session.createQuery("from ClientDto"); // select client from Clients client
			list = (List<ClientDto>) query.list();
		} catch (Exception e) {
			LOGGER.error("Ошибка при получении списка клиентов из базы", e);
			throw e;
		}

		int clientsCount = (list != null) ? list.size() : 0;

		LOGGER.info("Selected %d clients!", clientsCount);
		
		return list;
	}
	/*
    public ClientDataProvider withClientInfoData(BigDecimal balance, Integer position) {
        data.setClientInfoData(
                new ClientInfoData(balance, position)
        );
        return this;
    }

    @Override
    public String getStringData() {
        return String.format("'???': %s %s %s, '??????': ?????? = %s, ??????? = %d",
                data.getFamilyName(), data.getFirstName(), data.getSecondName(),
                formatBalance(data.getClientInfoData().getBalance()), data.getClientInfoData().getPosition());
    }*/

    public String formatBalance(BigDecimal balance) {
        NumberFormat formatter = NumberFormat.getInstance();
        formatter.setGroupingUsed(true);
        formatter.setMinimumFractionDigits(2);
        formatter.setRoundingMode(RoundingMode.FLOOR);
        return formatter.format(balance);
    }
}
