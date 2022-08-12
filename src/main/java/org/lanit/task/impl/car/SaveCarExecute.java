package org.lanit.task.impl.car;

import org.lanit.task.api.car.SaveCarInbound;
import org.lanit.task.domain.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.lanit.task.repository.CarRepository;

@Component
@RequiredArgsConstructor
public class SaveCarExecute implements SaveCarInbound {
    private final CarRepository carRepository;

    @Override
    @Transactional
    public void saveCar(Car car) {
        carRepository.save(car);
    }
}
