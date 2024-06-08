package com.example.lab7_20191802.beans;

import java.math.BigDecimal;
import com.example.lab7_20191802.beans.Regions;

public class Countries {
    private String country_id;
    private String country_name;
    private Regions region_id;

    public String getCountry_id() {
        return country_id;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public Regions getRegion_id() {
        return region_id;
    }

    public void setRegion_id(Regions region_id) {
        this.region_id = region_id;
    }
}