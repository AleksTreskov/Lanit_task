package org.lanit.task.controller;

import lombok.RequiredArgsConstructor;
import org.lanit.task.api.person.FindPersonWithCarsInbound;
import org.lanit.task.api.person.PersonValidateInbound;
import org.lanit.task.api.person.SavePersonInbound;
import org.lanit.task.domain.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class PersonController {
    private final SavePersonInbound savePersonInbound;
    private final FindPersonWithCarsInbound findPersonWithCarsInbound;
    private final PersonValidateInbound personValidator;

    @PostMapping("/person")
    public ResponseEntity<String> savePerson(@Valid @RequestBody Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors() || !personValidator.validate(person)) {
            return ResponseEntity.badRequest().build();
        }
        savePersonInbound.savePerson(person);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/personwithcars")
    public ResponseEntity<Person> findPersonWithCarsById(@RequestParam("personid") long id) {

        Person person = findPersonWithCarsInbound.findPersonWithCars(id);
        if (person == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(person);
    }
}
