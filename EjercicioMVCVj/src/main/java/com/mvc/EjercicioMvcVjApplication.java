package com.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mvc.modelo.entidad.Usuario;
import com.mvc.modelo.entidad.Videojuegos;
import com.mvc.modelo.persistencia.DaoUsuario;
import com.mvc.modelo.persistencia.DaoVj;

@SpringBootApplication
public class EjercicioMvcVjApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(EjercicioMvcVjApplication.class, args);
		
		DaoUsuario daoUsuario = context.getBean("daoUsuario", DaoUsuario.class);
		DaoVj daoVj = context.getBean("daoVj", DaoVj.class);
		
		Usuario user = new Usuario();
		user.setNombre("micaela");
		user.setPassword("135790");
		
		daoUsuario.save(user);
		
		Videojuegos v1 = new Videojuegos();
		v1.setNombre("SONIC");
		v1.setCompania("SEGA");
		v1.setPrecio(34.99);
		v1.setPuntuacion(5);
		
		daoVj.save(v1);
		
		Videojuegos v2 = new Videojuegos();
		v2.setNombre("MARIO BROS");
		v2.setCompania("NINTENDO");
		v2.setPrecio(49.99);
		v2.setPuntuacion(4);
		
		daoVj.save(v2);
		
		Videojuegos v3 = new Videojuegos();
		v3.setNombre("FORTNITE");
		v3.setCompania("EPIC");
		v3.setPrecio(59.99);
		v3.setPuntuacion(5);
		
		daoVj.save(v3);
		
		Videojuegos v4 = new Videojuegos();
		v4.setNombre("LEAGUE AND LEYENDS");
		v4.setCompania("EPIC");
		v4.setPrecio(49.99);
		v4.setPuntuacion(3);
		
		daoVj.save(v4);
		
	}

}
