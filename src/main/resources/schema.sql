CREATE TABLE hotel (
                       id INTEGER  NOT NULL AUTO_INCREMENT,
                       area DOUBLE DEFAULT NULL,
                       name VARCHAR DEFAULT NULL,
                       price DOUBLE DEFAULT NULL,
                       text VARCHAR  DEFAULT NULL,
                       PRIMARY KEY (id)
);


CREATE TABLE landlord (
                          id INTEGER NOT NULL AUTO_INCREMENT,
                          name VARCHAR DEFAULT NULL,
                              PRIMARY KEY (id)
);

CREATE TABLE tenant (
                        id INTEGER NOT NULL AUTO_INCREMENT,
                        name VARCHAR DEFAULT NULL,
                            PRIMARY KEY (id)
);


CREATE TABLE reservation (
                             id INTEGER NOT NULL AUTO_INCREMENT ,
                             date_end DATE DEFAULT NULL,
                             date_start DATE DEFAULT NULL,
                             days int NOT NULL,
                             reservation_price DOUBLE DEFAULT NULL,
                             hotel_id INTEGER DEFAULT NULL,
                             landlord_id INTEGER DEFAULT NULL,
                             tenant_id INTEGER DEFAULT NULL,
                                 PRIMARY KEY (id)
);


ALTER TABLE reservation ADD FOREIGN KEY (landlord_id) REFERENCES landlord (id);
ALTER TABLE reservation ADD  FOREIGN KEY (hotel_id) REFERENCES hotel (id);
ALTER TABLE reservation ADD  FOREIGN KEY (tenant_id) REFERENCES tenant (id);
