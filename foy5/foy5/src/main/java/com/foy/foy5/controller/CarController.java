package com.foy.foy5.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import com.foy.foy5.model.Car;
import com.foy.foy5.repostory.CarRepository;
import com.foy.foy5.service.CarService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class CarController {

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private CarService carService;

    @GetMapping()
    public String root(Model model) {
        model.addAttribute("CarList", carService.getAllCar());
        return "/index";
    }

    @PostMapping("/newCar")
    Car newCar(@RequestBody Car newCar) {
        return carRepository.save(newCar);
    }

    @GetMapping("/car/{carId}")
    public ResponseEntity<Car> getCar(@PathVariable Integer carId) {
        return carRepository.findById(carId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/update/{carId}")
    public Car updateCar(@PathVariable Integer carId, @RequestBody Car updatedCar) {
        return carService.updateCar(carId, updatedCar);
    }

    @GetMapping("/delCar/{carId}")
    String deleteCar(@PathVariable Integer carId) {

        carRepository.deleteById(carId);
        return "redirect:/";
    }
}
