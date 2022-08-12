package org.lanit.task.controller;

import lombok.RequiredArgsConstructor;
import org.lanit.task.api.car.CarValidateInbound;
import org.lanit.task.api.car.SaveCarInbound;
import org.lanit.task.domain.Car;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class CarController {
    private final SaveCarInbound saveCarInbound;
    private final CarValidateInbound carValidator;

    @PostMapping("/car")
    public ResponseEntity<String> saveCar(@Valid @RequestBody Car car, BindingResult bindingResult) {
        if (bindingResult.hasErrors() || !carValidator.validate(car)) {
            return ResponseEntity.badRequest().build();
        }

        saveCarInbound.saveCar(car);
        return ResponseEntity.ok().build();
    }
}
