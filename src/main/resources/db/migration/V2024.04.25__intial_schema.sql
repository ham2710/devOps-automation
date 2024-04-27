CREATE TABLE PERSON
(
    id            SERIAL PRIMARY KEY ,
    first_name    VARCHAR(255),
    last_name     VARCHAR(255),
    email         VARCHAR(255),
    age           INT,
    inserted_date TIMESTAMP NOT NULL DEFAULT current_timestamp,
    updated_date  TIMESTAMP NOT NULL DEFAULT current_timestamp
);

-- if we include band id here then it means a musician belongs to only one band and that is not the case.
CREATE TABLE MUSICIAN
(
    id             SERIAL PRIMARY KEY,
    person_id      BIGINT,
    insertion_date TIMESTAMP NOT NULL DEFAULT current_timestamp,
    updated_date   TIMESTAMP NOT NULL DEFAULT current_timestamp,
    CONSTRAINT fk_person
    	FOREIGN KEY(person_id) 
    		REFERENCES PERSON(id)
    		ON DELETE CASCADE
);

CREATE TABLE BAND
(
    id           SERIAL PRIMARY KEY ,
    band_name    VARCHAR(255),
    formed_date  TIMESTAMP NOT NULL DEFAULT current_timestamp,
    updated_date TIMESTAMP NOT NULL DEFAULT current_timestamp
);

-- This is required to model many to many relationship between band and musician
CREATE TABLE BAND_MUSICIAN
(
    band_id     BIGINT,
    musician_id BIGINT,
    join_date   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (band_id, musician_id),
    CONSTRAINT fk_band
    FOREIGN KEY (band_id) REFERENCES BAND (id),
    CONSTRAINT fk_musician
    FOREIGN KEY (musician_id) REFERENCES MUSICIAN (id)
);