-- Inserção de dados na tabela clientes
INSERT INTO clientes (nome, cpf, senha) VALUES
('Cliente 2', '40464605040', 'Senh@023'),
('Cliente 3', '80714091030', 'Senh@023'),
('Cliente 4', '47232921012', 'Senh@023'),
('Cliente 5', '46189049095', 'Senh@023'),
('Cliente 6', '50759334080', 'Senh@023'),
('Cliente 7', '65813400060', 'Senh@023');

-- Inserção de dados na tabela contas
INSERT INTO contas (agencia, nconta, saldo, cpf) VALUES
('001', '00002-1', 00.00, '40464605040'),
('002', '00003-1', 00.00, '80714091030'),
('003', '00004-1', 0, '47232921012'),
('004', '00005-1', 200000000, '46189049095'),
('005', '00006-1', 0, '50759334080'),
('006', '00007-1', 0, '50759334080'),
('007', '00008-1', 00.00, '65813400060');


-- Inserção de dados na tabela usuarios
INSERT INTO usuarios (login, senha)
SELECT cpf, 'Senh@023' FROM clientes;

INSERT INTO usuarios (login, senha) VALUES ('itau', '$2a$10$bfkagE/FzcMgdC7t6V8aK.8093qHme0a7YMYe/hdo1gnpUM2JZ9pK');

