package org.lanit.task.impl.car;

import lombok.RequiredArgsConstructor;
import org.lanit.task.api.car.FindCarByIdInbound;
import org.lanit.task.domain.Car;
import org.lanit.task.repository.CarRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindCarByIdExecute implements FindCarByIdInbound {
    private final CarRepository carRepository;

    @Override
    public Optional<Car> findCarById(long id) {
        return carRepository.findById(id);
    }
}
