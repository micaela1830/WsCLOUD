package com.mvc.modelo.controlador;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.modelo.entidad.Videojuegos;
import com.mvc.modelo.negocio.GestorVj;

@Controller
public class ControladorVj {
	
	@Autowired 
	public GestorVj gestorVj;
	
	@GetMapping("consultaIdVJ")
	public String consultaVj(@RequestParam("id") int id, Model model)throws NoSuchAlgorithmException {
		
		Videojuegos vj = gestorVj.buscarVjId(id);
		
		model.addAttribute("videojuego", vj);
		
		return "videjuegosid";
	}
	@GetMapping("listVj") //lo que quiero es devolver la lista de videojuegos
	public String listaVJ(Model model) { //Se pone string ya que es el nombre de la pagina a la que quieres ir
	
	List<Videojuegos> listaVJ = gestorVj.obtenerListaVj();
	model.addAttribute("listaVj", listaVJ);

	return "videojuegos";
	
}

}
