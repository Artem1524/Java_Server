package project.server.core.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import project.server.base.dto.ClientDto;
import project.server.service.ClientDatabaseService;
import project.server.utility.client.PasswordUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/new")
public class NewClientServlet extends HttpSpringServlet {
	
	@Autowired
	@Qualifier("clientDatabaseService")
	private ClientDatabaseService databaseService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		returnControlToPage(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstName = req.getParameter("firstName");
		String familyName = req.getParameter("familyName");
		String secondName = req.getParameter("secondName");
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		int passwordHash = PasswordUtils.getPasswordHash(password);

		ClientDto client = makeClient(firstName, familyName, secondName, email, passwordHash);

		databaseService.registerClient(client);

		req.setAttribute("newUserName", client.getFirstName());

		returnControlToPage(req, resp);
	}

	private void returnControlToPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("new.jsp");
		requestDispatcher.forward(req, resp);
	}

	private ClientDto makeClient(String firstName, String familyName, String secondName,
								 String email, int passwordHash) {
		return new ClientDto(email, passwordHash, firstName, secondName, familyName);
	}
}
