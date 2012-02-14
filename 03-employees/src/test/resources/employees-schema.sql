DROP TABLE IF EXISTS SALARIES; 
DROP TABLE IF EXISTS EMPLOYEES; 
CREATE TABLE employees (
    id          INT             NOT NULL,
    birth_date  DATE            NOT NULL,
    first_name  VARCHAR(14)     NOT NULL,
    last_name   VARCHAR(16)     NOT NULL,
    gender      char(1)         NOT NULL,    
    hire_date   DATE            NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE salaries (
    id          VARCHAR(36)     NOT NULL,
    emp_no      INT             NOT NULL,
    amount      INT             NOT NULL,
    from_date   DATE            NOT NULL,
    to_date     DATE            NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (emp_no) REFERENCES employees (id) ON DELETE CASCADE,
    UNIQUE KEY (emp_no, from_date)
);
