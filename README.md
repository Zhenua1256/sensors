# Sensors
Service for check info about sensor

## Before build need create database with name 'sensor'

## How to build:
It's a maven project
```
mvn clean install
```
## How to use:

**For every request needs use basic auth with credensial**

```
for admin: username admin, password admin
```

```
for viewer: username viewer, password viewer
```


## Get all sensors ( for all authorized users )

**/sensors**  

Request type: GET  

Params: -

Returns: list sensors

## Get one sensor by id ( only for user with role 'ADMIN' )

**/sensor/{id}**

Request type: GET 

Params: id needs sensor
```
/sensor/1
```
Returns: sensorDto  - object with needs field, for example:
```
{
    "title": "testSensorBAR",
    "model": "bar",
    "rangeFrom": 550,
    "rangeTo": 1250,
    "location": "bathroom",
    "description": "just for test create",
    "type": "PRESSURE",
    "unit": "BAR"
}
```

## Create new sensor  ( only for user with role 'ADMIN' )

**/sensor**  

Request type: POST  

Params: body SensorCreate for example:

```
{
    "title": "testSensorBAR",
    "model": "vol",
    "rangeFrom": 550,
    "rangeTo": 1250,
    "location": "kitchen",
    "description": "just for test create",
    "type": "PRESSURE",
    "unit": "BAR"
}
```

Returns: sensorDto  - object with all fields

## Update sensor  ( only for user with role 'ADMIN' )

**/sensor**  

Request type: PUT  

Params: body SensorUpdate for example:

```
{
    "id": 5,
    "title": "testSensorBAR",
    "model": "bar",
    "rangeFrom": 550,
    "rangeTo": 1250,
    "location": "bathroom",
    "description": "just for test create",
    "type": "PRESSURE",
    "unit": "BAR"
}
```

Returns: sensorDto  - object with all changes fields

## Delete sensor  ( only for user with role 'ADMIN' )

**/sensor/{id}**  

Request type: DELETE  

Params: id sensor for delete:

```
/sensor/1
```
Returns: remote sensor id
