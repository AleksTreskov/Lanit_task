package org.lanit.task.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;


@Table(name = "PERSONS",schema = "personcar")
@Entity
@Getter
@Setter
public class Person {
    @Id
    private long id;
    @Column(name = "name")
    @NotEmpty
    private String name;
    @Column(name = "birth_date")
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private Date birthDate;
    @OneToMany
    @JoinColumn(name = "owner_id")
    private List<Car> cars;
}
