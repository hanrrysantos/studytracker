INSERT INTO users (name, email, password, role, created_at)
VALUES ('Admin', 'admin@email.com', '$2a$10$IxJEWq4C7iBjL2EgqpTI9uzKvBRGTIJRboa0VLjXiQZIvPFRN/jfW', 'ADMIN', CURRENT_TIMESTAMP)
ON CONFLICT (email) DO NOTHING;