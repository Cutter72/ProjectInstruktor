INSERT INTO `instruktor`.`role` (`role`) VALUES
('ROLE_USER');

INSERT INTO `instruktor`.`users` (`id`, `first_name`, `last_name`, `email`, `phone_number`, `description`, `facebook_link`, `video_link`, `enabled`, `username`, `password`) VALUES
('10' ,'Jacek', 'Placek', 'jacek@placek.pl', '700700700', 'Jestem Jacek Placek od wielu lat uczę jak robić placki. Zapraszam do kontaktu', 'https://www.facebook.com/', 'https://www.youtube.com/watch?v=oE8qhT-MDC8&t=343s', '1', 'jacek', SHA1('jacek')),
('11' ,'Arek ', 'Najlepszy', 'arek@najlepszy.com', '600700800', 'Jestem Arek, płacić!', 'https://www.facebook.com/', 'https://www.youtube.com/watch?v=oE8qhT-MDC8&t=343s', '1', 'arek', SHA1('arek')),
('12' ,'Wojtek', 'Łysy', 'wojtus@lysol.pl', '666000666', 'Łysy się narodziłem i nic na to nie poradzę. Chętnie pokażę Ci jak z tym żyć! Zapraszam do kontaktu', 'https://www.facebook.com/', 'https://www.youtube.com/watch?v=oE8qhT-MDC8&t=343s', '1', 'wojtek', SHA1('wojtek')),
('13' ,'Kryspin', 'Rudy', 'kryspin@lubierudych.net', '123321345', 'Jestem rudy, tak to prawda, jeżeli chcesz też być rudy zadzwoń!', 'https://www.facebook.com/', 'https://www.youtube.com/watch?v=oE8qhT-MDC8&t=343s', '1', 'kryspin', SHA1('kryspin'));

INSERT INTO `instruktor`.`users_role` (`users_id`, `role_id`) VALUES
('10', '1'),
('11', '1'),
('12', '1'),
('13', '1');

INSERT INTO `instruktor`.`messages` (`title`, `message_text`, `sender_user_id`, `recipient_user_id`) VALUES
('Jak zostać Rudym?', 'Witam! zawsze chciałem być Rudy. Jak mam to zrobić? Proszę o pilną odpowiedź. Pozdrawiam zdesperowany Jacek', '10', '13'),
('Jak żyć z łysiną?', 'Witam! zawsze chciałem nauczyć się żyć z łysiną. Proszę o pilną odpowiedź. Pozdrawiam lśniący Jacek', '11', '12');

INSERT INTO `instruktor`.`categories` (`name`) VALUES
('Badminton‎'),
('Bilard‎'),
('Sporty ekstremalne‎'),
('Gimnastyka‎'),
('Golf‎'),
('Hokej na lodzie‎‎'),
('Koszykówka‎'),
('Lekkoatletyka‎'),
('Pięciobój nowoczesny‎'),
('Piłka nożna‎'),
('Piłka ręczna‎'),
('Piłka siatkowa‎‎'),
('Podnoszenie ciężarów'),
('Skoki narciarskie‎'),
('Szachy‎'),
('Tenis‎‎'),
('Sporty i sztuki walki'),
('Sporty wodne‎'),
('Łyżwiarstwo figurowe'),
('Żużel‎'),
('Taniec'),
('Rugby'),
('Bieg');

INSERT INTO `instruktor`.`days` (`id`, `name`, `short_name`) VALUES
('1', 'PONIEDZIAŁEK', 'pn'),
('2', 'WTOREK', 'wt'),
('3', 'ŚRODA', 'sr'),
('4', 'CZWARTEK', 'cz'),
('5', 'PIĄTEK', 'pt'),
('6', 'SOBOTA', 'so'),
('7', 'NIEDZIELA', 'nd');

INSERT INTO `instruktor`.`provinces` (`id`, `name`) VALUES
('2', 'DOLNOŚLĄSKIE'),
('4', 'KUJAWSKO-POMORSKIE'),
('6', 'LUBELSKIE'),
('8', 'LUBUSKIE'),
('10', 'ŁÓDZKIE'),
('12', 'MAŁOPOLSKIE'),
('14', 'MAZOWIECKIE'),
('16', 'OPOLSKIE'),
('18', 'PODKARPACKIE'),
('20', 'PODLASKIE'),
('22', 'POMORSKIE'),
('24', 'ŚLĄSKIE'),
('26', 'ŚWIĘTOKRZYSKIE'),
('28', 'WARMIŃSKO-MAZURSKIE'),
('30', 'WIELKOPOLSKIE'),
('32', 'ZACHODNIOPOMORSKIE');

INSERT INTO `instruktor`.`cities` (`name`, `province_id`) VALUES
('Wrocław', '2'),
('Wałbrzych', '2'),
('Legnica', '2'),
('Jelenia Góra', '2'),
('Bydgoszcz', '4'),
('Toruń', '4'),
('Grudziądz', '4'),
('Wrocław', '4'),
('Biała Podlaska', '6'),
('Chełm', '6'),
('Dęblin', '6'),
('Zielona Góra', '8'),
('Łódź', '10'),
('Łowicz', '10'),
('Gorlice', '12'),
('Kraków', '12');

INSERT INTO `instruktor`.`offers` (`title`, `description`, `minutes`, `price`, `category_id`, `user_id`) VALUES
('Nauczę Badmintona Tanio!', 'Uczę Badmintona od lat', '60', '60', '1', '10'),
('Nauczę Bilarda Bardzo Tanio!', 'Uczę Bilarda od lat', '45', '100', '2', '10'),
('Nauczę Cię rozciągania :)', 'Uczę Gimnastyki od lat', '120', '10', '4', '11'),
('Nauczę Koszykówki Tanio!', 'Chcesz poodbijać piłeczkę?', '70', '45', '7', '11'),
('Piłka nożna to nic trudnego!', 'Zostaniesz Cristiano w 5 dni!', '70', '200', '10', '12'),
('Nauczę Szachów szypko', 'Uczę szachów od lat', '320', '199', '15', '12'),
('Nauczę Tenis‎‎a Tanio!', 'Uczę tenisa od lat kilku', '60', '60', '16', '13'),
('Zjedź ten żużel!', 'żużlujemy nie zulujemy!', '60', '70', '20', '13');