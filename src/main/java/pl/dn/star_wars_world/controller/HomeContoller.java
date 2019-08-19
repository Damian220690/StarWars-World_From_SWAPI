package pl.dn.star_wars_world.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import pl.dn.star_wars_world.model.ApiObject;
import pl.dn.star_wars_world.model.Planet;
import pl.dn.star_wars_world.repository.PlanetRepository;
import pl.dn.star_wars_world.service.PlanetService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/starWars")
public class HomeContoller {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    PlanetService planetService;

    @GetMapping("/planets/{id}")
    public String getInfoAboutPlanet(@PathVariable int id, Model model){
        Planet planet = restTemplate.getForObject("https://swapi.co/api/planets/"+id, Planet.class);
        model.addAttribute("planet", planet);
        return "specificPlanet";
    }

//    @GetMapping("/planets")
//    public  List<Planet> getInfoAboutAllPlanets(){
//        Planet[] planets = restTemplate.getForObject("https://swapi.co/api/planets/", Planet[].class);
//        List<Planet> listOfPlanets = Arrays.asList(planets);
//        return listOfPlanets;
//    }


    @GetMapping("/planets")
    public String getHomePage(Model model){
        ApiObject apiObject = restTemplate.getForObject("https://swapi.co/api/planets/", ApiObject.class);
        List<Planet> planets = Arrays.asList(apiObject.getPlanets());
        Map<Integer, Planet> planetsMap = new HashMap<>();
        for(int i = 0; i < planets.size(); i++){
            planetsMap.put(i+2,planets.get(i));
        }
        model.addAttribute("planets", planetsMap);
        return "home";
    }

    @GetMapping("/planets/save")
    @ResponseBody
    public String savePlanets(){
        ApiObject apiObject = restTemplate.getForObject("https://swapi.co/api/planets/", ApiObject.class);
        List<Planet> planets = Arrays.asList(apiObject.getPlanets());

        planetService.savePlanetToDatabase(planets);
        return "Success";
    }

}
