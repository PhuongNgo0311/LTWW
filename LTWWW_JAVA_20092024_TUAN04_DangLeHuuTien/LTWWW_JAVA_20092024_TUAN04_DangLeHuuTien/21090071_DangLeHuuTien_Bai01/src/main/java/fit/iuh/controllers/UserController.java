package fit.iuh.controllers;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.sql.DataSource;

import fit.iuh.dao.UserDAO;
import fit.iuh.daoImpl.UserDAOImpl;
import fit.iuh.models.Gender;
import fit.iuh.models.User;


/**
 * Servlet implementation class UserController
 */
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/userdb")
	private DataSource dataSource;
	private UserDAO userDAO;
    /**
     * Default constructor. 
     */
    public UserController() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		userDAO = new UserDAOImpl(this.dataSource);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String gender = request.getParameter("gender");

		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPassword(password);

		if (day != null && !day.isEmpty() && month != null && !month.isEmpty() && year != null && !year.isEmpty()) {
			try {
				String formattedDate = year + "-" + month + "-" + day;
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date birthday = sdf.parse(formattedDate);
				user.setBirthday(birthday);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		if (gender != null) {
			user.setGender(Gender.valueOf(gender.toUpperCase()));

			System.out.println(user);

		}

		userDAO.addUser(user);

		response.setContentType("application/json");
		response.getWriter().write("Successfully");
		response.getWriter().write(user.toString());

		response.setStatus(201);
	}

}

