INSERT INTO vets (first_name, last_name) SELECT 'James', 'Carter' WHERE NOT EXISTS (SELECT * FROM vets WHERE id=1);
INSERT INTO vets (first_name, last_name) SELECT 'Helen', 'Leary' WHERE NOT EXISTS (SELECT * FROM vets WHERE id=2);
INSERT INTO vets (first_name, last_name) SELECT 'Linda', 'Douglas' WHERE NOT EXISTS (SELECT * FROM vets WHERE id=3);
INSERT INTO vets (first_name, last_name) SELECT 'Rafael', 'Ortega' WHERE NOT EXISTS (SELECT * FROM vets WHERE id=4);
INSERT INTO vets (first_name, last_name) SELECT 'Henry', 'Stevens' WHERE NOT EXISTS (SELECT * FROM vets WHERE id=5);
INSERT INTO vets (first_name, last_name) SELECT 'Sharon', 'Jenkins' WHERE NOT EXISTS (SELECT * FROM vets WHERE id=6);

INSERT INTO specialties (name) SELECT 'radiology' WHERE NOT EXISTS (SELECT * FROM specialties WHERE name='radiology');
INSERT INTO specialties (name) SELECT 'surgery' WHERE NOT EXISTS (SELECT * FROM specialties WHERE name='surgery'); 
INSERT INTO specialties (name) SELECT 'dentistry' WHERE NOT EXISTS (SELECT * FROM specialties WHERE name='dentistry');

INSERT INTO vet_specialties VALUES (2, 1) ON CONFLICT (vet_id, specialty_id) DO NOTHING;
INSERT INTO vet_specialties VALUES (3, 2) ON CONFLICT (vet_id, specialty_id) DO NOTHING;
INSERT INTO vet_specialties VALUES (3, 3) ON CONFLICT (vet_id, specialty_id) DO NOTHING;
INSERT INTO vet_specialties VALUES (4, 2) ON CONFLICT (vet_id, specialty_id) DO NOTHING;
INSERT INTO vet_specialties VALUES (5, 1) ON CONFLICT (vet_id, specialty_id) DO NOTHING;

INSERT INTO types (name) SELECT 'cat' WHERE NOT EXISTS (SELECT * FROM types WHERE name='cat');
INSERT INTO types (name) SELECT 'dog' WHERE NOT EXISTS (SELECT * FROM types WHERE name='dog');
INSERT INTO types (name) SELECT 'lizard' WHERE NOT EXISTS (SELECT * FROM types WHERE name='lizard');
INSERT INTO types (name) SELECT 'snake' WHERE NOT EXISTS (SELECT * FROM types WHERE name='snake');
INSERT INTO types (name) SELECT 'bird' WHERE NOT EXISTS (SELECT * FROM types WHERE name='bird');
INSERT INTO types (name) SELECT 'hamster' WHERE NOT EXISTS (SELECT * FROM types WHERE name='hamster');

