package mx.utng.practice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import mx.utng.practice.model.Plant;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {

	@Query("select plan from Plant plan")
	public List<Plant> findAll();
}
