package org.lanit.task.impl.person;

import org.lanit.task.api.person.FindPersonByIdInbound;
import org.lanit.task.domain.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.lanit.task.repository.PersonRepository;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindPersonByIdExecute implements FindPersonByIdInbound {
    private final PersonRepository personRepository;

    @Override
    public Optional<Person> getPersonById(long id) {
        return personRepository.findById(id);
    }
}
