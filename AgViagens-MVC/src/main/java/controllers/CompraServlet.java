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
import dao.ClienteDAO;
import dao.CompraDAO;

import model.Compra;

@WebServlet(urlPatterns = { "/compra", "/compra-create", "/compra-edit", "/compra-update", "/compra-delet" })
public class CompraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CompraDAO compraDAO = new CompraDAO();
	ClienteDAO clienteDAO = new ClienteDAO();
	DestinoDAO destinoDAO = new DestinoDAO();

	Compra c = new Compra();

	public CompraServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		switch (action) {
		case "/compra":
			read(request, response);
			break;
		case "/compra-create":
			create(request, response);
			break;
		case "/compra-edit":
			edit(request, response);
			break;
		case "/compra-update":
			update(request, response);
			break;
		case "/compra-delet":
			delet(request, response);
			break;

		default:
			response.sendRedirect("index.html");
			break;
		}
	}

	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Compra> lista = compraDAO.getCompra();

		request.setAttribute("compra", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./views/compra/index.jsp");
		rd.forward(request, response);
	}

	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		c.setData(new Date());
		c.setQuantidade(Integer.parseInt(request.getParameter("qnt")));
		c.setDestino(destinoDAO.getDestinoById(Integer.parseInt(request.getParameter("idDestino"))));
		c.setCliente(clienteDAO.getClienteById(Integer.parseInt(request.getParameter("idCliente"))));

		compraDAO.save(c);
		response.sendRedirect("compra");

	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		c = compraDAO.getCompraById(id);

		request.setAttribute("id", c.getId());
		request.setAttribute("qnt", c.getQuantidade());
		request.setAttribute("idCliente", c.getCliente());
		request.setAttribute("idDestino", c.getDestino());

		RequestDispatcher rd = request.getRequestDispatcher("./views/compra/update.jsp");
		rd.forward(request, response);

	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		c.setId(Integer.parseInt(request.getParameter("id")));
		c.setData(new Date());
		c.setQuantidade(Integer.parseInt(request.getParameter("qnt")));
		c.setDestino(destinoDAO.getDestinoById(Integer.parseInt(request.getParameter("idDestino"))));
		c.setCliente(clienteDAO.getClienteById(Integer.parseInt(request.getParameter("idCliente"))));

		compraDAO.update(c);
		response.sendRedirect("compra");
	}

	protected void delet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		compraDAO.deleteById(id);
		response.sendRedirect("compra");
	}

}
