DROP DATABASE IF EXISTS Farmacia;
create database Farmacia;

use Farmacia;

CREATE TABLE EMPLEADO
(
 cod_emp    INT auto_increment ,
 nombre_emp varchar(45) NOT NULL ,
 dni_emp    int NOT NULL ,
 usuario	varchar (5) not null,
 clave 		varchar(6) not null,
PRIMARY KEY (cod_emp)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ************************************** `CLIENTE`

CREATE TABLE CLIENTE
(
 cod_cli INT auto_increment ,
 nom_cli varchar(45) NOT NULL ,
 dni    VARCHAR(8) NOT NULL ,
 celular varchar(9) not null,
 correo varchar(45) not null,

PRIMARY KEY (cod_cli)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ************************************** `Proveedor`

CREATE TABLE Proveedor
(
 cod_prov     int auto_increment ,
 nom_prov     varchar(45) NOT NULL ,
 celular_prov int NOT NULL ,
 dir_prov     varchar(45) NOT NULL ,

PRIMARY KEY (cod_prov)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ************************************** `PRODUCTO`

CREATE TABLE PRODUCTO
(
 cod_producto    varchar(5) NOT NULL ,
 nom_producto    varchar(45) NOT NULL ,
 cod_prov        int NOT NULL ,
 precio_producto decimal(10,2) NOT NULL ,
 fecha_venci     datetime NOT NULL ,
 stock           int NOT NULL ,

PRIMARY KEY (cod_producto),
CONSTRAINT FOREIGN KEY (cod_prov) REFERENCES Proveedor (cod_prov)
);

-- ************************************** `Boleta`

CREATE TABLE Boleta
(
 num_boleta      char(5) NOT NULL ,
 fecha_boleta     date not null ,
 cod_cli INT NOT NULL ,
 cod_emp int NOT NULL ,
 total_boleta     decimal(8,2) ,

PRIMARY KEY (num_boleta),
CONSTRAINT FOREIGN KEY (cod_cli) REFERENCES cliente (cod_cli),
CONSTRAINT FOREIGN KEY (cod_emp) REFERENCES empleado (cod_emp)
);

-- ************************************** `DetalleBoleta`
create table detalle_boleta
(
num_boleta     char(5) not null,
cod_producto     varchar(5) not null,
cantidad    int,
preciovta   decimal(8,2),
importe		decimal(8,2),
primary key (num_boleta,cod_producto),
foreign key (num_boleta) references boleta(num_boleta),
foreign key (cod_producto) references producto(cod_producto)
);


INSERT INTO CLIENTE(nom_cli,dni,celular,correo) VALUES ('AGUSTIN MAMANI','75333114','914340613','agusdmu@gmail.com');
INSERT INTO CLIENTE(nom_cli,dni,celular,correo) VALUES ('Elsa Macias','67295284','914340613','agusdmu1999@gmail.com');
INSERT INTO CLIENTE(nom_cli,dni,celular,correo) VALUES ('Anne Espin','65627197','914340613','dex2838@outlook.com');
INSERT INTO CLIENTE(nom_cli,dni,celular,correo) VALUES ('Sara Vico','40507360','914340613','dextro28382@outlook.com');
INSERT INTO CLIENTE(nom_cli,dni,celular,correo) VALUES ('Unax Castillo','22226400','914340613','dex2838_2016@outlook.com');
INSERT INTO CLIENTE(nom_cli,dni,celular,correo) VALUES ('Justa Portela','99561646','914340613','dex283810@outlook.com');

INSERT INTO PROVEEDOR(nom_prov,celular_prov,dir_prov) VALUES('
P&G DISTRIBUIDORES SRL', 947852145 , 'https://www.distribuidorespyg.com/');
INSERT INTO PROVEEDOR(nom_prov,celular_prov,dir_prov) VALUES('
Abundance and Health', 947123145 , 'Maritana Gate, Canada Street');
INSERT INTO PROVEEDOR(nom_prov,celular_prov,dir_prov) VALUES('
Unaune Media', 944562145 , 'C/ Caballero de Rodas 25 2º C');
INSERT INTO PROVEEDOR(nom_prov,celular_prov,dir_prov) VALUES('
Laboratorios Ubiopharma', 947855675 , ' avenida juan de austria 142');
INSERT INTO PROVEEDOR(nom_prov,celular_prov,dir_prov) VALUES('
Maxin Farma Asociados', 949762145 , 'AV. AMERICA 39 ');

INSERT INTO EMPLEADO(nombre_emp,dni_emp,usuario,clave) values ('AGUSTIN MAMANI USCAMAYTA','75333114','ADMU1','123456');
INSERT INTO EMPLEADO(nombre_emp,dni_emp,usuario,clave) values ('ALEXIS MAMANI MAMANI','73412223','ALMM1','123456');

INSERT INTO PRODUCTO values('P0001','Simvastatina',1,2.0,'2022-11-05',100);
INSERT INTO PRODUCTO values('P0002','Aspirina',2,2.0,'2022-11-05',100);
INSERT INTO PRODUCTO values('P0003','Omeprazol',3,2.0,'2022-11-05',100);
INSERT INTO PRODUCTO values('P0004','Lexotiroxina sódica',2,2.0,'2022-11-05',100);
INSERT INTO PRODUCTO values('P0005','Ramipril',3,2.0,'2022-11-05',100);
INSERT INTO PRODUCTO values('P0006','Amlodipina',2,2.0,'2022-11-05',100);

DELIMITER $$
CREATE PROCEDURE usp_ListarProveedor
()
BEGIN
	select *
    FROM proveedor;
end $$
DELIMITER ;

DROP DATABASE IF EXISTS Farmacia;
create database Farmacia;

use Farmacia;
CREATE TABLE EMPLEADO
(
 cod_emp    INT auto_increment ,
 nombre_emp varchar(45) NOT NULL ,
 dni_emp    int NOT NULL ,
 usuario	varchar (5) not null,
 clave 		varchar(6) not null,
PRIMARY KEY (cod_emp)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ************************************** `CLIENTE`

CREATE TABLE CLIENTE
(
 cod_cli INT auto_increment ,
 nom_cli varchar(45) NOT NULL ,
 dni    VARCHAR(8) NOT NULL ,
 celular varchar(9) not null,
 correo varchar(45) not null,

PRIMARY KEY (cod_cli)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ************************************** `Proveedor`

CREATE TABLE Proveedor
(
 cod_prov     int auto_increment ,
 nom_prov     varchar(45) NOT NULL ,
 celular_prov int NOT NULL ,
 dir_prov     varchar(45) NOT NULL ,

PRIMARY KEY (cod_prov)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ************************************** `PRODUCTO`

CREATE TABLE PRODUCTO
(
 cod_producto    varchar(5) NOT NULL ,
 nom_producto    varchar(45) NOT NULL ,
 cod_prov        int NOT NULL ,
 precio_producto decimal(10,2) NOT NULL ,
 fecha_venci     datetime NOT NULL ,
 stock           int NOT NULL ,

PRIMARY KEY (cod_producto),
CONSTRAINT FOREIGN KEY (cod_prov) REFERENCES Proveedor (cod_prov)
);

-- ************************************** `Boleta`

CREATE TABLE Boleta
(
 num_boleta      char(5) NOT NULL ,
 fecha_boleta     date not null ,
 cod_cli INT NOT NULL ,
 cod_emp int NOT NULL ,
 total_boleta     decimal(8,2) ,

PRIMARY KEY (num_boleta),
CONSTRAINT FOREIGN KEY (cod_cli) REFERENCES cliente (cod_cli),
CONSTRAINT FOREIGN KEY (cod_emp) REFERENCES empleado (cod_emp)
);

-- ************************************** `DetalleBoleta`
create table detalle_boleta
(
num_boleta     char(5) not null,
cod_producto     varchar(5) not null,
cantidad    int,
preciovta   decimal(8,2),
importe		decimal(8,2),
primary key (num_boleta,cod_producto),
foreign key (num_boleta) references boleta(num_boleta),
foreign key (cod_producto) references producto(cod_producto)
);


INSERT INTO CLIENTE(nom_cli,dni,celular,correo) VALUES ('AGUSTIN MAMANI','75333114','914340613','agusdmu@gmail.com');
INSERT INTO CLIENTE(nom_cli,dni,celular,correo) VALUES ('Elsa Macias','67295284','914340613','agusdmu1999@gmail.com');
INSERT INTO CLIENTE(nom_cli,dni,celular,correo) VALUES ('Anne Espin','65627197','914340613','dex2838@outlook.com');
INSERT INTO CLIENTE(nom_cli,dni,celular,correo) VALUES ('Sara Vico','40507360','914340613','dextro28382@outlook.com');
INSERT INTO CLIENTE(nom_cli,dni,celular,correo) VALUES ('Unax Castillo','22226400','914340613','dex2838_2016@outlook.com');
INSERT INTO CLIENTE(nom_cli,dni,celular,correo) VALUES ('Justa Portela','99561646','914340613','dex283810@outlook.com');

INSERT INTO PROVEEDOR(nom_prov,celular_prov,dir_prov) VALUES('
P&G DISTRIBUIDORES SRL', 947852145 , 'https://www.distribuidorespyg.com/');
INSERT INTO PROVEEDOR(nom_prov,celular_prov,dir_prov) VALUES('
Abundance and Health', 947123145 , 'Maritana Gate, Canada Street');
INSERT INTO PROVEEDOR(nom_prov,celular_prov,dir_prov) VALUES('
Unaune Media', 944562145 , 'C/ Caballero de Rodas 25 2º C');
INSERT INTO PROVEEDOR(nom_prov,celular_prov,dir_prov) VALUES('
Laboratorios Ubiopharma', 947855675 , ' avenida juan de austria 142');
INSERT INTO PROVEEDOR(nom_prov,celular_prov,dir_prov) VALUES('
Maxin Farma Asociados', 949762145 , 'AV. AMERICA 39 ');

INSERT INTO EMPLEADO(nombre_emp,dni_emp,usuario,clave) values ('AGUSTIN MAMANI USCAMAYTA','75333114','ADMU1','123456');
INSERT INTO EMPLEADO(nombre_emp,dni_emp,usuario,clave) values ('ALEXIS MAMANI MAMANI','73412223','ALMM1','123456');

INSERT INTO PRODUCTO values('P0001','Simvastatina',1,2.0,'2022-11-05',100);
INSERT INTO PRODUCTO values('P0002','Aspirina',2,2.0,'2022-11-05',100);
INSERT INTO PRODUCTO values('P0003','Omeprazol',3,2.0,'2022-11-05',100);
INSERT INTO PRODUCTO values('P0004','Lexotiroxina sódica',2,2.0,'2022-11-05',100);
INSERT INTO PRODUCTO values('P0005','Ramipril',3,2.0,'2022-11-05',100);
INSERT INTO PRODUCTO values('P0006','Amlodipina',2,2.0,'2022-11-05',100);

DELIMITER $$
CREATE PROCEDURE usp_ListarProveedor
()
BEGIN
	select *
    FROM proveedor;
end $$
DELIMITER ;

-- TEST 
CALL usp_ListarProveedor()

DELIMITER $$
CREATE PROCEDURE usp_ValidarUsuario
(
v_usuario varchar(8),
v_clave varchar(8)
)
BEGIN
	select *
    FROM empleado
    where usuario=v_usuario
    and clave = v_clave;
end $$
DELIMITER ;
SELECT * FROM PROVEEDOR;

-- PROCEDIMIENTO ALMACENADO PARA BUSCAR CLIENTE POR DOCUMENTO
DELIMITER $$
CREATE PROCEDURE usp_BuscarCliente
(
v_documento varchar(8)
)
BEGIN
	select *
    FROM cliente
    where dni=v_documento;
end $$
DELIMITER ;

CALL usp_BuscarCliente (75333114);

-- PROCEDIMIENTO ALMACENADO PARA BUSCAR PRODUCTO POR CODIGO
DELIMITER $$
CREATE PROCEDURE usp_BuscarProductoXCodigo
(
v_codigo varchar(8)
)
BEGIN
	select *
    FROM producto
    where cod_producto=v_codigo;
end $$
DELIMITER ;

-- PROCEDIMIENTO ALMACENADO PARA OBTENER LA ULTIMA BOLETA
DELIMITER $$
CREATE PROCEDURE usp_ListarBoletaUltima
()
BEGIN
	select *
    FROM boleta
    order by convert (substring(num_boleta,2),signed integer)desc;
end $$
DELIMITER ;

-- PROCEDIMIENTO ALMACENADO PARA BUSCAR PRODUCTO POR NOMBRE
DELIMITER $$
CREATE PROCEDURE usp_BuscarProductoXNombre
(
v_nombre varchar(45)
)
BEGIN
	select *
    FROM producto
    where nom_producto=v_nombre;
end $$
DELIMITER ;

-- PROCEDIMIENTO ALMACENADO PARA VER LOS 3 PRODUCTOS MAS VENDIDOS
DELIMITER $$
CREATE PROCEDURE usp_ProductosVendidos
()
BEGIN
	SELECT PRODUCTO.NOM_PRODUCTO, SUM(DETALLE_BOLETA.CANTIDAD) AS CANTIDAD
	FROM DETALLE_BOLETA JOIN PRODUCTO ON DETALLE_BOLETA.COD_PRODUCTO = PRODUCTO.COD_PRODUCTO
	GROUP BY PRODUCTO.COD_PRODUCTO
	ORDER BY SUM(DETALLE_BOLETA.CANTIDAD) DESC;
end $$
DELIMITER ;
-- TEST 
CALL usp_ListarBoletaUltima();

SELECT * FROM BOLETA;
select * from detalle_boleta;