package com.vishwa.mbs.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class City {
    @Id
    @GeneratedValue
    private int cityId;

    @Column(length = 20, nullable = false)
    private String cityName;

    public City() {}

    public City(int cityId, String cityName) {
        this.cityId = cityId;
        this.cityName = cityName;
    }

    public City(String cityName) {
        this.cityName = cityName;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "City{" + "cityId=" + cityId + ", cityName='" + cityName + '\'' + '}';
    }
}