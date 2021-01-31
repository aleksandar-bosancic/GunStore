use gun_store_database;

delimiter $$
CREATE PROCEDURE `login_procedure` (in username VARCHAR(45), in user_password VARCHAR(45), out is_valid BOOLEAN)
BEGIN
	DECLARE login_cursor CURSOR FOR SELECT * FROM Employee emp WHERE emp.employee_username = username AND emp.employee_password = user_password;
    DECLARE EXIT HANDLER FOR NOT FOUND SET is_valid = FALSE;
    OPEN login_cursor;
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
