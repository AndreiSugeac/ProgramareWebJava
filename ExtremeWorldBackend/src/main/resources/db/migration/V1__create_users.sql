CREATE TABLE users (
    id BIGINT NOT NULL AUTO_INCREMENT,
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    userType VARCHAR(50),

    PRIMARY KEY (id)
);