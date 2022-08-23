package com.example.sensors.spec;

import com.example.sensors.model.Sensor;
import com.example.sensors.model.SensorType;
import com.example.sensors.model.SensorUnit;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@AllArgsConstructor
public class SensorSpecification implements Specification<Sensor> {

  private final SearchCriteria criteria;

  @Override
  public Predicate toPredicate
      (Root<Sensor> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

    switch (criteria.getOperation()) {
      case ">":
        return builder.greaterThanOrEqualTo(
            root.get(criteria.getKey()), criteria.getValue().toString());
      case "<":
        return builder.lessThanOrEqualTo(
            root.get(criteria.getKey()), criteria.getValue().toString());
      case ":":
        if (root.get(criteria.getKey()).getJavaType() == String.class) {
          return builder.like(
              root.get(criteria.getKey()), "%" + criteria.getValue() + "%");
        } else if (root.get(criteria.getKey()).getJavaType() == SensorUnit.class) {
          return builder.equal(root.get(criteria.getKey()),
              SensorUnit.valueOf(criteria.getValue().toString()));
        } else if (root.get(criteria.getKey()).getJavaType() == SensorType.class) {
          return builder.equal(root.get(criteria.getKey()),
              SensorType.valueOf(criteria.getValue().toString()));
        }
      default: return builder.equal(root.get(criteria.getKey()), criteria.getValue());
    }
  }
}
