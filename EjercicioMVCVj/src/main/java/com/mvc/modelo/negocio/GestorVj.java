package com.mvc.modelo.negocio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.modelo.entidad.Videojuegos;
import com.mvc.modelo.persistencia.DaoVj;

@Service
public class GestorVj {
	
	@Autowired
	private DaoVj daoVj;

	public Videojuegos buscarVjId(int id) {
		Optional<Videojuegos> vjOptional = daoVj.findById(id);
		
		if (vjOptional.isPresent()) {
			return vjOptional.get();
			
		}else {
			return null;
		}
		
	}

	public List<Videojuegos> obtenerListaVj() {
		return daoVj.findAll();
	}
	
	

}
