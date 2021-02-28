package com.mvc.modelo.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.modelo.entidad.Usuario;
import com.mvc.modelo.persistencia.DaoUsuario;

//con esta anotacion damos de alta un objeto en el contexto de Spring, es equivalente a la anotación
//@component, lo que pasa es que si un programador ve esta etiqueta, sabe que lleva la logica de negocio de tu app.
@Service //tenemos que dar de alta a este objeto en el contexto de Spring
public class GestorUsuario { //se comunica con la capa Dao para comunicarse con la BBDDD ya que este solo no puede y a su vez con las entidades

	@Autowired
	private DaoUsuario daoUsuario;
	
	//esta capa de encarga de la lógica de la aplicación, de validaciones, de aplicar requisitos del cliente
	
	public boolean validarUsuario(Usuario user) {
		
		Usuario usuarioAux = daoUsuario.findByNombreAndPassword(user.getNombre(), user.getPassword());
		
		//su usarioAux es null, entonces no esta en la BBDD, si existe, entonces el usuario si existe
		
		if (usuarioAux == null) {
			return false;
		} else {
			return true;
		}
		
		
	}
}
