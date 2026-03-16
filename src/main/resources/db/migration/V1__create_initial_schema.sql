CREATE TABLE "users" (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL,
    created_at TIMESTAMP NOT NULL
);

CREATE TABLE categories (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    created_at TIMESTAMP NOT NULL,
    user_id BIGINT REFERENCES "users"(id)
);

CREATE TABLE courses (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    status VARCHAR(20) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    category_id BIGINT REFERENCES categories(id),
    user_id BIGINT REFERENCES "users"(id)
);

CREATE TABLE modules (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    position INTEGER NOT NULL,
    created_at TIMESTAMP NOT NULL,
    course_id BIGINT REFERENCES courses(id)
);

CREATE TABLE lessons (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    position INTEGER NOT NULL,
    estimated_minutes INTEGER,
    lesson_url VARCHAR(255),
    created_at TIMESTAMP NOT NULL,
    module_id BIGINT REFERENCES modules(id)
);

CREATE TABLE lesson_progress (
    id BIGSERIAL PRIMARY KEY,
    completed BOOLEAN NOT NULL DEFAULT FALSE,
    completed_at TIMESTAMP,
    user_id BIGINT REFERENCES "users"(id),
    lesson_id BIGINT REFERENCES lessons(id)
);

CREATE TABLE study_sessions (
    id BIGSERIAL PRIMARY KEY,
    duration_minutes INTEGER NOT NULL,
    notes TEXT,
    studied_at TIMESTAMP NOT NULL,
    user_id BIGINT REFERENCES "users"(id),
    lesson_id BIGINT REFERENCES lessons(id)
);