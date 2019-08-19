package pl.dn.star_wars_world.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dn.star_wars_world.model.PlanetEntity;

@Repository
public interface PlanetRepository extends JpaRepository<PlanetEntity, Long> {
}
