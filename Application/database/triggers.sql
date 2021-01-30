use mydb;
delimiter $$
CREATE DEFINER = CURRENT_USER TRIGGER `mydb`.`Phone_Number_BEFORE_UPDATE` BEFORE UPDATE ON `Phone_Number` FOR EACH ROW
BEGIN
	if not isnull(new.Person_id) and not isnull(new.Supplier_id) then
		SIGNAL SQLSTATE '45000';
        SET MESSAGE_TEXT = 'You can not insert record';
	else if isnull(new.Person_id) and isnull(new.Supplier_id) then
		SIGNAL SQLSTATE '45000';
        SET MESSAGE_TEXT = 'You can not insert record';
	end if;
END
delimiter ;

delimiter $$
create procedure procedura(in nalog varchar(45),in sifra varchar(45), out valid boolean)
begin 
    declare variabla varchar(20) default 5;
    declare cursor1 cursor for select * from korisnik;
    
    
    
end$$
delimiter ;