package demo.modelo.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.modelo.entidad.Videojuego;
//PARA CREAR  el DAO TENEMOS QUE CREAR UNA INTERFACE QUE EXTIENDA DE JPA REPOSITORY Y  PARAMETRIZAR DOS VALORES (que es lo que va dentro de los corchetes(videojuego integer))
//1- Videojuego, que sería la entidad que quermos mapear
//2- EL tipo de ID (clave primaria) de la entidad que estamos mapeando

@Repository
public interface DaoVideojuego extends JpaRepository<Videojuego, Integer>{

}
