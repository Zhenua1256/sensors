package com.example.sensors.controller;

import com.example.sensors.dto.SensorCreate;
import com.example.sensors.dto.SensorDto;
import com.example.sensors.dto.SensorUpdate;
import com.example.sensors.model.Sensor;
import com.example.sensors.service.SensorService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class SensorController {

  private final SensorService sensorService;

  @GetMapping(value = "/sensors")
  @PreAuthorize("hasAnyRole('ADMIN', 'VIEWER')")
  public Page<Sensor> getAll(Pageable pageable, @RequestParam(value = "search", required = false) String[] search) {
    return sensorService.getAll(pageable, search);
  }

  @DeleteMapping(value = "/sensors/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public Long delete(@PathVariable Long id) {
    return sensorService.delete(id);
  }

  @PostMapping(value = "/sensors")
  @PreAuthorize("hasRole('ADMIN')")
  public SensorDto create(@RequestBody SensorCreate sensorCreate) {
    return sensorService.create(sensorCreate);
  }

  @PutMapping(value = "/sensors")
  @PreAuthorize("hasRole('ADMIN')")
  public SensorDto update(@RequestBody SensorUpdate sensorUpdate) {
    return sensorService.update(sensorUpdate);
  }

  @GetMapping(value = "/sensors/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public SensorDto getById(@PathVariable Long id) {
    return sensorService.getById(id);
  }
}
