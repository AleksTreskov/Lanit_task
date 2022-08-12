package org.lanit.task.api.car;

import org.lanit.task.domain.Car;

public interface CarValidateInbound {
    boolean validate(Car car);
}
