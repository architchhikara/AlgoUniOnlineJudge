INSERT INTO problems (title, description, difficulty, constraints) VALUES
('Two Sum', 'Given an array of integers, return indices of the two numbers such that they add up to a specific target.', 'EASY', 'Time Limit: 2 seconds'),
('FizzBuzz', 'Write a program that prints the numbers from 1 to 100, replacing multiples of 3 with "Fizz", multiples of 5 with "Buzz", and multiples of both with "FizzBuzz".', 'EASY', 'Time Limit: 1 second'),
('Binary Search', 'Implement binary search to efficiently find a target value in a sorted array.', 'MEDIUM', 'Time Limit: 2 seconds');


INSERT INTO topics (name) VALUES
('Arrays'), 
('Strings'),
('Algorithms'),
('Search');


INSERT INTO problems_topics (problem_id, topic_id) VALUES
(1, 1), --  Two Sum -> Arrays
(2, 2), -- FizzBuzz -> Strings
(3, 3); -- Binary Search -> Algorithms, Search 

-- Test Cases for 'Two Sum' (problem id 1)
INSERT INTO test_cases (problem_id, input, expected_output) VALUES
(1, '[2, 7, 11, 15], 9', '[0, 1]'), 
(1, '[3, 2, 4], 6', '[1, 2]');


-- Remember to hash passwords securely! This is just for demonstration
INSERT INTO users (username, email, password_hash) VALUES 
('coding_enthusiast', 'enthusiast@email.com', '$2a$10$...'), -- Example bcrypt hash
('algomaster', 'master@email.com', '$2a$10$...');


INSERT INTO submissions (user_id, problem_id, code, language, verdict, execution_time) VALUES 
(1, 1, '// Python code...', 'Python', 'Accepted', 0.12), 
(2, 1, '// C++ code...', 'C++', 'Wrong Answer', 0.25), 
(1, 3, '// Java code...', 'Java', 'Time Limit Exceeded', 2.5); 
