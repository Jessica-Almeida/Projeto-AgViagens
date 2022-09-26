package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AcessoDAO;
import model.Acesso;

@WebServlet(urlPatterns = { "/acesso", "/acesso-create", "/acesso-edit", "/acesso-update", "/acesso-delet" })
public class AcessoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	AcessoDAO acessoDAO = new AcessoDAO();

	Acesso a = new Acesso();

	public AcessoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		switch (action) {
		case "/acesso":
			read(request, response);
			break;
		case "/acesso-create":
			create(request, response);
			break;
		case "/acesso-edit":
			edit(request, response);
			break;
		case "/acesso-update":
			update(request, response);
			break;
		case "/acesso-delet":
			delet(request, response);
			break;

		default:
			response.sendRedirect("index.html");
			break;
		}
	}

	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Acesso> lista = acessoDAO.getAcesso();

		request.setAttribute("acesso", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./views/acesso/index.jsp");
		rd.forward(request, response);
	}

	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		a.setTipo(request.getParameter("tipo"));

		acessoDAO.save(a);
		response.sendRedirect("acesso");

	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		a = acessoDAO.getAcessoById(id);

		request.setAttribute("id", a.getId());
		request.setAttribute("tipo", a.getTipo());

		RequestDispatcher rd = request.getRequestDispatcher("./views/acesso/update.jsp");
		rd.forward(request, response);

	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		a.setId(Integer.parseInt(request.getParameter("id")));
		a.setTipo(request.getParameter("tipo"));

		acessoDAO.update(a);
		response.sendRedirect("acesso");
	}

	protected void delet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		acessoDAO.deleteById(id);
		response.sendRedirect("acesso");
	}

}