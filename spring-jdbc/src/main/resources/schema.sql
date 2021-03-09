drop table if exists users, email, pet;

CREATE TABLE users (
    id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    surname VARCHAR(256),
    name VARCHAR(256),
    email_id BIGINT,
    pet_id BIGINT
);

CREATE TABLE email (
    id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    email VARCHAR(256)
);

CREATE TABLE pet (
    id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    what_pet VARCHAR(256),
    name VARCHAR(256)
);

ALTER TABLE users ADD FOREIGN KEY (email_id) REFERENCES email(id);
ALTER TABLE users ADD FOREIGN KEY (pet_id) REFERENCES pet(id);