INSERT INTO owners (first_name, last_name, address, city, telephone) SELECT 'George', 'Franklin', '110 W. Liberty St.', 'Madison', '6085551023' WHERE NOT EXISTS (SELECT * FROM owners WHERE id=1);
INSERT INTO owners (first_name, last_name, address, city, telephone) SELECT 'Betty', 'Davis', '638 Cardinal Ave.', 'Sun Prairie', '6085551749' WHERE NOT EXISTS (SELECT * FROM owners WHERE id=2);
INSERT INTO owners (first_name, last_name, address, city, telephone) SELECT 'Eduardo', 'Rodriquez', '2693 Commerce St.', 'McFarland', '6085558763' WHERE NOT EXISTS (SELECT * FROM owners WHERE id=3);
INSERT INTO owners (first_name, last_name, address, city, telephone) SELECT 'Harold', 'Davis', '563 Friendly St.', 'Windsor', '6085553198' WHERE NOT EXISTS (SELECT * FROM owners WHERE id=4);
INSERT INTO owners (first_name, last_name, address, city, telephone) SELECT 'Peter', 'McTavish', '2387 S. Fair Way', 'Madison', '6085552765' WHERE NOT EXISTS (SELECT * FROM owners WHERE id=5);
INSERT INTO owners (first_name, last_name, address, city, telephone) SELECT 'Jean', 'Coleman', '105 N. Lake St.', 'Monona', '6085552654' WHERE NOT EXISTS (SELECT * FROM owners WHERE id=6);
INSERT INTO owners (first_name, last_name, address, city, telephone) SELECT 'Jeff', 'Black', '1450 Oak Blvd.', 'Monona', '6085555387' WHERE NOT EXISTS (SELECT * FROM owners WHERE id=7);
INSERT INTO owners (first_name, last_name, address, city, telephone) SELECT 'Maria', 'Escobito', '345 Maple St.', 'Madison', '6085557683' WHERE NOT EXISTS (SELECT * FROM owners WHERE id=8);
INSERT INTO owners (first_name, last_name, address, city, telephone) SELECT 'David', 'Schroeder', '2749 Blackhawk Trail', 'Madison', '6085559435' WHERE NOT EXISTS (SELECT * FROM owners WHERE id=9);
INSERT INTO owners (first_name, last_name, address, city, telephone) SELECT 'Carlos', 'Estaban', '2335 Independence La.', 'Waunakee', '6085555487' WHERE NOT EXISTS (SELECT * FROM owners WHERE id=10);

INSERT INTO pets (name, birth_date, type_id, owner_id, eye_color) SELECT 'Leo', '2000-09-07', 1, 1, 'blue' WHERE NOT EXISTS (SELECT * FROM pets WHERE id=1);
INSERT INTO pets (name, birth_date, type_id, owner_id, eye_color) SELECT 'Basil', '2002-08-06', 6, 2, 'green' WHERE NOT EXISTS (SELECT * FROM pets WHERE id=2);
INSERT INTO pets (name, birth_date, type_id, owner_id, eye_color) SELECT 'Rosy', '2001-04-17', 2, 3, 'brown' WHERE NOT EXISTS (SELECT * FROM pets WHERE id=3);
INSERT INTO pets (name, birth_date, type_id, owner_id, eye_color) SELECT 'Jewel', '2000-03-07', 2, 3, 'hazel' WHERE NOT EXISTS (SELECT * FROM pets WHERE id=4);
INSERT INTO pets (name, birth_date, type_id, owner_id, eye_color) SELECT 'Iggy', '2000-11-30', 3, 4, 'amber' WHERE NOT EXISTS (SELECT * FROM pets WHERE id=5);
INSERT INTO pets (name, birth_date, type_id, owner_id, eye_color) SELECT 'George', '2000-01-20', 4, 5, 'gray' WHERE NOT EXISTS (SELECT * FROM pets WHERE id=6);
INSERT INTO pets (name, birth_date, type_id, owner_id, eye_color) SELECT 'Samantha', '1995-09-04', 1, 6, 'blue' WHERE NOT EXISTS (SELECT * FROM pets WHERE id=7);
INSERT INTO pets (name, birth_date, type_id, owner_id, eye_color) SELECT 'Max', '1995-09-04', 1, 6, 'green' WHERE NOT EXISTS (SELECT * FROM pets WHERE id=8);
INSERT INTO pets (name, birth_date, type_id, owner_id, eye_color) SELECT 'Lucky', '1999-08-06', 5, 7, 'brown' WHERE NOT EXISTS (SELECT * FROM pets WHERE id=9);
INSERT INTO pets (name, birth_date, type_id, owner_id, eye_color) SELECT 'Mulligan', '1997-02-24', 2, 8, 'hazel' WHERE NOT EXISTS (SELECT * FROM pets WHERE id=10);
INSERT INTO pets (name, birth_date, type_id, owner_id, eye_color) SELECT 'Freddy', '2000-03-09', 5, 9, 'amber' WHERE NOT EXISTS (SELECT * FROM pets WHERE id=11);
INSERT INTO pets (name, birth_date, type_id, owner_id, eye_color) SELECT 'Lucky', '2000-06-24', 2, 10, 'gray' WHERE NOT EXISTS (SELECT * FROM pets WHERE id=12);
INSERT INTO pets (name, birth_date, type_id, owner_id, eye_color) SELECT 'Sly', '2002-06-08', 1, 10, 'blue' WHERE NOT EXISTS (SELECT * FROM pets WHERE id=13);


