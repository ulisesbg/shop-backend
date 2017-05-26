/*
Base de datos: shop
Esquema: public
Objetos: TABLE
*/
CREATE TABLE "public"."customer"  ( 
	"id"         	integer NOT NULL,
	"address"    	varchar(255) NULL,
	"name"       	varchar(255) NULL,
	"update_date"	timestamp NULL,
	PRIMARY KEY("id")
);
CREATE TABLE "public"."order"  ( 
	"id"         	integer NOT NULL,
	"name"       	varchar(255) NULL,
	"update_date"	timestamp NULL,
	"customer"   	integer NOT NULL,
	"product"    	integer NOT NULL,
	PRIMARY KEY("id")
);
CREATE TABLE "public"."product"  ( 
	"id"          	integer NOT NULL,
	"name"        	varchar NULL,
	"price"       	numeric NULL,
	"update_date" 	timestamp NULL,
	"product_type"	integer NOT NULL,
	PRIMARY KEY("id")
);
CREATE TABLE "public"."product_type"  ( 
	"id"         	integer NOT NULL,
	"name"       	varchar(255) NULL,
	"update_date"	timestamp NULL,
	PRIMARY KEY("id")
);


ALTER TABLE "public"."order"
	ADD CONSTRAINT "product_fkey"
	FOREIGN KEY("product")
	REFERENCES "public"."product"("id")
	ON DELETE NO ACTION 
	ON UPDATE NO ACTION ;
ALTER TABLE "public"."order"
	ADD CONSTRAINT "customer_fkey"
	FOREIGN KEY("customer")
	REFERENCES "public"."customer"("id")
	ON DELETE NO ACTION 
	ON UPDATE NO ACTION ;
ALTER TABLE "public"."product"
	ADD CONSTRAINT "productType_fkey"
	FOREIGN KEY("product_type")
	REFERENCES "public"."product_type"("id")
	ON DELETE NO ACTION 
	ON UPDATE NO ACTION ;
GRANT SELECT("update_date"), INSERT("update_date"), UPDATE("update_date"), REFERENCES("update_date") ON "public"."customer" TO "postgres" WITH GRANT OPTION;
GRANT SELECT("name"), INSERT("name"), UPDATE("name"), REFERENCES("name") ON "public"."customer" TO "postgres" WITH GRANT OPTION;
GRANT SELECT("id"), INSERT("id"), UPDATE("id"), REFERENCES("id") ON "public"."customer" TO "postgres" WITH GRANT OPTION;
GRANT SELECT("address"), INSERT("address"), UPDATE("address"), REFERENCES("address") ON "public"."customer" TO "postgres" WITH GRANT OPTION;
GRANT SELECT("update_date"), INSERT("update_date"), UPDATE("update_date"), REFERENCES("update_date") ON "public"."order" TO "postgres" WITH GRANT OPTION;
GRANT SELECT("product"), INSERT("product"), UPDATE("product"), REFERENCES("product") ON "public"."order" TO "postgres" WITH GRANT OPTION;
GRANT SELECT("name"), INSERT("name"), UPDATE("name"), REFERENCES("name") ON "public"."order" TO "postgres" WITH GRANT OPTION;
GRANT SELECT("id"), INSERT("id"), UPDATE("id"), REFERENCES("id") ON "public"."order" TO "postgres" WITH GRANT OPTION;
GRANT SELECT("customer"), INSERT("customer"), UPDATE("customer"), REFERENCES("customer") ON "public"."order" TO "postgres" WITH GRANT OPTION;
GRANT SELECT("update_date"), INSERT("update_date"), UPDATE("update_date"), REFERENCES("update_date") ON "public"."product" TO "postgres" WITH GRANT OPTION;
GRANT SELECT("product_type"), INSERT("product_type"), UPDATE("product_type"), REFERENCES("product_type") ON "public"."product" TO "postgres" WITH GRANT OPTION;
GRANT SELECT("price"), INSERT("price"), UPDATE("price"), REFERENCES("price") ON "public"."product" TO "postgres" WITH GRANT OPTION;
GRANT SELECT("name"), INSERT("name"), UPDATE("name"), REFERENCES("name") ON "public"."product" TO "postgres" WITH GRANT OPTION;
GRANT SELECT("id"), INSERT("id"), UPDATE("id"), REFERENCES("id") ON "public"."product" TO "postgres" WITH GRANT OPTION;
GRANT SELECT("update_date"), INSERT("update_date"), UPDATE("update_date"), REFERENCES("update_date") ON "public"."product_type" TO "postgres" WITH GRANT OPTION;
GRANT SELECT("name"), INSERT("name"), UPDATE("name"), REFERENCES("name") ON "public"."product_type" TO "postgres" WITH GRANT OPTION;
GRANT SELECT("id"), INSERT("id"), UPDATE("id"), REFERENCES("id") ON "public"."product_type" TO "postgres" WITH GRANT OPTION;




