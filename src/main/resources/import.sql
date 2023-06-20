--insert into cozinha (id, nome_cozinha) values (1, 'Tailandeza');
--insert into cozinha (id, nome_cozinha) values (2, 'Indiana');
--insert into cozinha (id, nome_cozinha) values (3, 'Italiana');
--insert into cozinha (id, nome_cozinha) values (4, 'Brasileira');
--insert into cozinha (id, nome_cozinha) values (5, 'Francesa');
--insert into cozinha (id, nome_cozinha) values (6, 'Árabe');

insert into cozinha (nome_cozinha) values ('Tailandeza');
insert into cozinha (nome_cozinha) values ('Indiana');
insert into cozinha (nome_cozinha) values ('Italiana');
insert into cozinha (nome_cozinha) values ('Brasileira');
insert into cozinha (nome_cozinha) values ('Francesa');
insert into cozinha (nome_cozinha) values ('Árabe');

insert into restaurante (nome_restaurante, taxa_frete, cozinha_id) values ('Cantina Giggio', 1.0, 1);
insert into restaurante (nome_restaurante, taxa_frete, cozinha_id) values ('Pizzaria Marcus', 2.0, 2);
insert into restaurante (nome_restaurante, taxa_frete, cozinha_id) values ('O Marmiteiro', 5.0, 1);
insert into restaurante (nome_restaurante, taxa_frete, cozinha_id) values ('Comiga Vegana e Cia', 3.0, 3);
insert into restaurante (nome_restaurante, taxa_frete, cozinha_id) values ('Habibis Esfiharia', 7.0, 4);


--insert into estado (id, nome) values (1, 'São Paulo');
--insert into estado (id, nome) values (2, 'Rio de Janeiro');
--insert into estado (id, nome) values (3, 'Santa Catarina');
--insert into estado (id, nome) values (4, 'Pernabuco');
--insert into estado (id, nome) values (5, 'Bahia');
--insert into estado (id, nome) values (6, 'Minas Gerais');

insert into estado (nome) values ('São Paulo');
insert into estado (nome) values ('Rio de Janeiro');
insert into estado (nome) values ('Santa Catarina');
insert into estado (nome) values ('Pernabuco');
insert into estado (nome) values ('Bahia');
insert into estado (nome) values ('Minas Gerais');
insert into estado (nome) values ('Roraima');

--insert into cidade (id, nome, estado_id) values (1, 'São Paulo',1);
--insert into cidade (id, nome, estado_id) values (2, 'Rio de Janeiro',2);
--insert into cidade (id, nome, estado_id) values (3, 'Florianópolis',3);
--insert into cidade (id, nome, estado_id) values (4, 'Recife',4);
--insert into cidade (id, nome, estado_id) values (5, 'Feira de Santana',5);
--insert into cidade (id, nome, estado_id) values (6, 'Belo Horizonte',6);

insert into cidade (nome, estado_id) values ('São Paulo',1);
insert into cidade (nome, estado_id) values ('Rio de Janeiro',2);
insert into cidade (nome, estado_id) values ('Florianópolis',3);
insert into cidade (nome, estado_id) values ('Recife',4);
insert into cidade (nome, estado_id) values ('Feira de Santana',5);
insert into cidade (nome, estado_id) values ('Belo Horizonte',6);

--insert into permissao (id, nome, descricao) values (1, 'CONSULTAR_COZINHAS', 'Permite consultar cozinhas');
--insert into permissao (id, nome, descricao) values (2, 'EDITAR_COZINHAS', 'Permite editar cozinhas');

insert into permissao (nome, descricao) values ('CONSULTAR_COZINHAS', 'Permite consultar cozinhas');
insert into permissao (nome, descricao) values ('EDITAR_COZINHAS', 'Permite editar cozinhas');

--insert into forma_Pagamento (id, descricao) values (1, 'Dinheiro');
--insert into forma_Pagamento (id, descricao) values (2, 'Cartão de Crédito');
--insert into forma_Pagamento (id, descricao) values (3, 'Cartão de Débito');
--insert into forma_Pagamento (id, descricao) values (4, 'Cartão vale refeição');

insert into forma_Pagamento (descricao) values ('Dinheiro');
insert into forma_Pagamento (descricao) values ('Cartão de Crédito');
insert into forma_Pagamento (descricao) values ('Cartão de Débito');
insert into forma_Pagamento (descricao) values ('Cartão vale refeição');

-- INSERT FORMAS DE PAGAMENTO PARA RESTAURANTES
INSERT INTO RESTAURANTE_FORMAS_PAGAMENTO (RESTAURANTE_ID,FORMA_PAGAMENTO_ID) VALUES (1,1), (1,2), (1,3), (1,4), (2,1), (2,3), (3,1), (3,4), (4,1), (5,1);

