package com.example.sensors.service;

import com.example.sensors.dto.SensorCreate;
import com.example.sensors.dto.SensorDto;
import com.example.sensors.dto.SensorUpdate;
import com.example.sensors.model.Sensor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SensorService {
  Page<Sensor> getAll(Pageable pageable, String[] search);

  Long delete(Long id);

  SensorDto create(SensorCreate sensorCreate);

  SensorDto update(SensorUpdate sensorUpdate);

  SensorDto getById(Long id);
}
