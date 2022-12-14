package br.com.jntour.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.jntour.models.Destino;
import br.com.jntour.repositories.DestinoRepository;

@Controller
@RequestMapping("/destino")
public class DestinoController {

	@Autowired
	private DestinoRepository destinoRepository;

	@GetMapping
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("views/destino/index");

		modelAndView.addObject("destinos", destinoRepository.findAll());

		return modelAndView;
	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("views/destino/formulario");

		modelAndView.addObject("destino", new Destino());

		return modelAndView;
	}

	@GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("views/destino/formulario");

		modelAndView.addObject("destino", destinoRepository.getReferenceById(id));

		return modelAndView;
	}

	@PostMapping({ "/cadastrar", "/{id}/editar" })
	public String salvar(Destino destino) {
		destinoRepository.save(destino);

		return "redirect:/destino";
	}

	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable Long id) {
		destinoRepository.deleteById(id);

		return "redirect:/destino";
	}

}
