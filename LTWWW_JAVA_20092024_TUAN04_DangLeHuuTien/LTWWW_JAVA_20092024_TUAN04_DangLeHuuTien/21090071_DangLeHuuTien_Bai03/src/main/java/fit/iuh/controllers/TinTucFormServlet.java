package fit.iuh.controllers;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import fit.iuh.dao.NewsDAO;
import fit.iuh.daoImpl.NewsDAOImpl;
import fit.iuh.models.TinTuc;

/**
 * Servlet implementation class TinTucFormServlet
 */
@WebServlet(urlPatterns = { "/news", "/news*" })
public class TinTucFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/webnews")
	private DataSource dataSource;
	private NewsDAO newsDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TinTucFormServlet() {
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
		displayNews(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tieuDe = request.getParameter("tieuDe");
		String noiDungTT = request.getParameter("noiDungTT");
		String lienKet = request.getParameter("lienKet");
		String maDM = request.getParameter("maDM");

		TinTuc tinTuc = new TinTuc();
		tinTuc.setTieuDe(tieuDe);
		tinTuc.setNoiDungTT(noiDungTT);
		tinTuc.setLienKet(lienKet);
		tinTuc.setMaDM(maDM);
		newsDAO.addNews(tinTuc);
		response.sendRedirect(request.getContextPath() + "/list");
		
	}

	private void displayNews(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("views/news/TinTucForm.jsp").forward(request, response);
	}

}
