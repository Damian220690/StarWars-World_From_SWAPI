package pl.dn.star_wars_world.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import pl.dn.star_wars_world.model.ApiObject;
import pl.dn.star_wars_world.model.Planet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/starWars")
public class HomeContoller {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/planets/{id}")
    public String getInfoAboutPlanet(@PathVariable int id){
        Planet planet = restTemplate.getForObject("https://swapi.co/api/planets/"+id, Planet.class);
        return planet.getName() + " - "+ planet.getPopulation();
    }

//    @GetMapping("/planets")
//    public  List<Planet> getInfoAboutAllPlanets(){
//        Planet[] planets = restTemplate.getForObject("https://swapi.co/api/planets/", Planet[].class);
//        List<Planet> listOfPlanets = Arrays.asList(planets);
//        return listOfPlanets;
//    }

    @GetMapping("/planets")
    public Map<String, String> getInfoAboutAllPlanets(){
        ApiObject apiObject = restTemplate.getForObject("https://swapi.co/api/planets/", ApiObject.class);
        List<Planet> planets = Arrays.asList(apiObject.getPlanets());
        Map<String,String> planetPopulation = new HashMap<>();
        for(Planet planet : planets){
            planetPopulation.put(planet.getName(),planet.getPopulation());
        }
        return planetPopulation;
    }
}
