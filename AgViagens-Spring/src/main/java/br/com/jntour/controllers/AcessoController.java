package br.com.jntour.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.jntour.models.Acesso;
import br.com.jntour.repositories.AcessoRepository;

@Controller

@RequestMapping("/acesso")
public class AcessoController {

	@Autowired
	private AcessoRepository acessoRepository;

	@GetMapping
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("views/acesso/index");

		modelAndView.addObject("acessos", acessoRepository.findAll());

		return modelAndView;
	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("views/acesso/formulario");

		modelAndView.addObject("acesso", new Acesso());

		return modelAndView;
	}

	@GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("views/acesso/formulario");

		modelAndView.addObject("acesso", acessoRepository.getReferenceById(id));

		return modelAndView;
	}

	@PostMapping({ "/cadastrar", "/{id}/editar" })
	public String salvar(Acesso acesso) {
		acessoRepository.save(acesso);

		return "redirect:/acesso";
	}

	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable Long id) {
		acessoRepository.deleteById(id);

		return "redirect:/acesso";
	}
}
