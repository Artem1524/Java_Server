package project.server.core.servlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import project.server.service.ClientDatabaseService;
import project.server.base.dto.ClientDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/list")
//@Controller
public class ClientListServlet extends HttpSpringServlet {

	private static final Logger LOGGER = LogManager.getLogger(ClientListServlet.class);

	@Autowired
	@Qualifier("clientDatabaseService")
	private ClientDatabaseService clientDatabaseService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ClientDto> clients = clientDatabaseService.selectAllClients();
		List<String> clientNames = getClientNamesList(clients);

		req.setAttribute("userNames", clientNames);

		LOGGER.info("Тест логгера");

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("list.jsp");
		requestDispatcher.forward(req, resp);
	}

	private List<String> getClientNamesList(List<ClientDto> clients) {
		return clients
				.stream()
				.map(ClientDto::getFirstName)
				.collect(Collectors.toList());
	}
}
