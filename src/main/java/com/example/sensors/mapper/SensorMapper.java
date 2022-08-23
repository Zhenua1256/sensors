package com.example.sensors.mapper;

import com.example.sensors.dto.SensorCreate;
import com.example.sensors.dto.SensorDto;
import com.example.sensors.dto.SensorUpdate;
import com.example.sensors.model.Sensor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SensorMapper {

  @Mapping(source = "title", target = "title")
  @Mapping(source = "model", target = "model")
  @Mapping(source = "rangeFrom", target = "rangeFrom")
  @Mapping(source = "rangeTo", target = "rangeTo")
  @Mapping(source = "type", target = "type")
  @Mapping(source = "unit", target = "unit")
  @Mapping(source = "location", target = "location")
  @Mapping(source = "description", target = "description")
  SensorDto mapToDto(Sensor entity);

  @Mapping(source = "title", target = "title")
  @Mapping(source = "model", target = "model")
  @Mapping(source = "rangeFrom", target = "rangeFrom")
  @Mapping(source = "rangeTo", target = "rangeTo")
  @Mapping(source = "type", target = "type")
  @Mapping(source = "unit", target = "unit")
  @Mapping(source = "location", target = "location")
  @Mapping(source = "description", target = "description")
  Sensor mapToEntity(SensorCreate dto);

  @Mapping(source = "id", target = "id")
  @Mapping(source = "title", target = "title")
  @Mapping(source = "model", target = "model")
  @Mapping(source = "rangeFrom", target = "rangeFrom")
  @Mapping(source = "rangeTo", target = "rangeTo")
  @Mapping(source = "type", target = "type")
  @Mapping(source = "unit", target = "unit")
  @Mapping(source = "location", target = "location")
  @Mapping(source = "description", target = "description")
  Sensor mapToEntity(SensorUpdate dto);
}
