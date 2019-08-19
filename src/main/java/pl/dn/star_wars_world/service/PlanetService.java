package pl.dn.star_wars_world.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dn.star_wars_world.model.Planet;
import pl.dn.star_wars_world.model.PlanetEntity;
import pl.dn.star_wars_world.repository.PlanetRepository;

import java.util.List;

@Service
public class PlanetService {

    @Autowired
    PlanetRepository planetRepository;

    public void savePlanetToDatabase(List<Planet> planets){
        for(Planet planet : planets){
            PlanetEntity planetEntity = new PlanetEntity(planet);
            planetRepository.save(planetEntity);
        }
    }
}
