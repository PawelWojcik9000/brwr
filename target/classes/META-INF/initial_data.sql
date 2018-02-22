INSERT INTO users(userid, username, password, email, enabled)VALUES (1, 'admin','$2a$10$8kAorRo7vNhWXgvM1TmUjeY5ZtzOw9l9Vj0hqQ1Yek7fyWArZsU/y', 'admin@browarmistrz.com', true);
INSERT INTO users(userid, username, password, email, enabled)VALUES (2, 'user','$2a$10$yuM85.bZl0RM9lDd1GGiAen/7BNkDnSz9ewxmsYPBwfCjqqziimJW', 'user@gmail.com', true);

INSERT INTO user_roles (user_role_id, userid, role)VALUES (1, 1, 'ROLE_ADMIN');
INSERT INTO user_roles (user_role_id, userid, role)VALUES (2, 1, 'ROLE_USER');
INSERT INTO user_roles (user_role_id, userid, role)VALUES (3, 2, 'ROLE_USER');

INSERT INTO beerstyles (ABV, FG, IBU, OG, SRM, styleName)VALUES ('5', '1015', '45', '1065', '400', 'American Wheat');
INSERT INTO beerstyles (ABV, FG, IBU, OG, SRM, styleName)VALUES ('2.8-4.2', '0.998-1.008', '8-12', '1.028-40', '2-3', 'Lite American Lager');
INSERT INTO beerstyles (ABV, FG, IBU, OG, SRM, styleName)VALUES ('4.4-5.2', 'NULL', 'NULL', 'NULL', 'NULL', 'German Pilsner (Pils)');
INSERT INTO beerstyles (ABV, FG, IBU, OG, SRM, styleName)VALUES ('4.5-5.5', 'NULL', 'NULL', 'NULL', 'NULL', 'Vienna Lager');
INSERT INTO beerstyles (ABV, FG, IBU, OG, SRM, styleName)VALUES ('4.5-5.6', 'NULL', 'NULL', 'NULL', 'NULL', 'Munich Dunkel');
INSERT INTO beerstyles (ABV, FG, IBU, OG, SRM, styleName)VALUES ('6.3-7.2', 'NULL', 'NULL', 'NULL', 'NULL', 'Bock');
INSERT INTO beerstyles (ABV, FG, IBU, OG, SRM, styleName)VALUES ('4.4-5.2', 'NULL', 'NULL', 'NULL', 'NULL', 'Koelsch');
INSERT INTO beerstyles (ABV, FG, IBU, OG, SRM, styleName)VALUES ('3.2-3.8', 'NULL', 'NULL', 'NULL', 'NULL', 'Bitter');
INSERT INTO beerstyles (ABV, FG, IBU, OG, SRM, styleName)VALUES ('4.0-6.0', 'NULL', 'NULL', 'NULL', 'NULL', 'Irish Red Ale');
INSERT INTO beerstyles (ABV, FG, IBU, OG, SRM, styleName)VALUES ('4.5-6.0', 'NULL', 'NULL', 'NULL', 'NULL', 'American Pale Ale');
INSERT INTO beerstyles (ABV, FG, IBU, OG, SRM, styleName)VALUES ('5.5-9.5', 'NULL', 'NULL', 'NULL', 'NULL', 'Baltic Porter');
INSERT INTO beerstyles (ABV, FG, IBU, OG, SRM, styleName)VALUES ('4.0-5.0', 'NULL', 'NULL', 'NULL', 'NULL', 'Dry Stout');
INSERT INTO beerstyles (ABV, FG, IBU, OG, SRM, styleName)VALUES ('8.0-12.0', 'NULL', 'NULL', 'NULL', 'NULL', 'Russian Imperial Stout');
INSERT INTO beerstyles (ABV, FG, IBU, OG, SRM, styleName)VALUES ('4.5-5.5', 'NULL', 'NULL', 'NULL', 'NULL', 'Witbier');
INSERT INTO beerstyles (ABV, FG, IBU, OG, SRM, styleName)VALUES ('5.0-7.0', 'NULL', 'NULL', 'NULL', 'NULL', 'Saison');
INSERT INTO beerstyles (ABV, FG, IBU, OG, SRM, styleName)VALUES ('6.0-7.5', 'NULL', 'NULL', 'NULL', 'NULL', 'Belgian Blond Ale');
INSERT INTO beerstyles (ABV, FG, IBU, OG, SRM, styleName)VALUES ('6.0-7.6', 'NULL', 'NULL', 'NULL', 'NULL', 'Belgian Dubbel');
INSERT INTO beerstyles (ABV, FG, IBU, OG, SRM, styleName)VALUES ('7.5-9.5', 'NULL', 'NULL', 'NULL', 'NULL', 'Belgian Tripel');
