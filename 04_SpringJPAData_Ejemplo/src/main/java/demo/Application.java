package demo;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import demo.model.entidad.Coche;
import demo.model.persistencia.DaoCoche;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);

		DaoCoche daoCoche = context.getBean("daoCoche", DaoCoche.class);

		Coche coche = new Coche();
		coche.setMatricula("CMD-3456");
		coche.setMarca("Ferrari");
		coche.setPotencia(1100);

		// persistimos el coche en base de datos
		// notese que no ponemos el ID del coche, ya que la bbdd no pone uno por defecto
		// y es autocrimental
		// daoCoche.save(coche);

		// para modificar, usaremos el mismo metodo pero esta vez tendremos que pasarle
		// el id que queremos modificar.
		// Es decir, si NO le pasamos id, lo dara de alta en la bbdd si le pasamos el
		// ID, entonces modificaremos dicho registro
		Coche c2 = new Coche();
		c2.setId(1);
		c2.setMatricula("FDR-9880");
		c2.setMarca("Ferrari");
		c2.setPotencia(1200);
		// notese que sobreescribimos todo el objeto
		daoCoche.save(c2);

		// Para acceder a un coche
		// ojo, el método findById() devuelve un optional
		// hay que desenvolverlo con get(), tambien podemos usar el metodo isEmpty()
		// para ver si el objeto existe
		Coche c3 = daoCoche.findById(1).get();// para encontrar un coche mediante el id
		System.out.println(c3);

		// usar el emtodo isEmpty() para ver si el objeto existe
		// antes de desenvolverlo utilizar esto para para saber si existe un objeto o no
		Optional<Coche> cocheOptional = daoCoche.findById(3);
		if (cocheOptional.isPresent()) {
			System.out.println("existe el coche");
			System.out.println(cocheOptional.get());

		} else {
			System.out.println("El coche no existe");
		}

		// recuperamos todos los coches
		List<Coche> listaCoches = daoCoche.findAll();
		System.out.println(listaCoches);

		// borrar un coche
		daoCoche.deleteById(2);

		listaCoches = daoCoche.findAll();
		System.out.println(listaCoches);

	}

}
