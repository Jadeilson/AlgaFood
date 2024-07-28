



-- CADASTRO DAS COZINHAS
insert into cozinha (nome_cozinha) values ('Tailandeza');
insert into cozinha (nome_cozinha) values ('Indiana');
insert into cozinha (nome_cozinha) values ('Italiana');
insert into cozinha (nome_cozinha) values ('Brasileira');
insert into cozinha (nome_cozinha) values ('Francesa');
insert into cozinha (nome_cozinha) values ('Árabe');

-- CADASTRO DOS ESTADOS
insert into estado (estado_nome, uf) values ('São Paulo', 'SP');
insert into estado (estado_nome, uf) values ('Rio de Janeiro', 'RJ');
insert into estado (estado_nome, uf) values ('Santa Catarina','SC');
insert into estado (estado_nome, uf) values ('Pernabuco','PE');
insert into estado (estado_nome, uf) values ('Bahia','BA');
insert into estado (estado_nome, uf) values ('Minas Gerais','MG');
insert into estado (estado_nome, uf) values ('Roraima','RO');

-- CADASTRO DAS CIDADES PARA OS ESTADOS
insert into cidade (cidade_nome, estado_id) values ('São Paulo',1);
insert into cidade (cidade_nome, estado_id) values ('Rio de Janeiro',2);
insert into cidade (cidade_nome, estado_id) values ('Florianópolis',3);
insert into cidade (cidade_nome, estado_id) values ('Recife',4);
insert into cidade (cidade_nome, estado_id) values ('Feira de Santana',5);
insert into cidade (cidade_nome, estado_id) values ('Belo Horizonte',6);


-- CADASTRO DOS RESTAURANTES CUJO ENDEREÇO APONTA PARA CIDADE
INSERT INTO restaurante (endereco_bairro,endereco_cep,endereco_complemento,endereco_logradouro,endereco_numero,nome_restaurante,taxa_frete,cozinha_id,endereco_cidade, data_atualizacao, data_cadastro) VALUES ('Vila Dionisia','02671020','AP 114, Bl E','Rua Nicolau Tolentino de Almeida','61','Cantina Giggio',1.00,1,1,  now() at time zone 'utc',  now() at time zone 'utc');
insert into restaurante (nome_restaurante, taxa_frete, cozinha_id, data_atualizacao, data_cadastro) values ('Pizzaria Marcus', 2.0, 2,  now() at time zone 'utc',  now() at time zone 'utc');
insert into restaurante (nome_restaurante, taxa_frete, cozinha_id, data_atualizacao, data_cadastro) values ('O Marmiteiro', 5.0, 1,  now() at time zone 'utc',  now() at time zone 'utc');
insert into restaurante (nome_restaurante, taxa_frete, cozinha_id, data_atualizacao, data_cadastro) values ('Comiga Vegana e Cia', 3.0, 3,  now() at time zone 'utc',  now() at time zone 'utc');
insert into restaurante (nome_restaurante, taxa_frete, cozinha_id, data_atualizacao, data_cadastro) values ('Habibis Esfiharia', 7.0, 4,  now() at time zone 'utc',  now() at time zone 'utc');

