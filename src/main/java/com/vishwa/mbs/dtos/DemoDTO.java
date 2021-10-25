package com.vishwa.mbs.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class DemoDTO {

    @JsonProperty("demo_id")
    private int demoId ;


    @JsonProperty("demo_name")
    private String demoName ;

    @JsonProperty("demo_desc")
    private String demoDescription;

    public int getDemoId() {
        return demoId;
    }

    public void setDemoId(int demoId) {
        this.demoId = demoId;
    }

    public String getDemoName() {
        return demoName;
    }

    public void setDemoName(String demoName) {
        this.demoName = demoName;
    }

    public String getDemoDescription() {
        return demoDescription;
    }

    public void setDemoDescription(String demoDescription) {
        this.demoDescription = demoDescription;
    }

    @Override
    public String toString() {
        return "DemoDTO{" +
                "demoId=" + demoId +
                ", demoName='" + demoName + '\'' +
                ", demoDescription='" + demoDescription + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DemoDTO demoDTO = (DemoDTO) o;
        return demoId == demoDTO.demoId && Objects.equals(demoName, demoDTO.demoName) && Objects.equals(demoDescription, demoDTO.demoDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(demoId, demoName, demoDescription);
    }
}
