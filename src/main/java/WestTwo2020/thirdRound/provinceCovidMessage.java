package WestTwo2020.thirdRound;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

public class provinceCovidMessage {

    @JSONField(name = "lat")
    private Double lat;

    @JSONField(name = "aLong")
    private Double aLong;

    @JSONField(name = "confirmed")
    private int confirmed;

    @JSONField(name = "recovered")
    private int recovered;

    @JSONField(name = "deaths")
    private int deaths;

    @JSONField(name = "updated")
    private java.util.Date updated;

    public provinceCovidMessage(JSONObject jsonObject) {
        this.confirmed = jsonObject.getInteger("confirmed");
        this.recovered = jsonObject.getInteger("recovered");
        this.deaths = jsonObject.getInteger("deaths");
        this.lat = jsonObject.getDouble("lat");
        this.aLong = jsonObject.getDouble("long");
        this.updated = jsonObject.getDate("updated");
    }

    public Double getLat() {
        return lat;
    }

    public Double getaLong() {
        return aLong;
    }

    public int getConfirmed() {
        return confirmed;
    }

    public int getRecovered() {
        return recovered;
    }

    public int getDeaths() {
        return deaths;
    }

    public java.util.Date getUpdated() {
        return updated;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public void setaLong(Double aLong) {
        this.aLong = aLong;
    }

    public void setConfirmed(int confirmed) {
        this.confirmed = confirmed;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public void setUpdated(java.sql.Date updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "provinceCovidMessage{" +
                "lat=" + lat +
                ", aLong=" + aLong +
                ", confirmed=" + confirmed +
                ", recovered=" + recovered +
                ", deaths=" + deaths +
                ", updated=" + updated +
                '}';
    }
}
