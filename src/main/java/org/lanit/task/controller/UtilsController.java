package org.lanit.task.controller;

import lombok.RequiredArgsConstructor;
import org.lanit.task.api.utils.ClearCarsAndPersonsInbound;
import org.lanit.task.api.utils.GetStatisticsInbound;
import org.lanit.task.domain.Statistics;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UtilsController {
    private final GetStatisticsInbound getStatisticsInbound;
    private final ClearCarsAndPersonsInbound clearCarsAndPersonsInbound;

    @GetMapping("/statistics")
    public ResponseEntity<Statistics> getStatistics() {
        return new ResponseEntity<>(getStatisticsInbound.getStatistics(), HttpStatus.OK);
    }

    @GetMapping("/clear")
    public ResponseEntity<String> clearCarsAndPersons() {
        clearCarsAndPersonsInbound.clear();
        return ResponseEntity.ok().build();
    }
}
