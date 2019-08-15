package pl.dn.star_wars_world.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Planet {
    @JsonProperty("name")
    private String name;
    @JsonProperty("temperate")
    private String temperate;
    @JsonProperty("terrain")
    private String terrain;
    @JsonProperty("population")
    private String population;

    public Planet() {
    }

    public Planet(String name, String temperate, String terrain, String population) {
        this.name = name;
        this.temperate = temperate;
        this.terrain = terrain;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTemperate() {
        return temperate;
    }

    public void setTemperate(String temperate) {
        this.temperate = temperate;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "name='" + name + '\'' +
                ", temperate='" + temperate + '\'' +
                ", terrain='" + terrain + '\'' +
                ", population='" + population + '\'' +
                '}';
    }
}