-- CADASTRO DE PRODUTOS VINCULADOS A RESTAURANTES
INSERT INTO public.produto (produto_id,produto_descricao,produto_ativo,produto_nome,produto_preco,restaurante_id) VALUES (1,'Salada de Maionese da Casa',true,'Salada de Maionese',12.50,1);
INSERT INTO public.produto (produto_id,produto_descricao,produto_ativo,produto_nome,produto_preco,restaurante_id) VALUES (2,'Frango a Parmegiana',true,'Frango a Parmegiana',10.00,1);
INSERT INTO public.produto (produto_id,produto_descricao,produto_ativo,produto_nome,produto_preco,restaurante_id) VALUES (3,'Bife a Milanesa',true,'Bife a Milanesa',17.99,1);
INSERT INTO public.produto (produto_id,produto_descricao,produto_ativo,produto_nome,produto_preco,restaurante_id) VALUES (4,'Petit Gateau',true,'Petit Gateau',29.90,1);
INSERT INTO public.produto (produto_id,produto_descricao,produto_ativo,produto_nome,produto_preco,restaurante_id) VALUES (5,'Salada de Maionese da Casa',true,'Salada de Maionese',12.50,2);
INSERT INTO public.produto (produto_id,produto_descricao,produto_ativo,produto_nome,produto_preco,restaurante_id) VALUES (6,'Frango a Parmegiana',true,'Frango a Parmegiana',10.00,2);
INSERT INTO public.produto (produto_id,produto_descricao,produto_ativo,produto_nome,produto_preco,restaurante_id) VALUES (7,'Bife a Milanesa',true,'Bife a Milanesa',17.99,3);
INSERT INTO public.produto (produto_id,produto_descricao,produto_ativo,produto_nome,produto_preco,restaurante_id) VALUES (8,'Petit Gateau',true,'Petit Gateau',29.90,3);

-- CADASTRO DE FORMAS DE PAGAMENTOS
insert into forma_Pagamento (descricao) values ('Dinheiro');
insert into forma_Pagamento (descricao) values ('Cartão de Crédito');
insert into forma_Pagamento (descricao) values ('Cartão de Débito');
insert into forma_Pagamento (descricao) values ('Cartão vale refeição');

-- CADASTRO FORMAS DE PAGAMENTO PARA RESTAURANTES
INSERT INTO RESTAURANTE_FORMAS_PAGAMENTO (RESTAURANTE_ID,FORMA_PAGAMENTO_ID) VALUES (1,1), (1,2), (1,3), (1,4), (2,1), (2,3), (3,1), (3,4), (4,1), (5,1);

-- CADASTRO DE TIPOS DE PERMISSÕES
insert into permissao (nome, descricao) values ('CONSULTAR_COZINHAS', 'Permite consultar cozinhas');
insert into permissao (nome, descricao) values ('EDITAR_COZINHAS', 'Permite editar cozinhas');

-- CADASTRO DE GRUPOS DE ACESSO/PERMISSÕES
INSERT INTO GRUPO (GRUPO_ID, GRUPO_NOME) VALUES (1,'ADMINISTRADOR'), (2,'SUPORTE'), (3,'FUNCIONARIO');

-- CADASTRO/VINCULO DAS PERMISSÕES DE CADA GRUPO DE ACESSO
INSERT INTO GRUPO_PERMISSOES (GRUPO_ID, PERMISSAO_ID) VALUES (1,1), (1,2), (2,1), (3,1), (3,2);

-- CADASTRO DE USUARIOS
INSERT INTO USUARIO (USUARIO_ID, USUARIO_DATA_CADASTRO, USUARIO_EMAIL, USUARIO_NOME, USUARIO_SENHA) VALUES (1,NOW() AT TIME ZONE 'UTC', 'ADM@ALGAFOOD.COM.BR', 'ADMINISTRADOR', 'ABCDEFGHIJ');
INSERT INTO USUARIO (USUARIO_ID, USUARIO_DATA_CADASTRO, USUARIO_EMAIL, USUARIO_NOME, USUARIO_SENHA) VALUES (3,NOW() AT TIME ZONE 'UTC', 'JOAQUI.OLIVEIRA@ALGAFOOD.COM.BR', 'JOAQUIM OLIVEIRA SILVA - SUPORTE', 'ABCDEFGHIJ');
INSERT INTO USUARIO (USUARIO_ID, USUARIO_DATA_CADASTRO, USUARIO_EMAIL, USUARIO_NOME, USUARIO_SENHA) VALUES (2,NOW() AT TIME ZONE 'UTC', 'JOSE.SILVA@ALGAFOOD.COM.BR', 'JOSE DA SILVA', 'ABCDEFGHIJ');

-- CADASTRO/VINCULO DOS USUÁRIOS AOS GRUPOS DE PERMISSÕES
INSERT INTO USUARIO_GRUPO (USUARIO_ID, GRUPO_ID) VALUES (1,1), (2,2), (3,3);


	