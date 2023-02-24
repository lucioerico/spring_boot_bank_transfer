create table clientes(
id bigint not null auto_increment,
nome varchar(100) not null,
cpf varchar(11) not null unique,
senha varchar (255) not null,
primary key(id)
);

create table contas(
id bigint not null auto_increment,
agencia varchar(100) not null,
nconta varchar(100) not null,
saldo decimal(18, 4) not null,
cpf varchar(11) not null,
primary key(id),
foreign key(cpf) references clientes(cpf)
);