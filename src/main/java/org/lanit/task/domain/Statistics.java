package org.lanit.task.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Statistics {
    private long personCount;
    private long carCount;
    private long uniqueVendorCount;

    public Statistics(long personCount, long carCount, long uniqueVendorCount) {
        this.personCount = personCount;
        this.carCount = carCount;
        this.uniqueVendorCount = uniqueVendorCount;
    }
}
