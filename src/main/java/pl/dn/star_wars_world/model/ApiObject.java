package pl.dn.star_wars_world.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiObject {
    @JsonProperty("results")
    Planet[] planets;

    public Planet[] getPlanets() {
        return planets;
    }

    public void setPlanets(Planet[] planets) {
        this.planets = planets;
    }
}
