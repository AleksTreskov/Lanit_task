package org.lanit.task.impl.util;

import lombok.RequiredArgsConstructor;
import org.lanit.task.api.utils.ClearCarsAndPersonsInbound;
import org.lanit.task.repository.CarRepository;
import org.lanit.task.repository.PersonRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClearCarsAndPersonsExecute implements ClearCarsAndPersonsInbound {
    private final CarRepository carRepository;
    private final PersonRepository personRepository;

    @Override
    public void clear() {
        carRepository.deleteAll();
        personRepository.deleteAll();
    }
}
