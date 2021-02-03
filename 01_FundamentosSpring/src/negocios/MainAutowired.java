package negocios;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entidad.Persona;

public class MainAutowired {
	
	public static ApplicationContext context = null;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("recursos/autowire.xml");

		
		Persona p = context.getBean("persona1", Persona.class);
		System.out.println(p);
	}

}
