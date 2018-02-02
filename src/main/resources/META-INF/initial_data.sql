INSERT INTO users(userid, username, password, email, enabled)VALUES (1, 'admin','root123', 'admin@browarmistrz.com', true);

INSERT INTO user_roles (user_role_id, userid, role)VALUES (1, 1, 'ROLE_ADMIN');
INSERT INTO user_roles (user_role_id, userid, role)VALUES (2, 1, 'ROLE_USER');

INSERT INTO beerstyles (ABV, FG, IBU, OG, SRM, styleName)VALUES ('5', '1015', '45', '1065', '400', 'American Wheat');
