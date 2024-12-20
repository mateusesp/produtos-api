create table produto (
    id UUID not null primary key,
    nome varchar(255) not null,
    descricao varchar(300),
    preco numeric(18,2)
);