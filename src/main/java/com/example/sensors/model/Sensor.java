package com.example.sensors.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name = "SENSOR")
public class Sensor {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sensor_seq")
  @SequenceGenerator(name = "sensor_seq", sequenceName = "sensor_seq", allocationSize = 1)
  @Column(name = "id")
  private Long id;

  @Column(name = "title", length = 30)
  @NotNull
  private String title;

  @Column(name = "model", length = 15)
  @NotNull
  private String model;

  @Column(name = "rangefrom")
  private Integer rangeFrom;

  @Column(name = "rangeto")
  private Integer rangeTo;

  @Column(name = "type")
  @Enumerated(EnumType.STRING)
  @NotNull
  private SensorType type;

  @Column(name = "unit")
  @Enumerated(EnumType.STRING)
  @NotNull
  private SensorUnit unit;

  @Column(name = "location", length = 40)
  @NotNull
  private String location;

  @Column(name = "description", length = 200)
  @NotNull
  private String description;
}
