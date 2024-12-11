package com.foy.foy5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foy.foy5.model.Car;
import com.foy.foy5.repostory.CarRepository;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public List<Car> getAllCar() {
        return carRepository.findAll();
    }

    public Car updateCar(Integer carId, Car updatedCar) {
        Car existingCar = carRepository.findById(carId).orElseThrow(() -> new RuntimeException("Car not found"));
        existingCar.setCarName(updatedCar.getCarName());
        existingCar.setCarColor(updatedCar.getCarColor());
        existingCar.setCarModel(updatedCar.getCarModel());
        existingCar.setCarNumberPlate(updatedCar.getCarNumberPlate());
        return carRepository.save(existingCar);
    }
}
