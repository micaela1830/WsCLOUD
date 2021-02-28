package com.mvc.modelo.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mvc.modelo.entidad.Videojuegos;

@Repository
public interface DaoVj extends JpaRepository<Videojuegos, Integer>{

}
