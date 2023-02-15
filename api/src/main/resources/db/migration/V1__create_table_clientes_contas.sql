create table clientes(
id bigint not null auto_increment,
nome varchar(100) not null,
cpf varchar(11) not null unique,
senha varchar (10) not null,
primary key(id)
);

create table contas(
id bigint not null auto_increment,
agencia varchar(100) not null,
nconta varchar(100) not null,
saldo decimal(18, 4) not null,
cpf_cliente varchar(11) not null,
primary key(id),
foreign key(cpf_cliente) references clientes(cpf)
);