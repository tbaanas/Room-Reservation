INSERT INTO hotel (area, name, price, text) VALUES
                                                    (12.4, 'hotel1', 10.1, 'Opis hotelu 1'),
                                                    (20.6, 'hotel2', 800.2, 'Opis hotelu 2'),
                                                    (32.3, 'hotel3', 43, 'Opis hotelu 3'),
                                                    (42.9, 'hotel4', 13.4, 'Opis hotelu 4'),
                                                    (52.3, 'hotel5', 60, 'Opis hotelu 5'),
                                                    (62.7, 'hotel6', 321.7, 'Opis hotelu 6'),
                                                    (72.44, 'hotel7', 154, 'Opis hotelu 7'),
                                                    (82.46, 'hotel8', 198, 'Opis hotelu 8'),
                                                    (92.42, 'hotel9', 39, 'Opis hotelu 9'),
                                                    ( 31.87, 'hotel10', 54.5, 'Opis hotelu 10');




INSERT INTO landlord (name) VALUES
                         ('Wynajmujący1'),
                         ('Wynajmujący2'),
                         ('Wynajmujący3'),
                         ('Wynajmujący4'),
                         ('Wynajmujący5');




INSERT INTO tenant (name) VALUES
                       ('Lokator1'),
                       ('Lokator2'),
                       ('Lokator3'),
                       ('Lokator4'),
                       ('Lokator5');





INSERT INTO reservation (date_end, date_start, days, reservation_price, hotel_id, landlord_id, tenant_id) VALUES
                            ('2022-08-02', '2022-08-01', 1, 10.1, 1, 1, 1),
                            ('2022-07-06', '2022-07-01', 5, 321.7, 6, 3, 2),
                            ('2022-07-19', '2022-07-10', 9, 13.4, 4, 2, 3),
                            ('2022-07-12', '2022-07-05', 7, 60, 5, 5, 4),
                            ('2022-08-30', '2022-07-21', 9, 198, 8, 4, 5),
                            ('2022-08-06', '2022-08-04', 2, 20.2, 1, 1, 1),
                            ('2022-08-10', '2022-08-07', 3, 30.3, 1, 1, 1);

