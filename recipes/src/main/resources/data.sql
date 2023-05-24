INSERT INTO product(id, name, quantity, unit) VALUES
    (200,'tojás', 100, 0),
    (201,'burgonya', 100, 1),
    (202,'répa', 1000, 1),
    (203,'liszt', 100, 1),
    (204,'mogyoró', 50, 1),
    (205,'homár', 50, 1),
    (206,'vaj', 50, 1),
    (207,'fokhagyma', 70, 1),
    (208,'karfiol', 70, 1),
    (209,'hummus', 70, 1);

INSERT INTO ingredient(id, quantity, product_id) VALUES
    (100, 1, 200),
    (101,2, 200),
    (102,2, 201),
    (103,2000, 202),
    (104,1000, 204),
    (105,1, 209),
    (106,1, 208),
    (107,1, 203),
    (108,1, 205),
    (109,1, 206),
    (110,1, 207);


INSERT INTO menu_group(id, name) VALUES
    (300, 'vegán'),
    (301, 'olasz'),
    (302,'ünnepi'),
    (303,'magyaros'),
    (304,'fine dining');

INSERT INTO menu(id, day_available, name, group_id) VALUES
    (400,0, 'Olasz étlap', 301),
    (401,0, 'Magyaros étlap', 303),
    (402,1, 'Karácsonyi étlap', 302),
    (403,1, 'Fine dining étlap', 304),
    (404,0, 'Vegán étlap', 300);

INSERT INTO recipe(id, name) VALUES
    (600,'tojásos nokedli'),
    (601,'fokhagymás vajban sült homár'),
    (602,'karfiol hummussal');


INSERT INTO menu_item(id, name, price, times_ordered, menu_id, recipe_id) VALUES
    (500,'Magyar üstökös', 1200, 105, 401, 600),
    (501,'Posseidon ökle', 6300, 26, 403, 601),
    (502,'Hummusapiens', 2500, 35, 404, 602);

INSERT INTO recipe_ingredients(recipe_id, ingredients_id) VALUES
    (600,100),
    (600,107),
    (601,108),
    (601,109),
    (601,110),
    (602,105),
    (602,106);

