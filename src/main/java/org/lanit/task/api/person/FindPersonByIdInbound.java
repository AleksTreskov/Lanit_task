package org.lanit.task.api.person;

import org.lanit.task.domain.Person;

import java.util.Optional;

public interface FindPersonByIdInbound {
    Optional<Person> getPersonById(long id);
}
