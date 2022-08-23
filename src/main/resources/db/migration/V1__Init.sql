CREATE SEQUENCE IF NOT EXISTS sensor_seq;

CREATE TABLE IF NOT EXISTS sensor
(
    id              INT             NOT NULL,
    title           VARCHAR(30)     NOT NULL,
    model           VARCHAR(15)     NOT NULL,
    type            VARCHAR(20)     NOT NULL,
    unit            VARCHAR(20)     NOT NULL,
    rangeFrom       INT             NOT NULL,
    rangeTo         INT             NOT NULL,
    location        VARCHAR(40)     NOT NULL,
    description     VARCHAR(200)    NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO sensor (id, title, model, type, unit, rangeFrom, rangeTo, location, description)
VALUES(nextval('sensor_seq') , 'testSensor', 'ac-23', 'TEMPERATURE', 'CELSIUS', 10, 30, 'kitchen', 'just for test');

INSERT INTO sensor (id, title, model, type, unit, rangeFrom, rangeTo, location, description)
VALUES(nextval('sensor_seq') , 'testSensor2', 'ac-25', 'PRESSURE', 'BAR', 500, 1000, 'room', 'just for test')