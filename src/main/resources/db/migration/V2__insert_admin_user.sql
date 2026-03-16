INSERT INTO "users" (id, name, email, password, role, created_at) VALUES
(1, 'Admin', 'admin@email.com', '$2a$10$IxJEWq4C7iBjL2EgqpTI9uzKvBRGTIJRboa0VLjXiQZIvPFRN/jfW', 'ADMIN', CURRENT_TIMESTAMP);

SELECT setval(pg_get_serial_sequence('users', 'id'), 1);