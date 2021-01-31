use gun_store_database;

CREATE VIEW `Employee_Details` AS SELECT Person.id, Person.first_name, Person.last_name, Phone_Number.phone_number, 
concat_ws(", ", Address.city, Address.street, Address.number) AS address, Employee.employee_username, Employee.employee_password  
FROM Person
INNER JOIN Employee ON Person.id = Employee.person_id 
INNER JOIN Address  ON Employee.address_id = Address.id
INNER JOIN Phone_Number ON Phone_Number.person_id = Employee.person_id;

CREATE VIEW `Items_in_stock` AS SELECT * FROM Item WHERE NOT Item.in_stock = 0;

CREATE VIEW `Rifles_in_stock` AS SELECT * FROM Items_in_stock INNER JOIN Rifle ON Items_in_stock.id = Rifle.item_id;