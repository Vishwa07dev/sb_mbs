package com.vishwa.mbs.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Objects;

@Entity
public class Car {

    @Id
    private int carId ;

    private String carName ;

    @OneToOne
    @JoinColumn(name="engine_id")
    private Engine engine ;

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", carName='" + carName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return carId == car.carId && Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carId, carName);
    }
}
