package com.foy.foy5.repostory;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foy.foy5.model.Car;

public interface CarRepository extends JpaRepository<Car, Integer> {

}

