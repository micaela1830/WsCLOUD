package demo.model.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.model.entidad.Coche;

public interface DaoCoche extends JpaRepository<Coche, Integer> {

}
