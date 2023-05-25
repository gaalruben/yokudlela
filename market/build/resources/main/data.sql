INSERT INTO market_product(id, unit) VALUES
    (200, 0),
    (201, 1),
    (202, 1),
    (203, 1),
    (204, 1),
    (205, 1),
    (206, 1),
    (207, 1),
    (208,1),
    (209, 1);

INSERT INTO consumer(id, contact, name) VALUES
    (100, 'fogyasztoking@market.com', 'Asztalos Béla'),
    (101, 'mviktr@market.com', 'Mohácsi Viktor'),
    (102, 'ezredes@market.com', 'Hoppal Elemér');

INSERT INTO consumer_product(id, consumer_id, product_id) VALUES
    (300, 100, 200),
    (301, 100, 201),
    (302, 100, 202),
    (303, 100, 203),
    (304, 100, 204),
    (305, 100, 205),
    (306, 100, 206),
    (307, 101, 207),
    (308, 101, 208),
    (309, 101, 203),
    (310, 101, 200),
    (311, 101, 201),
    (312, 102, 204),
    (313, 102, 205),
    (314, 102, 206),
    (315, 102, 200);

INSERT INTO consumer_products(consumer_id, products_id) VALUES
    (100, 300),
    (100, 301),
    (100, 302),
    (100, 303),
    (100, 304),
    (100, 305),
    (100, 306),
    (101, 307),
    (101, 308),
    (101, 309),
    (101, 310),
    (101, 311),
    (102, 312),
    (102, 313),
    (102, 314),
    (102, 315);

INSERT INTO supplier(id, contact, name) VALUES
    (400, 'rich@market.com', 'Amadeus Richard'),
    (401, 'gza@market.com', 'Tejes Géza'),
    (402, 'nazgul@market.com', 'Nazgul Adam');

INSERT INTO supplier_product(id,price,quantity, product_id, supplier_id) VALUES
    (500,1559,2560, 200, 400),
    (501, 5201,10, 201, 400),
    (502, 6546,0, 202, 400),
    (503, 471,1234, 203, 400),
    (504,5466,12, 204, 401),
    (505,9999,341, 205, 401),
    (506,1547,56345, 206, 401),
    (507,6324,4365, 207, 401),
    (508, 178746,231,208, 402),
    (509,1455,12, 203, 402),
    (510,11111,0,200, 402),
    (511,3125,1231, 201, 401),
    (512,67457,441, 204, 402),
    (513,1232,123, 205, 402),
    (514,4361,552, 206, 400),
    (515,1311,12312, 200, 401);

INSERT INTO supplier_products(supplier_id, products_id) VALUES
    (400,500),
    (400,501),
    (400,502),
    (400,503),
    (401,504),
    (401,505),
    (401,506),
    (401,507),
    (402,508),
    (402,509),
    (402,510),
    (402,511),
    (402,512),
    (402,513),
    (400,514),
    (401,515);