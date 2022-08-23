package com.example.sensors.service;

import com.example.sensors.dto.SensorCreate;
import com.example.sensors.dto.SensorDto;
import com.example.sensors.dto.SensorUpdate;
import com.example.sensors.mapper.SensorMapper;
import com.example.sensors.model.Sensor;
import com.example.sensors.repository.SensorRepository;
import com.example.sensors.spec.SensorSpecificationsBuilder;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SensorServiceImpl implements SensorService {

  private final SensorRepository sensorRepository;
  private final SensorMapper sensorMapper;

  @Override
  public Page<Sensor> getAll(Pageable pageable, String[] search) {
    SensorSpecificationsBuilder builder = new SensorSpecificationsBuilder();
    Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
    List<Matcher> list = Arrays.stream(search)
        .map(search1 -> pattern.matcher(search1 + ","))
        .collect(Collectors.toList());
    list.forEach(matcher -> {
      while (matcher.find()) {
        builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
      }
    });
    Specification<Sensor> spec = builder.build();

    return sensorRepository.findAll(spec, pageable);
  }

  @Override
  public Long delete(Long id) {
    sensorRepository.deleteById(id);
    return id;
  }

  @Override
  public SensorDto create(SensorCreate sensorCreate) {
    return sensorMapper.mapToDto(sensorRepository.save(sensorMapper.mapToEntity(sensorCreate)));
  }

  @Override
  public SensorDto update(SensorUpdate sensorUpdate) {
    return sensorMapper.mapToDto(sensorRepository.save(sensorMapper.mapToEntity(sensorUpdate)));
  }

  @Override
  public SensorDto getById(Long id) {
    return sensorRepository.findById(id).map(sensorMapper::mapToDto).orElse(null);
  }
}
