package org.lanit.task.impl.person;

import org.lanit.task.api.person.SavePersonInbound;
import org.lanit.task.domain.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.lanit.task.repository.PersonRepository;

@Component
@RequiredArgsConstructor
public class SavePersonExecute implements SavePersonInbound {
    private final PersonRepository personRepository;

    @Override
    @Transactional
    public void savePerson(Person person) {
        personRepository.save(person);
    }
}
