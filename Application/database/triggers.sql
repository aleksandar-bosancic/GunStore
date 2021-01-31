use gun_store_database;

delimiter $$
CREATE TRIGGER `phone_number_integrity` BEFORE UPDATE ON `Phone_Number` FOR EACH ROW
BEGIN
	IF NOT isnull(new.Person_id) AND NOT isnull(new.Supplier_id) THEN
		SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'You can not insert record';
	ELSEIF isnull(new.Person_id) AND isnull(new.Supplier_id) THEN
		SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'You can not insert record';
	END IF;
END$$
delimiter ;

delimiter $$
CREATE TRIGGER `update_total_price` AFTER INSERT ON `Receipt_has_Item` FOR EACH ROW
BEGIN
	UPDATE Reciept SET Receipt.total_price = Receipt.total_price + (NEW.ammount * NEW.item_price) WHERE Receipt.id = NEW.receipt_id;
END$$
delimiter ;
