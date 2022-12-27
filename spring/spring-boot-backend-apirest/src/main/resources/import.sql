INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Mr. John', 'Doe', 'john.doe@gmail.com', '2018-01-02');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Linus', 'Torvalds', 'linus.torvalds@gmail.com', '2018-01-03');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Rasmus', 'Lerdorf', 'rasmus.lerdorf@gmail.com', '2018-01-04');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Erich', 'Gamma', 'erich.gamma@gmail.com', '2018-02-01');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Richard', 'Helm', 'richard.helm@gmail.com', '2018-02-10');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Ralph', 'Johnson', 'ralph.johnson@gmail.com', '2018-02-18');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('John', 'Vlissides', 'john.vlissides@gmail.com', '2018-02-28');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Dr. James', 'Gosling', 'james.gosling@gmail.com', '2018-03-03');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Magma', 'Lee', 'magma.lee@gmail.com', '2018-03-04');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Tornado', 'Roe', 'tornado.roe@gmail.com', '2018-03-05');
INSERT INTO clientes (nombre, apellido, email, create_at) VALUES('Jade', 'Doe', 'jane.doe@gmail.com', '2018-03-06');

/*  CREACION DE USUARIOS CON ROLES */
INSERT INTO `usuarios`(username, password, enabled, nombre,apellido, email) VALUES ('andres','$2a$10$X/aSCxeN/3d.HdpIG4Qp2uteBeMe53Dy8z30/oANvOfFgXH2GpN3y',1, 'Miguel','López','mlpatri@mail.com');
INSERT INTO `usuarios`(username, password, enabled, nombre,apellido, email) VALUES ('admin','$2a$10$M7nffEQxfhssN9LiPjjG4.5f0NJ3yJ3pdGxCiSXNdujrjp0w7EIOu',1,'Luisa','Ramírez','luisa@correo.at');

INSERT INTO `roles`(name) VALUES ('ROLE_USER');
INSERT INTO `roles`(name) VALUES ('ROLE_ADMIN');

INSERT INTO `usuarios_roles`(usuario_id, role_id) VALUES (1,1);
INSERT INTO `usuarios_roles`(usuario_id, role_id) VALUES (2,2);
INSERT INTO `usuarios_roles`(usuario_id, role_id) VALUES (2,1);



