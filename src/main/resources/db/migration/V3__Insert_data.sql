INSERT INTO categories (id, name, description, created_at, user_id) VALUES
(1, 'Desenvolvimento Java', 'Cursos focados em ecossistema Java e Spring', CURRENT_TIMESTAMP, 1),
(2, 'Infraestrutura', 'Docker, Git e Cloud', CURRENT_TIMESTAMP, 1);

INSERT INTO courses (id, title, description, status, created_at, updated_at, category_id, user_id) VALUES
(1, 'Spring Boot Expert', 'API REST Profissional com Java', 'IN_PROGRESS', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1, 1),
(2, 'Docker para Backend', 'Containers e Orquestração', 'PLANNED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 2, 1);

INSERT INTO modules (id, title, description, position, created_at, course_id) VALUES
(1, 'Fundamentos', 'Configuração e conceitos iniciais', 1, CURRENT_TIMESTAMP, 1);

INSERT INTO lessons (id, title, description, position, estimated_minutes, lesson_url, created_at, module_id) VALUES
(1, 'Configuração do Projeto', 'Setup do Maven e Dockerfile', 1, 20, 'https://youtube.com/watch?v=setup', CURRENT_TIMESTAMP, 1),
(2, 'Primeiro Controller', 'Criando o primeiro endpoint REST', 2, 25, 'https://youtube.com/watch?v=controller', CURRENT_TIMESTAMP, 1);

INSERT INTO lesson_progress (id, completed, completed_at, user_id, lesson_id) VALUES
(1, TRUE, CURRENT_TIMESTAMP, 1, 1);

INSERT INTO study_sessions (id, duration_minutes, notes, studied_at, user_id, lesson_id) VALUES
(1, 45, 'Configuração inicial do Spring Boot e Dockerfile', CURRENT_TIMESTAMP, 1, 1);

SELECT setval(pg_get_serial_sequence('categories',     'id'), 2);
SELECT setval(pg_get_serial_sequence('courses',        'id'), 2);
SELECT setval(pg_get_serial_sequence('modules',        'id'), 1);
SELECT setval(pg_get_serial_sequence('lessons',        'id'), 2);
SELECT setval(pg_get_serial_sequence('lesson_progress','id'), 1);
SELECT setval(pg_get_serial_sequence('study_sessions', 'id'), 1);