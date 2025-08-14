--V2: Migrations para add coluna de rank na tabela de cadrastro

ALTER TABLE tb_cadastro
ADD COLUMN rank VARCHAR(255);