
insert into cozinha (nome_cozinha) values ('Tailandeza');
insert into cozinha (nome_cozinha) values ('Indiana');
insert into cozinha (nome_cozinha) values ('Italiana');
insert into cozinha (nome_cozinha) values ('Brasileira');
insert into cozinha (nome_cozinha) values ('Francesa');
insert into cozinha (nome_cozinha) values ('Árabe');


insert into estado (estado_nome, uf) values ('São Paulo', 'SP');
insert into estado (estado_nome, uf) values ('Rio de Janeiro', 'RJ');
insert into estado (estado_nome, uf) values ('Santa Catarina','SC');
insert into estado (estado_nome, uf) values ('Pernabuco','PE');
insert into estado (estado_nome, uf) values ('Bahia','BA');
insert into estado (estado_nome, uf) values ('Minas Gerais','MG');
insert into estado (estado_nome, uf) values ('Roraima','RO');


insert into cidade (cidade_nome, estado_id) values ('São Paulo',1);
insert into cidade (cidade_nome, estado_id) values ('Rio de Janeiro',2);
insert into cidade (cidade_nome, estado_id) values ('Florianópolis',3);
insert into cidade (cidade_nome, estado_id) values ('Recife',4);
insert into cidade (cidade_nome, estado_id) values ('Feira de Santana',5);
insert into cidade (cidade_nome, estado_id) values ('Belo Horizonte',6);


-- insert into restaurante (nome_restaurante, taxa_frete, cozinha_id) values ('Cantina Giggio', 1.0, 1);
INSERT INTO restaurante (endereco_bairro,endereco_cep,endereco_complemento,endereco_logradouro,endereco_numero,nome_restaurante,taxa_frete,cozinha_id,endereco_cidade, data_atualizacao, data_cadastro) VALUES ('Vila Dionisia','02671020','AP 114, Bl E','Rua Nicolau Tolentino de Almeida','61','Cantina Giggio',1.00,1,1,  now() at time zone 'utc',  now() at time zone 'utc');
insert into restaurante (nome_restaurante, taxa_frete, cozinha_id, data_atualizacao, data_cadastro) values ('Pizzaria Marcus', 2.0, 2,  now() at time zone 'utc',  now() at time zone 'utc');
insert into restaurante (nome_restaurante, taxa_frete, cozinha_id, data_atualizacao, data_cadastro) values ('O Marmiteiro', 5.0, 1,  now() at time zone 'utc',  now() at time zone 'utc');
insert into restaurante (nome_restaurante, taxa_frete, cozinha_id, data_atualizacao, data_cadastro) values ('Comiga Vegana e Cia', 3.0, 3,  now() at time zone 'utc',  now() at time zone 'utc');
insert into restaurante (nome_restaurante, taxa_frete, cozinha_id, data_atualizacao, data_cadastro) values ('Habibis Esfiharia', 7.0, 4,  now() at time zone 'utc',  now() at time zone 'utc');




insert into permissao (nome, descricao) values ('CONSULTAR_COZINHAS', 'Permite consultar cozinhas');
insert into permissao (nome, descricao) values ('EDITAR_COZINHAS', 'Permite editar cozinhas');

insert into forma_Pagamento (descricao) values ('Dinheiro');
insert into forma_Pagamento (descricao) values ('Cartão de Crédito');
insert into forma_Pagamento (descricao) values ('Cartão de Débito');
insert into forma_Pagamento (descricao) values ('Cartão vale refeição');


-- INSERT FORMAS DE PAGAMENTO PARA RESTAURANTES
INSERT INTO RESTAURANTE_FORMAS_PAGAMENTO (RESTAURANTE_ID,FORMA_PAGAMENTO_ID) VALUES (1,1), (1,2), (1,3), (1,4), (2,1), (2,3), (3,1), (3,4), (4,1), (5,1);

