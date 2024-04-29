INSERT INTO products(product_name,product_Descripcion,product_price,product_stock,keywords,product_caracteristc)values('Bufanda','Color amarillo',20000,1,'','Elaborada a mano');
INSERT INTO products(product_name,product_Descripcion,product_price,product_stock,keywords,product_caracteristc)values('Aretes','Color morado',15000,1,'','Elaborada a mano');
INSERT INTO products(product_name,product_Descripcion,product_price,product_stock,keywords,product_caracteristc)values('Camisa','Color blanca',50000,1,'','Elaborada a mano');
INSERT INTO products(product_name,product_Descripcion,product_price,product_stock,keywords,product_caracteristc)values('Chaqueta','Color cafe',55000,1,'','Elaborada a mano');
INSERT INTO products(product_name,product_Descripcion,product_price,product_stock,keywords,product_caracteristc)values('Manillas','Multicolores',15000,1,'','Elaborada a mano');

INSERT INTO Categories(category_name)values('Accessorios');
INSERT INTO Categories(category_name)values('Camisas');
INSERT INTO Categories(category_name)values('Vestidos');
INSERT INTO Categories(category_name)values('Ropa de invierno');

INSERT INTO productCategory(product_id,category_id)values(1,1);