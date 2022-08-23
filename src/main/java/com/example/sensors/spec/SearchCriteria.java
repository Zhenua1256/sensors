package com.example.sensors.spec;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class SearchCriteria {
  private String key;
  private String operation;
  private Object value;
}
