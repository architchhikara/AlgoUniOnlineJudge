-- Active: 1710742976329@@127.0.0.1@5432@OnlineJudge

CREATE TYPE difficulty AS ENUM ('EASY', 'MEDIUM', 'HARD');
CREATE TYPE verdict AS ENUM ('Accepted', 'Wrong Answer', 'Time Limit Exceeded', 'Runtime Error', 'Compilation Error');

-- problems table
CREATE TABLE problems (
    id SERIAL PRIMARY KEY, 
    title VARCHAR(255) NOT NULL,
    description TEXT,
    difficulty difficulty NOT NULL,  -- Using your custom type
    constraints TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP 
);

-- topics table
CREATE TABLE topics (
    id SERIAL PRIMARY KEY, 
    name VARCHAR(100) UNIQUE NOT NULL
);

-- problems_topics mapping table
CREATE TABLE problems_topics (
    problem_id INT NOT NULL,
    topic_id INT NOT NULL,
    PRIMARY KEY (problem_id, topic_id),
    FOREIGN KEY (problem_id) REFERENCES problems(id) ON DELETE CASCADE, 
    FOREIGN KEY (topic_id) REFERENCES topics(id) ON DELETE CASCADE 
);

-- test_cases table
CREATE TABLE test_cases (
    id SERIAL PRIMARY KEY,
    problem_id INT NOT NULL,
    input TEXT,
    expected_output TEXT,
    FOREIGN KEY (problem_id) REFERENCES problems(id) ON DELETE CASCADE 
);

-- users table
CREATE TABLE users (
    id SERIAL PRIMARY KEY, 
    username VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL, 
    registered_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP 
);

-- submissions table
CREATE TABLE submissions (
    id SERIAL PRIMARY KEY, 
    user_id INT NOT NULL,
    problem_id INT NOT NULL,
    code TEXT NOT NULL,
    language VARCHAR(50) NOT NULL,
    verdict verdict NOT NULL, 
    execution_time FLOAT, 
    submitted_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (problem_id) REFERENCES problems(id) ON DELETE CASCADE 
);
