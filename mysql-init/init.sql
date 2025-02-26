CREATE DATABASE IF NOT EXISTS todo;
USE todo;

CREATE TABLE IF NOT EXISTS tasks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(255) NOT NULL,
    start_date DATE NOT NULL,
    target_date DATE NOT NULL,
    status ENUM('TODO', 'WIP', 'DONE') NOT NULL
);
