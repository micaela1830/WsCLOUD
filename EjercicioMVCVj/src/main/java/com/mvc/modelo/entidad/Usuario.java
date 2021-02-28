package com.mvc.modelo.entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity //porque quermeos que sea manejada por JPAData y quiero que cree tablas y demás en una base de datos
public class Usuario {
	
	@Id //con esto indicamos que id es la clave primaria
	@GeneratedValue //autoincremente el id
	private int id;
	private String nombre;
	private String password;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", password=" + password + "]";
	}
	


}
