package demo;

import java.util.List;
import java.util.Optional;


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
		
		//*****************************************************
		Videojuego v2 = new Videojuego();
		v2.setNombre("Mario Bros");
		v2.setCompania("NINTENDO");
		v2.setPrecio(49.99);
		v2.setPuntuacion(4);
		
		daoVideojuego.save(v2);
		
		//*****************************************************
		Videojuego v3 = new Videojuego();
		v3.setNombre("FORTNITE");
		v3.setCompania("EPIC");
		v3.setPrecio(59.99);
		v3.setPuntuacion(5);
		
		//daoVideojuego.save(v3);
		
		
		
		//MODIFICACIÓN
		
		Videojuego v4 = new Videojuego();
		v4.setId(4);
		v4.setNombre("GTA");
		v4.setCompania("Rockstar Games");
		v4.setPrecio(69.99);
		v4.setPuntuacion(5);
		//para realizar este cambio es necasario comentar la linea 42 ya que es el objeto a modificar, de lo contrario habría confusión 
		daoVideojuego.save(v4);

		//MÉTODO PARA ACCEDER  A UN VIDEOJUEGO 
		
		Optional<Videojuego> vjOptional = daoVideojuego.findById(3);
		if (vjOptional.isPresent()) {
			System.out.println("existe el videojuego");
			System.out.println(vjOptional.get());

		} else {
			System.out.println("El videojuego no existe");
		}
		
		// recuperamos todos los videojuegos
		List<Videojuego> listaVj = daoVideojuego.findAll();
		System.out.println(listaVj);
		
		
		//Borra un videojuego
		daoVideojuego.deleteById(2);
		
		listaVj = daoVideojuego.findAll();
		System.out.println(listaVj);
		
		
		
		
	}

}
