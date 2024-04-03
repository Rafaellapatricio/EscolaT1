package br.com.vainaweb.escolat1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-world")
public class Hello {
	
	@GetMapping
	public String saudacao(@RequestParam(defaultValue = "Back-end", value = "nome") String nome) {
		return "Hello, " + nome;
	}
}