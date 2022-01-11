CREATE TABLE locations (
    id BIGINT NOT NULL AUTO_INCREMENT,
    country VARCHAR(50) NOT NULL,
    city VARCHAR(50) NOT NULL,
    postal_code VARCHAR(50) NOT NULL,

    PRIMARY KEY (id)
);

CREATE TABLE resorts (
    id BIGINT NOT NULL AUTO_INCREMENT,
    resort_name VARCHAR(50) NOT NULL,
    location_id BIGINT NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (location_id) REFERENCES locations(id)
);