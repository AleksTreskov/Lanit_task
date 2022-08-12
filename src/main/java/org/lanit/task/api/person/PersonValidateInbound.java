package org.lanit.task.api.person;

import org.lanit.task.domain.Person;

public interface PersonValidateInbound {
    boolean validate(Person person);
}
