package com.foy.foy5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.foy.foy5.service.CarService;

@Controller
public class OperationController {

    @Autowired
    CarService carsService;


    

    
}

