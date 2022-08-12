package org.lanit.task.impl.car;

import lombok.RequiredArgsConstructor;
import org.lanit.task.api.car.CarValidateInbound;
import org.lanit.task.api.car.FindCarByIdInbound;
import org.lanit.task.api.person.FindPersonByIdInbound;
import org.lanit.task.domain.Car;
import org.lanit.task.domain.Person;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDate;
import java.util.Date;
import java.util.Optional;
import java.util.regex.Pattern;

//Validator class for checking correct data and person's legal age
@Component
@RequiredArgsConstructor
public class CarValidateExecute implements CarValidateInbound {
    private final FindPersonByIdInbound findPersonByIdInbound;
    private final FindCarByIdInbound findCarByIdInbound;

    private final Pattern pattern = Pattern.compile("^[а-яА-Яa-zA-Z0-9]+-[а-яА-Яa-zA-Z0-9]+$");

    @Override
    public boolean validate(Car car) {
        if (!pattern.matcher(car.getModel()).find()) {
            return false;
        }
        Optional<Person> optPerson = findPersonByIdInbound.getPersonById(car.getOwnerId());
        if (optPerson.isEmpty()) {
            return false;
        }
        Optional<Car> optCar = findCarByIdInbound.findCarById(car.getId());
        if (optCar.isPresent()) {
            return false;
        }

        LocalDate legalAgeDate = LocalDate.now().atStartOfDay().minusYears(18).plusDays(1).toLocalDate();
        if (!legalAgeDate.isAfter(
            ChronoLocalDate.from(convertToLocalDateViaInstant(optPerson.get().getBirthDate())))) {
            return false;
        }

        StringBuilder stringBuilder = new StringBuilder(car.getModel());
        String vendor = stringBuilder.substring(0, stringBuilder.indexOf("-"));
        String model = stringBuilder.substring(stringBuilder.indexOf("-") + 1);
        car.setVendor(vendor);
        car.setModel(model);
        return true;
    }

    // ===================================================================================================================
    // = Implementation
    // ===================================================================================================================


    //Converter from Date to LocalDate
    private LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
            .atZone(ZoneId.systemDefault())
            .toLocalDate();
    }
}
