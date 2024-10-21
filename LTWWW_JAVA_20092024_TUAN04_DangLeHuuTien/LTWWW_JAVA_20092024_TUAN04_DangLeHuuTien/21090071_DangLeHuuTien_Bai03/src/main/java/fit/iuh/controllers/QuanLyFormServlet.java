package fit.iuh.controllers;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import javax.sql.DataSource;

import fit.iuh.dao.NewsDAO;
import fit.iuh.daoImpl.NewsDAOImpl;
import fit.iuh.models.TinTuc;

/**
 * Servlet implementation class QuanLyFormServlet
 */
@WebServlet(urlPatterns = { "/managelist" })
public class QuanLyFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/webnews")
	private DataSource dataSource;
	private NewsDAO newsDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QuanLyFormServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		newsDAO = new NewsDAOImpl(this.dataSource);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("news", newsDAO.findAll());
		request.getRequestDispatcher("views/list/QuanLyForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action") != null ? request.getParameter("action") : "";
		switch (action) {
		case "clear":
			clearAll(request, response);
			break;
		case "remove":
			remove(request, response);
			break;
		default:
			doGet(request, response);
			break;
		}
	}

	private void remove(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String maTT = request.getParameter("maTT");
		if (maTT != null && !maTT.isEmpty()) {
			int id = Integer.parseInt(maTT);
			TinTuc tinTuc = newsDAO.getById(id);
			if (tinTuc != null) {
				newsDAO.remove(tinTuc);
			}
		}
		response.sendRedirect(request.getContextPath() + "/managelist");
	}

	private void clearAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		newsDAO.clearAll();
		response.sendRedirect(request.getContextPath() + "/managelist");
	}

}
