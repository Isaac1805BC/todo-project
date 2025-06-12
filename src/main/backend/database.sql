CREATE TABLE User (
    id SERIAL,
    username VARCHAR(30),
    email VARCHAR(100),
    password VARCHAR(100)
);

CREATE TABLE Statistic (
    id SERIAL,
    period VARCHAR(30),
    progress VARCHAR(30),
    user_id INTEGER
);

CREATE TABLE Record (
    id SERIAL,
    type VARCHAR(30),
    date DATE,
    description VARCHAR(300),
    user_id INTEGER
);

CREATE TABLE Category (
    id SERIAL,
    name VARCHAR(30)
);

CREATE TABLE Task (
    id SERIAL,
    title VARCHAR(30),
    description VARCHAR(500),
    due_date DATE,
    completed BOOLEAN,
    priority VARCHAR(30),
    creation_date DATE,
    category_id INTEGER,
    user_id INTEGER
);

CREATE TABLE Label (
    id SERIAL,
    name VARCHAR(30)
);

CREATE TABLE Task_Label (
    task_id INTEGER,
    label_id INTEGER
);

CREATE TABLE Timer (
    id SERIAL,
    started_time TIME,
    end_time TIME,
    duration TIME,
    range VARCHAR(30),
    task_id INTEGER
);

CREATE TABLE Notification (
    id SERIAL,
    type VARCHAR(30),
    message VARCHAR(400),
    date DATE,
    delivered BOOLEAN,
    task_id INTEGER
);

CREATE TABLE Subtask (
    id SERIAL,
    parent_task_id INTEGER,
    subtask_id INTEGER
);

-- Claves primarias
ALTER TABLE User ADD PRIMARY KEY (id);
ALTER TABLE Statistic ADD PRIMARY KEY (id);
ALTER TABLE Record ADD PRIMARY KEY (id);
ALTER TABLE Category ADD PRIMARY KEY (id);
ALTER TABLE Task ADD PRIMARY KEY (id);
ALTER TABLE Label ADD PRIMARY KEY (id);
ALTER TABLE Timer ADD PRIMARY KEY (id);
ALTER TABLE Notification ADD PRIMARY KEY (id);
ALTER TABLE Subtask ADD PRIMARY KEY (id);
ALTER TABLE Task_Label ADD PRIMARY KEY (task_id, label_id);

-- Claves foráneas
ALTER TABLE Statistic ADD CONSTRAINT fk_statistic_user FOREIGN KEY (user_id) REFERENCES User(id);
ALTER TABLE Record ADD CONSTRAINT fk_record_user FOREIGN KEY (user_id) REFERENCES User(id);
ALTER TABLE Task ADD CONSTRAINT fk_task_category FOREIGN KEY (category_id) REFERENCES Category(id);
ALTER TABLE Task ADD CONSTRAINT fk_task_user FOREIGN KEY (user_id) REFERENCES User(id);
ALTER TABLE Task_Label ADD CONSTRAINT fk_tasklabel_task FOREIGN KEY (task_id) REFERENCES Task(id);
ALTER TABLE Task_Label ADD CONSTRAINT fk_tasklabel_label FOREIGN KEY (label_id) REFERENCES Label(id);
ALTER TABLE Timer ADD CONSTRAINT fk_timer_task FOREIGN KEY (task_id) REFERENCES Task(id);
ALTER TABLE Notification ADD CONSTRAINT fk_notification_task FOREIGN KEY (task_id) REFERENCES Task(id);
ALTER TABLE Subtask ADD CONSTRAINT fk_subtask_parent FOREIGN KEY (parent_task_id) REFERENCES Task(id);
ALTER TABLE Subtask ADD CONSTRAINT fk_subtask_sub FOREIGN KEY (subtask_id) REFERENCES Task(id);