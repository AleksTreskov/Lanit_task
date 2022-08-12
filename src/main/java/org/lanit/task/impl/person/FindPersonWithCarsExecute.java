package org.lanit.task.impl.person;

import lombok.RequiredArgsConstructor;
import org.lanit.task.api.person.FindPersonWithCarsInbound;
import org.lanit.task.domain.Person;
import org.lanit.task.repository.CarRepository;
import org.lanit.task.repository.PersonRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindPersonWithCarsExecute implements FindPersonWithCarsInbound {
    private final PersonRepository personRepository;
    private final CarRepository carRepository;

    @Override
    public Person findPersonWithCars(long id) {
        Optional<Person> optPerson = personRepository.findById(id);
        if (optPerson.isEmpty()) {
            return null;
        }
        Person person = optPerson.get();
        person.setCars(carRepository.findAllByOwnerId(id));
        return person;
    }
}
