CREATE TABLE equipos (
    codEquipo VARCHAR(10),
    nombreEquipo VARCHAR(50) NOT NULL,
    PRIMARY KEY (codEquipo)
);

CREATE TABLE TEMPORADA (
    CODTEMP VARCHAR(3),
    NOMBRE VARCHAR(30),
    PRIMARY KEY (CODTEMP)
);

CREATE TABLE partidos (
    codPartido VARCHAR(10) PRIMARY KEY,
    fecha_partido DATE,
    temporada VARCHAR(3) NOT NULL,
    jornada INT NOT NULL,
    puntosLocal INT,
    puntosVisitante INT,
    codEquipoLocal VARCHAR(10) NOT NULL,
    codEquipoVisitante VARCHAR(10) NOT NULL,
    CONSTRAINT fk_partidos_equipos FOREIGN KEY (codEquipoLocal) REFERENCES equipos (codEquipo),
    CONSTRAINT fk_partidos_equipos1 FOREIGN KEY (codEquipoVisitante) REFERENCES equipos (codEquipo),
    CONSTRAINT fk_partidos_temporada FOREIGN KEY (temporada) REFERENCES TEMPORADA (CODTEMP)
);

CREATE TABLE JUGADORES (
    CODJUGADOR VARCHAR(10),
    NOMBREJUGADOR VARCHAR(50) NOT NULL,
    fechanac DATE,
    PRIMARY KEY (CODJUGADOR)
);

CREATE TABLE PARTIDOS_JUGADORES (
    CODPARTIDO VARCHAR(10),
    CODJUGADOR VARCHAR(10),
    CANASTAS INT,
    ASISTENCIAS INT,
    REBOTES INT,
    PRIMARY KEY (CODPARTIDO, CODJUGADOR),
    CONSTRAINT FK_JUGADAS2 FOREIGN KEY (CODJUGADOR) REFERENCES JUGADORES (CODJUGADOR),
    CONSTRAINT FK_JUGADAS3 FOREIGN KEY (CODPARTIDO) REFERENCES partidos (codPartido)
);

CREATE TABLE TEMP_EQUIPO_JUGADOR (
    CODTEMP VARCHAR(3),
    CODEQUIPO VARCHAR(10),
    CODJUGADOR VARCHAR(10),
    SALARIO INT,
    fecha_ingreso DATE,
    PRIMARY KEY (CODTEMP, CODEQUIPO, CODJUGADOR),
    CONSTRAINT FKF1 FOREIGN KEY (CODTEMP) REFERENCES TEMPORADA (CODTEMP),
    CONSTRAINT FKF2 FOREIGN KEY (CODEQUIPO) REFERENCES equipos (codEquipo),
    CONSTRAINT FKF3 FOREIGN KEY (CODJUGADOR) REFERENCES JUGADORES (CODJUGADOR)
);

INSERT INTO TEMPORADA (CODTEMP, NOMBRE) VALUES 
('t1', '2008_2009'),
('t2', '2009_2010'),
('t3', '2010_2011');

INSERT INTO equipos (codEquipo, nombreEquipo) VALUES 
('e1', 'Asefa Estudiantes'),
('e2', 'Caja Sol Sevilla'),
('e3', 'Unicaja Málaga'),
('e4', 'Madrid');

INSERT INTO JUGADORES (CODJUGADOR, NOMBREJUGADOR, fechanac) VALUES 
('j1', 'Esteban D.', '1985-10-10'),
('j2', 'Rafa Martinez', '1980-10-10'),
('j3', 'Banie', '1990-10-10'),
('j4', 'Fitch.', '1992-10-10'),
('j5', 'Telotovic', '1989-02-13'),
('j6', 'Juan Peñi', '1985-10-10'),
('j7', 'Juan Xi', '1991-10-02'),
('j8', 'Mario G', '1991-10-02'),
('j9', 'Telvio J', '1992-10-02'),
('j10', 'Mario G', '1991-10-02'),
('j11', 'Telvio J', '1991-10-02');

