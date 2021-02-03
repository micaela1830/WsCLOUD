package negocios;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entidad.Persona;

	public class MainSpring {

		public static ApplicationContext context = null;
		
		public static void main(String[] args) {
			//EL contexto de spring tambien es un objeto 
			//así que tenemos que crearlo
			
			context = new ClassPathXmlApplicationContext("recursos/context.xml");
			/*a partir de aqui tendremos nuestro contexto de spring cargado 
			 * con los objetos que haya en el xml
			 */
			
			/* A partir de ahora, siempre que queremos un objeto de gestionado por
			 * Spring tenemos que pedirlo al contexto  
			 */
			Persona p1 = (Persona)context.getBean("persona1");
			System.out.println(p1);
			
			p1.setNombre("Harry Potter");
			//esto seria la manera habitual
			cambiarEdadPersona(p1,35);
			
			//Con spring podriamos hacer lo siguiente
			cambiarEdadPersona(65);
			System.out.println(p1);
			
			p1 = null;
			//1000 lieneas más abajo, manera quivalente a castear un objeto
			p1 = context.getBean("persona1", Persona.class);
			System.out.println(p1);
			
			p1 = context.getBean("persona2", Persona.class);
			System.out.println(p1);
			
			p1 = context.getBean("persona3", Persona.class);
			System.out.println(p1);
			
			p1 = context.getBean("personaPrototipada", Persona.class);
			System.out.println(p1);
			p1.setNombre("Superman");
			
			List<Persona>listaPersonas = context.getBean("listaPersonas",List.class);
			listaPersonas.add(p1);//
			
			p1 = context.getBean("personaPrototipada", Persona.class);
			System.out.println(p1);
			
			System.out.println(listaPersonas.get(0));
			
			p1 = context.getBean("persona4", Persona.class);
			System.out.println(p1);
			
			List<Persona>listaPersonas2 = context.getBean("listaPersonas2",List.class);
			for (Persona p : listaPersonas2) {
				System.out.println(p);
			}
		}
		
		public static void cambiarEdadPersona(Persona p, int edad) {
			p.setEdad(edad);
			
		}
		public static void cambiarEdadPersona(int edad) {
			Persona p = (Persona)context.getBean("persona1");
			p.setEdad(edad);
		}

	}
