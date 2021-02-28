package com.mvc.modelo.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mvc.modelo.entidad.Usuario;

@Repository //se esta creando un objeto de tipo DAOUsuario dentro del contexto de spring con el nombre de la clase y sera el encargado de hacer todas la fucniones de la base de datos 
public interface DaoUsuario extends JpaRepository<Usuario, Integer> {
	
	//con jpa podemos crear busquedas usando convenciones de creación de metodos. 
	//Todo método que empiece con las palabras "findBy" + atributo, JPA data te creara la consulta automaticamente
	public Usuario findByNombre(String nombre);
	
	public Usuario findByNombreAndPassword(String nombre, String password);
}
