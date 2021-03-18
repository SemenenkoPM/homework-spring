drop table if exists users, email, pet;

CREATE TABLE users (
    id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    surname VARCHAR(256),
    name VARCHAR(256)
);

CREATE TABLE email (
    id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    email VARCHAR(256),
    users_id BIGINT
);

CREATE TABLE pet (
    id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    what_pet VARCHAR(256),
    name VARCHAR(256),
    users_id BIGINT
);

ALTER TABLE email
    ADD FOREIGN KEY (users_id) REFERENCES users (id) on delete cascade;
ALTER TABLE pet
    ADD FOREIGN KEY (users_id) REFERENCES users (id) on delete cascade;