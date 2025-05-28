-- Categorias
INSERT INTO tb_categoria (id, descricao) VALUES (1, 'Curso');
INSERT INTO tb_categoria (id, descricao) VALUES (2, 'Oficina');

-- Atividades
INSERT INTO tb_atividade (id, nome, descricao, preco, categoria_id) VALUES (1, 'Curso de Java', 'Curso de Java', 100.00, 1);
INSERT INTO tb_atividade (id, nome, descricao, preco, categoria_id) VALUES (2, 'Oficina de HTML', 'Oficina de HTML', 50.00, 2);

-- Blocos
INSERT INTO tb_bloco (id, inicio, fim, atividade_id) VALUES (1, '2025-05-25T08:00:00Z', '2025-05-25T11:00:00Z', 1);
INSERT INTO tb_bloco (id, inicio, fim, atividade_id) VALUES (2, '2025-05-25T14:00:00Z', '2025-05-25T18:00:00Z', 2);
INSERT INTO tb_bloco (id, inicio, fim, atividade_id) VALUES (3, '2025-05-26T08:00:00Z', '2025-05-26T11:00:00Z', 2);


-- Participantes
INSERT INTO tb_participante (id, nome, email) VALUES (1, 'José Silva', 'jose@gmail.com');
INSERT INTO tb_participante (id, nome, email) VALUES (2, 'Tiago Faria', 'tiago@gmail.com');
INSERT INTO tb_participante (id, nome, email) VALUES (3, 'Maria do Rosário', 'maria@gmail.com');
INSERT INTO tb_participante (id, nome, email) VALUES (4, 'Teresa Silva', 'teresa@gmail.com');

-- Atividade Participante
INSERT INTO tb_atividade_participante (participante_id, atividade_id) VALUES (1, 1);
INSERT INTO tb_atividade_participante (participante_id, atividade_id) VALUES (2, 1);
INSERT INTO tb_atividade_participante (participante_id, atividade_id) VALUES (3, 1);
INSERT INTO tb_atividade_participante (participante_id, atividade_id) VALUES (3, 2);
INSERT INTO tb_atividade_participante (participante_id, atividade_id) VALUES (4, 2);


