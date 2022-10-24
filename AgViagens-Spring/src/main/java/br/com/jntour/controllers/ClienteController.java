package br.com.jntour.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.jntour.models.Cliente;
import br.com.jntour.repositories.AcessoRepository;
import br.com.jntour.repositories.ClienteRepository;
import br.com.jntour.utils.SenhaUtils;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private AcessoRepository acessoRepository;

	@GetMapping
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("views/cliente/index");

		modelAndView.addObject("clientes", clienteRepository.findAll());
		return modelAndView;
	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("views/cliente/formulario");

		modelAndView.addObject("cliente", new Cliente());
		modelAndView.addObject("acessos", acessoRepository.findAll());

		return modelAndView;
	}

	@GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("views/cliente/formulario");

		modelAndView.addObject("cliente", clienteRepository.getReferenceById(id));
		modelAndView.addObject("acessos", acessoRepository.findAll());

		return modelAndView;
	}

	@PostMapping({ "/cadastrar", "/{id}/editar" })
	public String salvar(Cliente cliente) {
		String senhaEncriptada = SenhaUtils.encode(cliente.getSenha());
		cliente.setSenha(senhaEncriptada);
		clienteRepository.save(cliente);

		return "redirect:/cliente";
	}

	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable Long id) {
		clienteRepository.deleteById(id);

		return "redirect:/cliente";
	}
}
