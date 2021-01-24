package WestTwo2020.thirdRound;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class countryCovidMessage {
    @JSONField(name = "confirmed")
    private int confirmed;

    @JSONField(name = "recovered")
    private int recovered;

    @JSONField(name = "deaths")
    private int deaths;

    @JSONField(name = "country")
    private String country;

    @JSONField(name = "population")
    private int population;

    @JSONField(name = "sq_km_area")
    private int sq_km_area;

    @JSONField(name = "life_expectancy")
    private double life_expectancy;

    @JSONField(name = "elevation_in_meters")
    private int elevation_in_meters;

    @JSONField(name = "continent")
    private String continent;

    @JSONField(name = "abbreviation")
    private String abbreviation;

    @JSONField(name = "location")
    private String location;

    @JSONField(name = "iso")
    private int iso;

    @JSONField(name = "capital_city")
    private String capital_city;

    @JSONField(name = "lat")
    private double lat;

    @JSONField(name = "aLong")
    private double aLong;

    @JSONField(name = "updated")
    private Date updated;

    //全参构造方法
    public countryCovidMessage(JSONObject jsonObject) {
        this.confirmed = jsonObject.getInteger("confirmed");
        this.recovered = jsonObject.getInteger("recovered");
        this.deaths = jsonObject.getInteger("deaths");
        this.country = jsonObject.getString("country");
        this.population = jsonObject.getInteger("population");
        this.sq_km_area = jsonObject.getInteger("sq_km_area");
        this.life_expectancy = jsonObject.getDouble("life_expectancy");
        this.elevation_in_meters = jsonObject.getInteger("elevation_in_meters");
        this.continent = jsonObject.getString("continent");
        this.abbreviation = jsonObject.getString("abbreviation");
        this.location = jsonObject.getString("location");
        this.iso = jsonObject.getInteger("iso");
        this.capital_city = jsonObject.getString("capital_city");
//        this.lat = jsonObject.getDouble("lat");
//        this.aLong = jsonObject.getDouble("long");
//        this.updated = jsonObject.getDate("updated");
    }


    //数据更新时更改的数据
    public void setConfirmed(int confirmed) {
        this.confirmed = confirmed;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setSq_km_area(int sq_km_area) {
        this.sq_km_area = sq_km_area;
    }

    public void setLife_expectancy(double life_expectancy) {
        this.life_expectancy = life_expectancy;
    }

    public void setElevation_in_meters(int elevation_in_meters) {
        this.elevation_in_meters = elevation_in_meters;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setIso(int iso) {
        this.iso = iso;
    }

    public void setCapital_city(String capital_city) {
        this.capital_city = capital_city;
    }

    //数据传入数据库时的数据（即全数据）
    public int getConfirmed() {
        return confirmed;
    }

    public int getRecovered() {
        return recovered;
    }

    public int getDeaths() {
        return deaths;
    }

    public String getCountry() {
        return country;
    }

    public int getPopulation() {
        return population;
    }

    public int getSq_km_area() {
        return sq_km_area;
    }

    public double getLife_expectancy() {
        return life_expectancy;
    }

    public int getElevation_in_meters() {
        return elevation_in_meters;
    }

    public String getContinent() {
        return continent;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getLocation() {
        return location;
    }

    public int getIso() {
        return iso;
    }

    public String getCapital_city() {
        return capital_city;
    }

    @Override
    public String toString() {
        return "countryCovidMessage{" +
                "confirmed=" + confirmed +
                ", recovered=" + recovered +
                ", deaths=" + deaths +
                ", country='" + country + '\'' +
                ", population=" + population +
                ", sq_km_area=" + sq_km_area +
                ", life_expectancy=" + life_expectancy +
                ", elevation_in_meters='" + elevation_in_meters + '\'' +
                ", continent='" + continent + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                ", location='" + location + '\'' +
                ", iso=" + iso +
                ", capital_city='" + capital_city + '\'' +
                ", lat=" + lat +
                ", aLong=" + aLong +
                ", updated=" + updated +
                '}';
    }
}
