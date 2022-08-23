package com.example.sensors.repository;

import com.example.sensors.model.Sensor;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SensorRepository extends PagingAndSortingRepository<Sensor, Long>, JpaSpecificationExecutor<Sensor> {
}
