insert into community (name)
values ('Любители пенного напитка');

insert into email(email)
values ('123@gmail.com'),
       ('231@yandex.ru');

insert into user (surname, name, email_id, community_id)
values ('Petrov', 'Petr', 1, 1),
       ('Ivanov', 'Ivan', 2, null);

insert into pet (name, what_pet, user_id)
values ('Че', 'Зверь', 1),
       ('Гена', 'Крокодил', 2),
       ('Пятачек', 'Свин', 2);