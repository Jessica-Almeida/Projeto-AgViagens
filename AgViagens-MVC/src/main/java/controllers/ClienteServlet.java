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
import dao.ClienteDAO;
import model.Cliente;

@WebServlet(urlPatterns = { "/cliente", "/cliente-create", "/cliente-edit", "/cliente-update", "/cliente-delet" })
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	AcessoDAO acessoDAO = new AcessoDAO();
	ClienteDAO clienteDAO = new ClienteDAO();

	Cliente c = new Cliente();

	public ClienteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		switch (action) {
		case "/cliente":
			read(request, response);
			break;
		case "/cliente-create":
			create(request, response);
			break;
		case "/cliente-edit":
			edit(request, response);
			break;
		case "/cliente-update":
			update(request, response);
			break;
		case "/cliente-delet":
			delet(request, response);
			break;

		default:
			response.sendRedirect("index.html");
			break;
		}
	}

	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Cliente> lista = clienteDAO.getCliente();

		request.setAttribute("cliente", lista);

		RequestDispatcher rd = request.getRequestDispatcher("./views/cliente/index.jsp");
		rd.forward(request, response);
	}

	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		c.setNome(request.getParameter("nome"));
		c.setEmail(request.getParameter("email"));
		c.setCpf(request.getParameter("cpf"));
		c.setSenha(request.getParameter("senha"));
		c.setAcesso(acessoDAO.getAcessoById(Integer.parseInt(request.getParameter("idAcesso"))));

		clienteDAO.save(c);
		response.sendRedirect("cliente");

	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		c = clienteDAO.getClienteById(id);

		request.setAttribute("id", c.getId());
		request.setAttribute("nome", c.getNome());
		request.setAttribute("email", c.getEmail());
		request.setAttribute("senha", c.getSenha());
		request.setAttribute("idAcesso", c.getAcesso());

		RequestDispatcher rd = request.getRequestDispatcher("./views/cliente/update.jsp");
		rd.forward(request, response);

	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		c.setId(Integer.parseInt(request.getParameter("id")));
		c.setNome(request.getParameter("nome"));
		c.setEmail(request.getParameter("email"));
		c.setCpf(request.getParameter("cpf"));
		c.setSenha(request.getParameter("senha"));
		c.setAcesso(acessoDAO.getAcessoById(Integer.parseInt(request.getParameter("idAcesso"))));

		clienteDAO.update(c);
		response.sendRedirect("cliente");
	}

	protected void delet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		clienteDAO.deleteById(id);
		response.sendRedirect("cliente");
	}

}