INSERT INTO partidos (codPartido, fecha_partido, temporada, jornada, puntosLocal, puntosVisitante, codEquipoLocal, codEquipoVisitante) VALUES 
('p1', '2008-01-01', 't1', 1, 88, 99, 'e1', 'e2'),
('p2', '2008-01-01', 't1', 1, 77, 66, 'e3', 'e4'),
('p3', '2008-02-02', 't1', 2, 77, 66, 'e4', 'e3'),
('p4', '2008-02-02', 't1', 2, 77, 66, 'e2', 'e1'),
('p5', '2008-03-03', 't1', 3, 77, 66, 'e1', 'e4'),
('p6', '2008-03-03', 't1', 3, 77, 66, 'e3', 'e2'),
('p7', '2008-04-04', 't1', 4, 97, 66, 'e4', 'e1'),
('p8', '2008-04-04', 't1', 4, 70, 90, 'e2', 'e3'),
('p9', '2009-01-01', 't2', 1, 54, 78, 'e1', 'e2'),
('p10', '2009-01-01', 't2', 1, 79, 56, 'e3', 'e4'),
('p11', '2009-02-02', 't2', 2, 70, 90, 'e4', 'e3'),
('p12', '2009-02-02', 't2', 2, 90, 66, 'e2', 'e1'),
('p13', '2009-03-03', 't2', 3, 90, 66, 'e1', 'e4'),
('p14', '2009-03-03', 't2', 3, 77, 65, 'e3', 'e2'),
('p15', '2009-04-04', 't2', 4, 97, 65, 'e4', 'e1'),
('p16', '2009-04-04', 't2', 4, 90, 90, 'e2', 'e3');

INSERT INTO PARTIDOS_JUGADORES (CODPARTIDO, CODJUGADOR, CANASTAS, ASISTENCIAS, REBOTES) VALUES 
('p1', 'j1', 4, 5, 6),
('p1', 'j2', 2, 0, 6),
('p1', 'j3', 4, 5, 3),
('p1', 'j5', 0, 5, 6),
('p1', 'j6', 2, 5, 6);

INSERT INTO TEMP_EQUIPO_JUGADOR (CODTEMP, CODEQUIPO, CODJUGADOR, SALARIO, fecha_ingreso) VALUES 
('t1', 'e1', 'j1', 1000, '2008-01-01'),
('t1', 'e1', 'j2', 1050, '2008-01-01'),
('t1', 'e1', 'j3', 1000, '2008-01-01'),
('t1', 'e2', 'j4', 1000, '2008-01-01'),
('t1', 'e2', 'j5', 1000, '2008-01-01'),
('t1', 'e2', 'j6', 1000, '2008-01-01'),
('t1', 'e2', 'j7', 1000, '2008-01-01'),
('t1', 'e3', 'j8', 1000, '2008-01-01'),
('t1', 'e3', 'j9', 1000, '2008-01-01'),
('t1', 'e3', 'j1', 1000, '2008-05-07'),
('t1', 'e2', 'j10', 1000, '2008-01-01'),
('t1', 'e2', 'j11', 1000, '2008-01-01'),
('t2', 'e2', 'j3', 1000, '2009-01-01'),
('t2', 'e2', 'j7', 1000, '2009-01-01'),
('t2', 'e1', 'j1', 1000, '2009-01-01'),
('t2', 'e2', 'j5', 1000, '2009-01-01'),
('t2', 'e3', 'j5', 1000, '2009-04-04'),
('t2', 'e4', 'j5', 1000, '2009-06-06'),
('t2', 'e3', 'j1', 1000, '2009-03-03'),
('t2', 'e4', 'j7', 1000, '2009-06-03'),
('t2', 'e2', 'j8', 1000, '2009-01-01'),
('t2', 'e2', 'j9', 1000, '2009-01-01'),
('t2', 'e1', 'j2', 1000, '2009-01-01');

