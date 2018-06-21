package it.uniroma3.siw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

	@Controller
	public class ResponsabileController {

		@RequestMapping("/home")
		public String home() {
			return "/home";
		}
		
		@RequestMapping("")
		public String homehome() {
			return "/home";
		}

		@RequestMapping("/admin")
		public String admin() {
			return "/admin";
		}


		@RequestMapping("/login")
		public String login() {
			return "/login";
		}

		@RequestMapping("/403")
		public String error403() {
			return "/error/403";
		}
}
