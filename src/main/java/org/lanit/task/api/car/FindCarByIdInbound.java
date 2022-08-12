package org.lanit.task.api.car;

import org.lanit.task.domain.Car;

import java.util.Optional;

public interface FindCarByIdInbound {
    Optional<Car> findCarById(long id);
}
