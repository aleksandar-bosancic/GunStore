use gun_store_database;

delimiter $$
CREATE PROCEDURE `login_procedure` (in username VARCHAR(45), in user_password VARCHAR(45), out is_valid BOOLEAN)
BEGIN
    DECLARE employee_username VARCHAR(45);
    DECLARE employee_password VARCHAR(45);
	DECLARE login_cursor CURSOR FOR SELECT emp.employee_username, emp.employee_password FROM Employee emp WHERE emp.employee_username = username AND emp.employee_password = user_password;
    DECLARE EXIT HANDLER FOR NOT FOUND SET is_valid = FALSE;
	SET is_valid = FALSE;
    OPEN login_cursor;
    FETCH login_cursor INTO employee_username, employee_password;
    SELECT employee_username, employee_password;
    SET is_valid = TRUE;
END$$
delimiter ;

delimiter $$
CREATE PROCEDURE `insert_firearm_rifle` (in rifle_manufacturer VARCHAR(45), in rifle_model VARCHAR(45), in rifle_price DOUBLE, in in_stock INT, in rifle_caliber VARCHAR(45), in rifle_magazine INT)
BEGIN
	START TRANSACTION;
		INSERT INTO Item VALUE (0, rifle_manufacturer, rifle_model, rifle_price, in_stock);
        INSERT INTO Rifle VALUE(Item.last_insert_id(), rifle_caliber, rifle_magazine);
        INSERT INTO Firearm_Rifle VALUE(Rifle.last_insert_id());
    COMMIT WORK;
END$$
delimiter ;

DELIMITER $$
CREATE PROCEDURE `check_firearm_permit` (in person_id INT, out has_permit BOOLEAN)
BEGIN
    DECLARE buyer_permit_id INT;
    DECLARE permit_expiration_date DATE;
    DECLARE EXIT HANDLER FOR NOT FOUND SET has_permit = FALSE;
    SET has_permit = FALSE;
    SELECT firearm_permit_id FROM buyer WHERE buyer.person_id = person_id INTO buyer_permit_id;
    IF buyer_permit_id IS NOT NULL THEN
        SELECT expiration_date FROM firearm_permit WHERE firearm_permit.id = buyer_permit_id INTO permit_expiration_date;
        IF permit_expiration_date > CURDATE() THEN
            SET has_permit = TRUE;
        END IF;
    END IF;
END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE `requires_permit` (in item_id INT, out requires_permit BOOLEAN)
BEGIN
    SET requires_permit = FALSE;
    IF item_id IN (SELECT item_id FROM munition) OR item_id IN (SELECT item_id FROM firearm_rifle) OR item_id IN (SELECT item_id FROM firearm_pistol) THEN
        SET requires_permit = TRUE;
    END IF;
END$$
DELIMITER ;


