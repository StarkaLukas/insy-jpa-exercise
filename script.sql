insert into store
(id, city, name) values
(1000, 'Seattle', 'MovieMaster');

insert into person
(person_type, firstname, lastname) values
('Actor', 'Bibi', 'Andersson');

insert into person
(person_type, firstname, lastname) values
('Actor', 'Bengt', 'Ekerot');

insert into person
(person_type, firstname, lastname) values
('Staff', 'Cornelius', 'CoolGuy');

insert into person
(person_type, firstname, lastname) values
('Customer', 'Boris', 'Buyer');

insert into actor
(person_id) values
(1);

insert into actor
(person_id) values
(2);

insert into staff
(hiredate, salary, person_id, store_id) values
('04-20-2020', 1500, 3, 1000);

insert into customer
(dateofbirth, place, street, zip, person_id) values
('01-01-1999', 'Denver', 'Coolstreet', '6969', 4);

insert into movie
(duration, language, rating, title, year) values
(96, '1', 8.2, 'The Seventh Seal', 1957);

insert into category
(name) values
('Fantasy');

insert into category
(name) values
('Drama');

insert into movieactor
(actor_id, movie_id) values
(1, 1);

insert into movieactor
(actor_id, movie_id) values
(2, 1);

insert into moviecategory
(category_id, movie_id) values
(1, 1);

insert into moviecategory
(category_id, movie_id) values
(2, 1);

insert into sale
(payment_date, price, customer_person_id, movie_id, staff_person_id) values
('04-02-2021', 19.99, 4, 1, 3);