INSERT INTO "public"."product_type"("id", "name", "update_date")
  VALUES(1, 'Babys', '2017-05-25 00:08:45.477');
INSERT INTO "public"."product_type"("id", "name", "update_date")
  VALUES(2, 'Electrodomesticos', '2017-05-25 00:09:15.881');
INSERT INTO "public"."product_type"("id", "name", "update_date")
  VALUES(3, 'Computo', '2017-05-25 00:09:38.391');
INSERT INTO "public"."product_type"("id", "name", "update_date")
  VALUES(4, 'Jardineria', '2017-05-25 10:20:19.338');
INSERT INTO "public"."product_type"("id", "name", "update_date")
  VALUES(5, 'Muebles', '2017-05-27 12:21:13.0');
INSERT INTO "public"."product_type"("id", "name", "update_date")
  VALUES(6, 'Cocina', '2017-05-26 09:21:13.0');
INSERT INTO "public"."product_type"("id", "name", "update_date")
  VALUES(7, 'Autos', '2017-05-25 16:09:48.663');
  
INSERT INTO "public"."customer"("id", "address", "name", "update_date")
  VALUES(1, 'Irolo 122 Zacauitzco Benito Juarez', 'Ulises Baltazar Garcela', '2017-05-25 12:25:45.48');
INSERT INTO "public"."customer"("id", "address", "name", "update_date")
  VALUES(2, 'Rosa de Bengala 22 Alvaro Obregon', 'Carlos Ceron Lopez', '2017-05-25 12:26:20.142');
INSERT INTO "public"."customer"("id", "address", "name", "update_date")
  VALUES(3, 'Reforma 222 Paseo de Lomas Benito Juarez', 'Luis Angel Cerritos', '2017-05-25 12:27:12.2');
  INSERT INTO "public"."customer"("id", "address", "name", "update_date")
  VALUES(4, 'Irolo 122 Zacauitzco Benito Juarez', 'Emma Rios Guridi', '2017-05-24 12:25:45.48');
INSERT INTO "public"."customer"("id", "address", "name", "update_date")
  VALUES(5, 'Revolucion 154 Tacuba Alvaro Obregon', 'Gullermo Gonzalez Ramirez', '2017-05-21 12:26:20.142');
INSERT INTO "public"."customer"("id", "address", "name", "update_date")
  VALUES(6, 'Av Nacional 122 Polanco Benito Juarez', 'Arturo Baltazar Rios', '2017-05-25 12:27:12.2');

INSERT INTO "public"."product"("id", "name", "price", "update_date", "product_type")
  VALUES(1, 'Panales Recien Nacido', 150.00, '2017-05-25 11:57:18.883', 1);
INSERT INTO "public"."product"("id", "name", "price", "update_date", "product_type")
  VALUES(2, 'Panales Etapa 1', 160.00, '2017-05-25 11:57:18.883', 1);
INSERT INTO "public"."product"("id", "name", "price", "update_date", "product_type")
  VALUES(3, 'Panales Etapa 2', 180.00, '2017-05-25 11:57:18.883', 1);
INSERT INTO "public"."product"("id", "name", "price", "update_date", "product_type")
  VALUES(4, 'Biberon Chico', 80.00, '2017-05-25 11:57:18.883', 1);
INSERT INTO "public"."product"("id", "name", "price", "update_date", "product_type")
  VALUES(5, 'Panalera', 250.00, '2017-05-25 11:57:18.883', 1);
INSERT INTO "public"."product"("id", "name", "price", "update_date", "product_type")
  VALUES(6, 'Licuadora', 250.00, '2017-05-25 12:46:46.384', 2);
INSERT INTO "public"."product"("id", "name", "price", "update_date", "product_type")
  VALUES(7, 'Extractor de Jugos', 150.00, '2017-05-25 12:47:18.835', 2);
INSERT INTO "public"."product"("id", "name", "price", "update_date", "product_type")
  VALUES(8, 'Laptop', 11150.00, '2017-05-25 12:47:47.914', 3);
  
INSERT INTO "public"."order"("id", "name", "update_date", "customer", "product")
  VALUES(1, 'F001', '2017-05-25 12:38:56.632', 1, 1);
INSERT INTO "public"."order"("id", "name", "update_date", "customer", "product")
  VALUES(2, 'F001', '2017-05-25 12:40:17.602', 1, 2);
INSERT INTO "public"."order"("id", "name", "update_date", "customer", "product")
  VALUES(3, 'F002', '2017-05-25 12:52:40.121', 2, 6);
INSERT INTO "public"."order"("id", "name", "update_date", "customer", "product")
  VALUES(4, 'F003', '2017-05-25 12:52:40.121', 2, 8);
INSERT INTO "public"."order"("id", "name", "update_date", "customer", "product")
  VALUES(5, 'F004', '2017-05-25 12:53:27.08', 3, 8);
