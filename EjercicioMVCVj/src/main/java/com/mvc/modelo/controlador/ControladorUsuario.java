package com.mvc.modelo.controlador;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.modelo.entidad.Usuario;
import com.mvc.modelo.negocio.GestorUsuario;


@Controller 
public class ControladorUsuario {
	
	@Autowired
	private GestorUsuario gestUsuario;

	@PostMapping("doLogin")
	public String logearse(
			@RequestParam("nombre_usuario") String nombre,
			@RequestParam("pass") String password, Model model) {
		
		
		Usuario user = new Usuario();
		user.setNombre(nombre);
		user.setPassword(password);
		
		boolean validado = gestUsuario.validarUsuario(user); 
		

		if (validado) {
		
			model.addAttribute("nombreUsuario", nombre); 
					

			return "redirect:listVj";
		} else {

			return "error";
		}
		
	}
	
}
