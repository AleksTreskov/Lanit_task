package org.lanit.task.impl.person;

import lombok.RequiredArgsConstructor;
import org.lanit.task.api.person.FindPersonByIdInbound;
import org.lanit.task.api.person.PersonValidateInbound;
import org.lanit.task.domain.Person;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDate;
import java.util.Date;

//Validator class for checking correct data
@Component
@RequiredArgsConstructor
public class PersonValidateExecute implements PersonValidateInbound {
    private final FindPersonByIdInbound findPersonByIdInbound;

    @Override
    public boolean validate(Person person) {

        if (findPersonByIdInbound.getPersonById(person.getId()).isPresent()) {
            return false;
        }
        LocalDate legalAgeDate = LocalDate.now().atStartOfDay().toLocalDate();
        if (!legalAgeDate.isAfter(
            ChronoLocalDate.from(convertToLocalDateViaInstant(person.getBirthDate())))) {
            return false;
        }

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
