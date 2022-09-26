package controllers;

import java.io.IOException;

import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DestinoDAO;
import model.Destino;

@WebServlet(urlPatterns = { "/destino", "/destino-create", "/destino-edit", "/destino-update", "/destino-delet" })
public class DestinoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DestinoDAO destinoDAO = new DestinoDAO();

	Destino d = new Destino();

	public DestinoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		switch (action) {
		case "/destino":
			read(request, response);
			break;
		case "/destino-create":
			create(request, response);
			break;
		case "/destino-edit":
			edit(request, response);
			break;
		case "/destino-update":
			update(request, response);
			break;
		case "/destino-delet":
			delet(request, response);
			break;

		default:
			response.sendRedirect("index.html");
			break;
		}
	}

	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Destino> lista = destinoDAO.getDestino();

		request.setAttribute("destino", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./views/destino/index.jsp");
		rd.forward(request, response);
	}

	@SuppressWarnings("deprecation")
	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		d.setPais(request.getParameter("pais"));
		d.setCidade(request.getParameter("cidade"));
		d.setDataIda(new Date(request.getParameter("dataIda")));
		d.setDataVolta(new Date(request.getParameter("dataVolta")));
		d.setPreco(Double.parseDouble(request.getParameter("preco")));

		destinoDAO.save(d);
		response.sendRedirect("destino");

	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		d = destinoDAO.getDestinoById(id);

		request.setAttribute("id", d.getId());
		request.setAttribute("pais", d.getPais());
		request.setAttribute("cidade", d.getCidade());
		request.setAttribute("dataIda", d.getDataIda());
		request.setAttribute("dataVolta", d.getDataVolta());
		request.setAttribute("preco", d.getPreco());

		RequestDispatcher rd = request.getRequestDispatcher("./views/destino/update.jsp");
		rd.forward(request, response);

	}

	@SuppressWarnings("deprecation")
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		d.setPais(request.getParameter("pais"));
		d.setCidade(request.getParameter("cidade"));
		d.setDataIda(new Date(request.getParameter("dataIda")));
		d.setDataVolta(new Date(request.getParameter("dataVolta")));
		d.setPreco(Double.parseDouble(request.getParameter("preco")));

		destinoDAO.update(d);
		response.sendRedirect("destino");
	}

	protected void delet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		destinoDAO.deleteById(id);
		response.sendRedirect("destino");
	}

}
