USE bd_vsconnect;

SELECT * FROM tb_usuarios;

SELECT MIN(proposta) FROM tb_servicos;

SELECT MAX(proposta) FROM tb_servicos;

SELECT titulo, proposta 
FROM tb_servicos 
WHERE proposta = (SELECT MIN(proposta) FROM tb_servicos);

SELECT COUNT(id_servico) FROM tb_servicos;

SELECT COUNT(id_servico), status_servico
FROM tb_servicos
WHERE status_servico = "Em andamento";

SELECT COUNT(id_servico), status_servico
FROM tb_servicos
GROUP BY status_servico;

SELECT SUM(proposta) FROM tb_servicos;

SELECT * FROM tb_servicos WHERE tb_servicos.titulo LIKE "Dashboard";

SELECT titulo FROM tb_servicos ORDER BY titulo ASC;

SELECT proposta FROM tb_servicos ORDER BY proposta DESC;

/*INNER JOIN*/
SELECT titulo, tb_techs.nome
FROM tb_servicos
INNER JOIN tb_techs;

SELECT * 
FROM tb_cotacao
INNER JOIN tb_servicos ON tb_cotacao.id_servico = tb_servicos.id_servico
INNER JOIN tb_usuarios ON tb_cotacao.id_dev = tb_usuarios.id_usuario;

SELECT tb_cotacao.valor, tb_servicos.titulo, tb_usuarios.nome
FROM tb_cotacao
INNER JOIN tb_servicos ON tb_cotacao.id_servico = tb_servicos.id_servico
INNER JOIN tb_usuarios ON tb_cotacao.id_dev = tb_usuarios.id_usuario;