INSERT INTO visits (pet_id, visit_date, description) SELECT 7, '2010-03-04', 'rabies shot' WHERE NOT EXISTS (SELECT * FROM visits WHERE id=1);
INSERT INTO visits (pet_id, visit_date, description) SELECT 8, '2011-03-04', 'rabies shot' WHERE NOT EXISTS (SELECT * FROM visits WHERE id=2);
INSERT INTO visits (pet_id, visit_date, description) SELECT 8, '2009-06-04', 'neutered' WHERE NOT EXISTS (SELECT * FROM visits WHERE id=3);
INSERT INTO visits (pet_id, visit_date, description) SELECT 7, '2008-09-04', 'spayed' WHERE NOT EXISTS (SELECT * FROM visits WHERE id=4);

INSERT INTO fueltypes (id, name) VALUES (DEFAULT, 'diesel');
INSERT INTO fueltypes (id, name) VALUES (DEFAULT, 'petrol');
INSERT INTO fueltypes (id, name) VALUES (DEFAULT, 'electric');
INSERT INTO fueltypes (id, name) VALUES (DEFAULT, 'hydrogen');
INSERT INTO fueltypes (id, name) VALUES (DEFAULT, 'hybrid');
INSERT INTO fueltypes (id, name) VALUES (DEFAULT, 'nuclear');

INSERT INTO vehicles (id, fuel_type_id, license_plate, seats, color, brand, model, owner_id) VALUES (DEFAULT, 1, 'ABC123', 5, 'Red', 'Toyota', 'Corolla', 1);
INSERT INTO vehicles (id, fuel_type_id, license_plate, seats, color, brand, model, owner_id) VALUES (DEFAULT, 4, 'VWX789', 2, 'Pink', 'Porsche', '911', 1);
INSERT INTO vehicles (id, fuel_type_id, license_plate, seats, color, brand, model, owner_id) VALUES (DEFAULT, 2, 'XYZ789', 7, 'Blue', 'Honda', 'Odyssey', 2);
INSERT INTO vehicles (id, fuel_type_id, license_plate, seats, color, brand, model, owner_id) VALUES (DEFAULT, 3, 'LMN456', 4, 'Black', 'Ford', 'Mustang', 3);
INSERT INTO vehicles (id, fuel_type_id, license_plate, seats, color, brand, model, owner_id) VALUES (DEFAULT, 4, 'DEF321', 2, 'White', 'Tesla', 'Model S', 4);
INSERT INTO vehicles (id, fuel_type_id, license_plate, seats, color, brand, model, owner_id) VALUES (DEFAULT, 5, 'GHI654', 5, 'Silver', 'BMW', 'X5', 5);
INSERT INTO vehicles (id, fuel_type_id, license_plate, seats, color, brand, model, owner_id) VALUES (DEFAULT, 3, 'JKL987', 5, 'Green', 'Chevrolet', 'Volt', 6);
INSERT INTO vehicles (id, fuel_type_id, license_plate, seats, color, brand, model, owner_id) VALUES (DEFAULT, 1, 'MNO654', 4, 'Yellow', 'Volkswagen', 'Beetle', 7);
INSERT INTO vehicles (id, fuel_type_id, license_plate, seats, color, brand, model, owner_id) VALUES (DEFAULT, 2, 'PQR321', 6, 'Purple', 'Kia', 'Sorento', 8);
INSERT INTO vehicles (id, fuel_type_id, license_plate, seats, color, brand, model, owner_id) VALUES (DEFAULT, 3, 'STU123', 5, 'Orange', 'Audi', 'Q7', 9);