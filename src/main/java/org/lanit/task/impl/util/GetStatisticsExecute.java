package org.lanit.task.impl.util;

import org.lanit.task.api.utils.GetStatisticsInbound;
import org.lanit.task.domain.Car;
import org.lanit.task.domain.Statistics;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.lanit.task.repository.CarRepository;
import org.lanit.task.repository.PersonRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetStatisticsExecute implements GetStatisticsInbound {
    private final PersonRepository personRepository;
    private final CarRepository carRepository;

    @Override
    public Statistics getStatistics() {
        return new Statistics(personRepository.count(), carRepository.count(),getUniqueVendors());
    }

    // ===================================================================================================================
    // = Implementation
    // ===================================================================================================================
    private Long getUniqueVendors(){

        List<Car> cars = carRepository.findAll();
        return cars.stream().map(car -> car.getVendor().toLowerCase()).distinct().count();
    }
}
