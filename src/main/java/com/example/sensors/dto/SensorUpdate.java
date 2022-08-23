package com.example.sensors.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@RequiredArgsConstructor
public class SensorUpdate extends SensorDto {
  private Long id;
}
