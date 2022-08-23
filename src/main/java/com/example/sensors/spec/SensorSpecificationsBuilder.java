package com.example.sensors.spec;

import com.example.sensors.model.Sensor;
import org.springframework.data.jpa.domain.Specification;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SensorSpecificationsBuilder {
  private final List<SearchCriteria> criteria;

  public SensorSpecificationsBuilder() {
    criteria = new ArrayList<>();
  }

  public SensorSpecificationsBuilder with(String key, String operation, Object value) {
    criteria.add(new SearchCriteria(key, operation, value));
    return this;
  }

  public Specification<Sensor> build() {
    if (criteria.size() == 0) {
      return null;
    }

    List<Specification<?>> specs = criteria.stream()
        .map(SensorSpecification::new)
        .collect(Collectors.toList());

    Specification result = specs.get(0);

    for (int i = 1; i < criteria.size(); i++) {
      result = Specification.where(result).or(specs.get(i));
    }
    return result;
  }
}
