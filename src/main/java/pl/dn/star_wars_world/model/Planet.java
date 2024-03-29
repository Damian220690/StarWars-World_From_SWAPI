package pl.dn.star_wars_world.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Planet {
    @JsonProperty("name")
    private String name;
    @JsonProperty("climate")
    private String climate;
    @JsonProperty("terrain")
    private String terrain;
    @JsonProperty("population")
    private String population;
    @JsonProperty("rotation_period")
    private String rotationPeriod;
    @JsonProperty("diameter")
    private String diameter;

    public Planet() {
    }

    public Planet(String name, String climate, String terrain, String population, String rotationPeriod, String diameter) {
        this.name = name;
        this.climate = climate;
        this.terrain = terrain;
        this.population = population;
        this.rotationPeriod = rotationPeriod;
        this.diameter = diameter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
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

    public String getRotationPeriod() {
        return rotationPeriod;
    }

    public void setRotationPeriod(String rotationPeriod) {
        this.rotationPeriod = rotationPeriod;
    }

    public String getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "name='" + name + '\'' +
                ", climate='" + climate + '\'' +
                ", terrain='" + terrain + '\'' +
                ", population='" + population + '\'' +
                ", rotationPeriod='" + rotationPeriod + '\'' +
                ", diameter='" + diameter + '\'' +
                '}';
    }
}
