package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import demo.modelo.entidad.Videojuego;
import demo.modelo.persistencia.DaoVideojuego;

@SpringBootApplication
public class EjercicioVideojuegoJpdataApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(EjercicioVideojuegoJpdataApplication.class, args);
		
		DaoVideojuego daoVideojuego = context.getBean("daoVideojuego", DaoVideojuego.class);
		
		Videojuego v1 = new Videojuego();
		v1.setNombre("Sonic");
		v1.setCompania("SEGA");
		v1.setPrecio(34.99);
		v1.setPuntuacion(5);
		
		daoVideojuego.save(v1);
	}

}
