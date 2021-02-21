INSERT INTO Person VALUES (0, "Vladislav", "Slaninov"),
						  (0, "Rebecca", "L'Orient"),
						  (0, "Shaquille ", "O'Neil"),
                          (0, "John Ronald Reuel", "Tolkein"),
                          (0, "Elon Musk", "Meme Lord"),
                          (0, "Joakim", "Borden");
INSERT INTO Address VALUES (0, "Chikago", "S Lombard Ave", 39),
						   (0, "London", "St James Street", 101),
                           (0, "Paris", "Rue De Varenne", 309),
                           (0, "Moscow", "Brysuov Lane", 1069),
                           (0, "Los Angeles", "Deer Creek", 3500),
                           (0, "Falun", "Sturegatan", 7734);
INSERT INTO Firearm_Permit VALUES (0, "2017-06-15", "2022-06-15"),
								  (0, "1892-03-01", "2292-03-01"),
                                  (0, "2017-03-12", "2020-01-02");
INSERT INTO Employee VALUES (2, 3, "l_rebecca", "magic111"),
							(3, 1, "s_oneil", "magic222"),
                            (6, 6, "sabaton", "sabaton");
INSERT INTO Buyer VALUES (1, 1),
						 (4, 2),
                         (5, 3);
insert into Item VALUES (0, "Remington", "R4", 1299.99, 3),
                        (0, "Remington", "R10", 1500.00, 1),
                        (0, "Remington", "700P", 999.99, 7),
                        (0, "Beretta", "M9A3", 1100.00, 10),
                        (0, "Glock", "19 Gen5", 800.0, 15),
                        (0, "Glock", "17", 660.0, 25),
                        (0, "Sig-Sauer", "P30", 599.0, 25),
                        (0, "Walther", "PPK 380ACP", 799.0, 18),
                        (0, "Taurus", "G3 9mm", 309.0, 20),
                        (0, "UARM", "Ballistic Vest", 790.0, 25),
                        (0, "UARM", "Ballistic Helmet", 169.9, 25),
                        (0, "AS-BL", "Ski Mask", 18.00, 50),
                        (0, "SOG", "Field Knife 1A", 69.0, 10),
                        (0, "Cold Steel", "FGX CAT 92", 22.0, 20),
                        (0, "The Broker", "Snack Pack 03B", 18.0, 25),
                        (0, "SpyderCo", "Tri-Angle Sharpener", 205.0, 15),
                        (0, "Shemag", "Bandana", 20.0, 40),
                        (0, "Boker", "Fire Starter", 24.0, 50);
insert into rifle values (1, "308 Winchester", 4),
                         (2, "7.62 NATO", 20),
                         (3, "5.56 NATO", 30);
insert into firearm_rifle values (1),
                                 (2),
                                 (3);
insert into pistol VALUES (4, "9mm", 17),
                          (5, "10mm", 13),
                          (6, "10mm", 13),
                          (7, "9mm", 17),
                          (8, "380ACP", 6),
                          (9, "9mm", 18);
insert into firearm_pistol VALUES (4),
                                  (5),
                                  (6),
                                  (7),
                                  (8),
                                  (9);
insert into accesories VALUES (10,"black", "Balistic Vest", "Armour"),
                              (11, "black", "Helmet", "Armour"),
                              (12, "black", "Ski Mask", "Headgear"),
                              (13, "silver", "Field Knife", "Knife"),
                              (14, "black", "FGX CAT 92", "Knife"),
                              (15, "black", "Snack-Pack", "Miscellaneous"),
                              (16, "Urban Camo", "Sharpener", "Miscellaneous"),
                              (17, "Desert Camo", "Bandana", "Headgear"),
                              (18, "Black", "Fire Starter", "Miscellaneous");

# select * from address;
# select * from `employee`;
# insert into person value (0, "Elon Musk", "Meme Lord");
# insert into buyer value (7,3);
# delete from address where id = 18;