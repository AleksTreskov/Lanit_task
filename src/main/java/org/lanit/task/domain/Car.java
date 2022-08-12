package org.lanit.task.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Table(name = "CARS",schema = "personcar")
@Entity
@Getter
@Setter
public class Car {
    @Id
    private long id;
    @Column(name = "vendor")
    private String vendor;
    @NotBlank
    @Column(name = "model")
    private String model;
    @Column(name = "horse_power")
    @Min(value = 1)
    private int horsePower;
    @Column(name = "owner_id")
    @NotNull
    private long ownerId;
}
