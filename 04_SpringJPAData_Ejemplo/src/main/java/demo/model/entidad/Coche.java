package demo.model.entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*TENEMOS QUE DECIRLE A JPA DATA QUE ESTA CLASE JAVABEAN QUE CREE UNA TABLA EN BBDD Y QUE LA MANEJE PARA TRABAJAR
 *  CON PERSISTENCIA DE DATOS DE LOS OBJETOS Y PARA ELLO USAMOS LA ANOTACIÓN ENTITY
 */



@Entity // CON ESTA ANOTACIÓN LE DECIMOS A JPA QUE QUEREOS CREAR UNA TABLA EN BBDD QUE SE LLAME COCHE Y QUE TENGA COMO CAMPOS TODOS SUS ATRIBUTOS
public class Coche {
	
	
	@Id 
	@GeneratedValue //VAMOS A DECIRLE QUE CADA VEZ QUE DE DE ALTA UN OBJETO EN BASE DE DATOS ME AUTOGENERE EL ID DE MANERA INCREMENTAL
	private int id; //VAMOS A DECIRLE QUE ESTE CAMPO SERÁ PRIMARY KEY CON LA NOTACIÓN @ID
	
	
	private String matricula;
	private String marca;
	private int potencia;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getPotencia() {
		return potencia;
	}
	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}
	
	
	@Override
	public String toString() {
		return "Coche [id=" + id + ", matricula=" + matricula + ", marca=" + marca + ", potencia=" + potencia + "]";
	}
	
	
	

}
