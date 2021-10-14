package com.vishwa.mbs.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Objects;

@Entity
public class Engine {

    @Id
    private int engineId ;

    private String engineName ;

    @OneToOne(mappedBy = "engine")
    private Car car;

    public int getEngineId() {
        return engineId;
    }

    public void setEngineId(int engineId) {
        this.engineId = engineId;
    }

    public String getEngineName() {
        return engineName;
    }

    public void setEngineName(String engineName) {
        this.engineName = engineName;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "engineId=" + engineId +
                ", engineName='" + engineName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engine engine = (Engine) o;
        return engineId == engine.engineId && Objects.equals(engineName, engine.engineName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(engineId, engineName);
    }
}
