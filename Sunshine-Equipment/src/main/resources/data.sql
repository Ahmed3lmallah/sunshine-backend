--INSERT INTO MANAGER_OFFICE (manager_id, office_id) values(7, 2);
--INSERT INTO MANAGER_OFFICE (manager_id, office_id) values(7, 3);
--INSERT INTO MANAGER_OFFICE (manager_id, office_id) values(8, 1);
--
--INSERT INTO Office (office_name, street_address, city, state, zip, country) values
--('Delivery Center', '5001 Statesman Drive Suite 175 & 200', 'Irving', 'TX', '75063', 'United States');
--INSERT INTO Office (office_name, street_address, city, state, zip, country) values
--('Cognizant Technology Solutions World Headquarters','Glenpointe Centre West 500 Frank W Burr Blvd', 'Teaneck', 'NJ', '07666', 'United States');
--INSERT INTO Office (office_name, street_address, city, state, zip, country) values
--('Office', '200 Somerset Corporate BlvdSuite 8001', 'Bridgewater (New York metro)', 'NJ', '08807', 'United States');

INSERT INTO Equipment (equipment_type, office_id, assigned, user_id) values
('Windows Laptop 1', 1, 'TRUE', 1);

INSERT INTO Equipment (equipment_type, office_id, assigned, comments) values
('Windows Laptop 2', 1, 'FALSE', 'not being used');

INSERT INTO Equipment (equipment_type, office_id, assigned, user_id) values
('Windows Laptop 3', 1, 'TRUE', 2);

INSERT INTO Equipment (equipment_type, office_id, assigned, user_id) values
('Windows Laptop', 2, 'TRUE', 3);

INSERT INTO Equipment (equipment_type, office_id, assigned, comments) values
('Windows Laptop', 2, 'FALSE', 'not being used');

INSERT INTO Equipment (equipment_type, office_id, assigned, user_id) values
('Windows Laptop', 2, 'TRUE', 4);