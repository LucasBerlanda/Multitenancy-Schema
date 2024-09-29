CREATE TABLE PESSOA(
    codigo BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome varchar(50) NOT NULL,
    cpf VARCHAR(20) NOT NULL,
    email varchar(50) NOT NULL,

    constraint uk_cpf_pessoa unique(cpf)
);