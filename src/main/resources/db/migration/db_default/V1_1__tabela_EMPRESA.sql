CREATE TABLE EMPRESA(
    codigo BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nome varchar(50) NOT NULL,
    cnpj VARCHAR(20) NOT NULL,
    email_administrador varchar(50) NOT NULL,

    constraint uk_email_administrador unique(email_administrador),
    constraint uk_cnpj_empresa unique(cnpj)
);