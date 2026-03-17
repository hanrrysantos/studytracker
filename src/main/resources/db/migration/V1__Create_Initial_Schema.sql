CREATE TABLE "users" (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(10) NOT NULL,
    created_at TIMESTAMP NOT NULL
);

CREATE TABLE categories (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(200),
    created_at TIMESTAMP NOT NULL,
    user_id BIGINT REFERENCES "users"(id)
);

CREATE TABLE courses (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description VARCHAR(200),
    status VARCHAR(20) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    category_id BIGINT REFERENCES categories(id),
    user_id BIGINT REFERENCES "users"(id)
);

CREATE TABLE modules (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description VARCHAR(200),
    position INTEGER NOT NULL,
    created_at TIMESTAMP NOT NULL,
    course_id BIGINT REFERENCES courses(id)
);

CREATE TABLE lessons (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description VARCHAR(200),
    position INTEGER NOT NULL,
    estimated_minutes INTEGER,
    lesson_url VARCHAR(500),
    created_at TIMESTAMP NOT NULL,
    module_id BIGINT REFERENCES modules(id)
);

CREATE TABLE lesson_progress (
    id BIGSERIAL PRIMARY KEY,
    completed BOOLEAN NOT NULL DEFAULT FALSE,
    completed_at TIMESTAMP,
    user_id BIGINT REFERENCES "users"(id),
    lesson_id BIGINT REFERENCES lessons(id),
    CONSTRAINT uk_user_lesson UNIQUE (user_id, lesson_id)
);

CREATE TABLE study_sessions (
    id BIGSERIAL PRIMARY KEY,
    duration_minutes INTEGER NOT NULL,
    notes VARCHAR(200),
    studied_at TIMESTAMP NOT NULL,
    user_id BIGINT REFERENCES "users"(id),
    lesson_id BIGINT REFERENCES lessons(id)
);