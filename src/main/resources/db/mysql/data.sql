INSERT IGNORE INTO vets VALUES (1, 'James', 'Carter');
INSERT IGNORE INTO vets VALUES (2, 'Helen', 'Leary');
INSERT IGNORE INTO vets VALUES (3, 'Linda', 'Douglas');
INSERT IGNORE INTO vets VALUES (4, 'Rafael', 'Ortega');
INSERT IGNORE INTO vets VALUES (5, 'Henry', 'Stevens');
INSERT IGNORE INTO vets VALUES (6, 'Sharon', 'Jenkins');

INSERT IGNORE INTO specialties VALUES (1, 'radiology');
INSERT IGNORE INTO specialties VALUES (2, 'surgery');
INSERT IGNORE INTO specialties VALUES (3, 'dentistry');

INSERT IGNORE INTO vet_specialties VALUES (2, 1);
INSERT IGNORE INTO vet_specialties VALUES (3, 2);
INSERT IGNORE INTO vet_specialties VALUES (3, 3);
INSERT IGNORE INTO vet_specialties VALUES (4, 2);
INSERT IGNORE INTO vet_specialties VALUES (5, 1);

INSERT IGNORE INTO types VALUES (1, 'cat');
INSERT IGNORE INTO types VALUES (2, 'dog');
INSERT IGNORE INTO types VALUES (3, 'lizard');
INSERT IGNORE INTO types VALUES (4, 'snake');
INSERT IGNORE INTO types VALUES (5, 'bird');
INSERT IGNORE INTO types VALUES (6, 'hamster');

INSERT IGNORE INTO owners VALUES (1, 'George', 'Franklin', '110 W. Liberty St.', 'Madison', '6085551023');
INSERT IGNORE INTO owners VALUES (2, 'Betty', 'Davis', '638 Cardinal Ave.', 'Sun Prairie', '6085551749');
INSERT IGNORE INTO owners VALUES (3, 'Eduardo', 'Rodriquez', '2693 Commerce St.', 'McFarland', '6085558763');
INSERT IGNORE INTO owners VALUES (4, 'Harold', 'Davis', '563 Friendly St.', 'Windsor', '6085553198');
INSERT IGNORE INTO owners VALUES (5, 'Peter', 'McTavish', '2387 S. Fair Way', 'Madison', '6085552765');
INSERT IGNORE INTO owners VALUES (6, 'Jean', 'Coleman', '105 N. Lake St.', 'Monona', '6085552654');
INSERT IGNORE INTO owners VALUES (7, 'Jeff', 'Black', '1450 Oak Blvd.', 'Monona', '6085555387');
INSERT IGNORE INTO owners VALUES (8, 'Maria', 'Escobito', '345 Maple St.', 'Madison', '6085557683');
INSERT IGNORE INTO owners VALUES (9, 'David', 'Schroeder', '2749 Blackhawk Trail', 'Madison', '6085559435');
INSERT IGNORE INTO owners VALUES (10, 'Carlos', 'Estaban', '2335 Independence La.', 'Waunakee', '6085555487');

INSERT IGNORE INTO pets VALUES (1, 'Leo', '2000-09-07', 1, 1, 'blue');
INSERT IGNORE INTO pets VALUES (2, 'Basil', '2002-08-06', 6, 2, 'green');
INSERT IGNORE INTO pets VALUES (3, 'Rosy', '2001-04-17', 2, 3, 'brown');
INSERT IGNORE INTO pets VALUES (4, 'Jewel', '2000-03-07', 2, 3, 'hazel');
INSERT IGNORE INTO pets VALUES (5, 'Iggy', '2000-11-30', 3, 4, 'amber');
INSERT IGNORE INTO pets VALUES (6, 'George', '2000-01-20', 4, 5, 'gray');
INSERT IGNORE INTO pets VALUES (7, 'Samantha', '1995-09-04', 1, 6, 'blue');
INSERT IGNORE INTO pets VALUES (8, 'Max', '1995-09-04', 1, 6, 'green');
INSERT IGNORE INTO pets VALUES (9, 'Lucky', '1999-08-06', 5, 7, 'brown');
INSERT IGNORE INTO pets VALUES (10, 'Mulligan', '1997-02-24', 2, 8, 'hazel');
INSERT IGNORE INTO pets VALUES (11, 'Freddy', '2000-03-09', 5, 9, 'amber');
INSERT IGNORE INTO pets VALUES (12, 'Lucky', '2000-06-24', 2, 10, 'gray');
INSERT IGNORE INTO pets VALUES (13, 'Sly', '2002-06-08', 1, 10, 'blue');

INSERT IGNORE INTO visits VALUES (1, 7, '2010-03-04', 'rabies shot');
INSERT IGNORE INTO visits VALUES (2, 8, '2011-03-04', 'rabies shot');
INSERT IGNORE INTO visits VALUES (3, 8, '2009-06-04', 'neutered');
INSERT IGNORE INTO visits VALUES (4, 7, '2008-09-04', 'spayed');

INSERT IGNORE INTO fueltypes VALUES (1, 'diesel');
INSERT IGNORE INTO fueltypes VALUES (2, 'petrol');
INSERT IGNORE INTO fueltypes VALUES (3, 'electric');
INSERT IGNORE INTO fueltypes VALUES (4, 'hydrogen');
INSERT IGNORE INTO fueltypes VALUES (5, 'hybrid');
INSERT IGNORE INTO fueltypes VALUES (6, 'nuclear');

INSERT IGNORE INTO vehicles VALUES (1, 1, 'ABC123', 5, 'Red', 'Toyota', 'Corolla', 1);
INSERT IGNORE INTO vehicles VALUES (2, 4, 'VWX789', 2, 'Pink', 'Porsche', '911', 1);
INSERT IGNORE INTO vehicles VALUES (3, 2, 'XYZ789', 7, 'Blue', 'Honda', 'Odyssey', 2);
INSERT IGNORE INTO vehicles VALUES (4, 3, 'LMN456', 4, 'Black', 'Ford', 'Mustang', 3);
INSERT IGNORE INTO vehicles VALUES (5, 4, 'DEF321', 2, 'White', 'Tesla', 'Model S', 4);
INSERT IGNORE INTO vehicles VALUES (6, 5, 'GHI654', 5, 'Silver', 'BMW', 'X5', 5);
INSERT IGNORE INTO vehicles VALUES (7, 3, 'JKL987', 5, 'Green', 'Chevrolet', 'Volt', 6);
INSERT IGNORE INTO vehicles VALUES (8, 1, 'MNO654', 4, 'Yellow', 'Volkswagen', 'Beetle', 7);
INSERT IGNORE INTO vehicles VALUES (9, 2, 'PQR321', 6, 'Purple', 'Kia', 'Sorento', 8);
INSERT IGNORE INTO vehicles VALUES (10, 3, 'STU123', 5, 'Orange', 'Audi', 'Q7', 9);
