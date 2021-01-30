use mydb;

delimiter $$
create procedure procedura(in nalog varchar(45),in sifra varchar(45), out valid boolean)
begin 
    declare variabla varchar(20) default 5;
    declare cursor1 cursor for select * from korisnik;
    
    
    
end$$
delimiter ;