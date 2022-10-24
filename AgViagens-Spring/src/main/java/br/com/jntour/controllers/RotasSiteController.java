package br.com.jntour.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RotasSiteController {
	@GetMapping("/")
	public String Index() {
		return "index";
	}

	@GetMapping("/destinos")
	public String Destino() {
		return "destinos";
	}

	@GetMapping("/promocoes")
	public String Promocoes() {
		return "promocoes";
	}

	@GetMapping("/contato")
	public String Contato() {
		return "contato";
	}

}
