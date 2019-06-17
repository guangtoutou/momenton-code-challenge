DROP TABLE employees IF EXISTS;


CREATE TABLE employees (
  id         INTEGER IDENTITY PRIMARY KEY,
  employee_name VARCHAR(30),
  manager_id  INTEGER
);

