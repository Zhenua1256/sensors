package com.example.sensors.dto;

import com.example.sensors.model.SensorType;
import com.example.sensors.model.SensorUnit;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@RequiredArgsConstructor
public class SensorDto {
  private String title;

  private String model;

  private Integer rangeFrom;

  private Integer rangeTo;

  @JsonProperty("type")
  private SensorType type;

  @JsonProperty("unit")
  private SensorUnit unit;

  private String location;

  private String description;
}
