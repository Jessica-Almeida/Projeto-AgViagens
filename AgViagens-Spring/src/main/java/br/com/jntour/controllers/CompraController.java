package br.com.jntour.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.jntour.models.Compra;
import br.com.jntour.repositories.CompraRepository;
import br.com.jntour.repositories.ClienteRepository;
import br.com.jntour.repositories.DestinoRepository;

@Controller
@RequestMapping("/compra")
public class CompraController {
	@Autowired
	private CompraRepository compraRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private DestinoRepository destinoRepository;

	@GetMapping
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("views/compra/index");

		modelAndView.addObject("compras", compraRepository.findAll());
		return modelAndView;
	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("views/compra/formulario");

		modelAndView.addObject("compra", new Compra());
		modelAndView.addObject("clientes", clienteRepository.findAll());
		modelAndView.addObject("destinos", destinoRepository.findAll());

		return modelAndView;
	}

	@GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("views/compra/formulario");

		modelAndView.addObject("compra", compraRepository.getReferenceById(id));
		modelAndView.addObject("clientes", clienteRepository.findAll());
		modelAndView.addObject("destinos", destinoRepository.findAll());

		return modelAndView;
	}

	@PostMapping({ "/cadastrar", "/{id}/editar" })
	public String salvar(Compra compra) {
		double total = compra.getTotal();
		compra.setTotal(total);
		compraRepository.save(compra);

		return "redirect:/compra";
	}

	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable Long id) {
		compraRepository.deleteById(id);

		return "redirect:/compra";
	}
}
